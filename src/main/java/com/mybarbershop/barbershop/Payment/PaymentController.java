package com.mybarbershop.barbershop.Payment;

import com.mybarbershop.barbershop.Appointments.Appointments;
import com.mybarbershop.barbershop.Appointments.AppointmentsRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/payment")
public class PaymentController {

    private final PaymentService paymentService;
    private final AppointmentsRepository appointmentsRepository;

    public PaymentController(PaymentService paymentService, AppointmentsRepository appointmentsRepository) {
        this.paymentService = paymentService;
        this.appointmentsRepository = appointmentsRepository;
    }

    @PostMapping("/{id}/pay")
    public ResponseEntity<String> createPaymentLink(@PathVariable Long id) {
        Appointments appointment = appointmentsRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Appointment not found"));

        // Build your payment bill model
        Payment bill = new Payment();
        bill.setBillName("Barber Booking - " + appointment.getService().getServiceName());
        bill.setBillDescription("Haircut Booking");
        bill.setAmount(appointment.getService().getPrice());
        bill.setBillExternalReferenceNo("APPT-" + appointment.getAppointmentId());
        bill.setBillTo(appointment.getUser().getName());
        bill.setBillEmail(appointment.getUser().getEmail());
        bill.setBillPhone(appointment.getUser().getPhoneNo());

        // Call payment service
        String paymentUrl = paymentService.createBill(bill);

        // Save URL in appointment
        appointment.setPaymentUrl(paymentUrl);
        appointmentsRepository.save(appointment);

        // Return payment link to frontend
        return ResponseEntity.ok(paymentUrl);
    }

    @PostMapping("/callback")
    public ResponseEntity<String> handleCallback(
            @RequestParam("billCode") String billCode,
            @RequestParam("billpaymentStatus") String billPaymentStatus,
            @RequestParam("billExternalReferenceNo") String billExternalReferenceNo
    ) {
        System.out.println("ToyyibPay callback received:");
        System.out.println("Bill Code: " + billCode);
        System.out.println("Status: " + billPaymentStatus);
        System.out.println("External Ref: " + billExternalReferenceNo);

        try {
            String cleanStatus = billPaymentStatus.trim();
            String cleanRef = billExternalReferenceNo.trim();

            Long appointmentId = Long.parseLong(billExternalReferenceNo.replace("APPT-", ""));
            Appointments appointment = appointmentsRepository.findById(appointmentId)
                    .orElseThrow(() -> new RuntimeException("Appointment not found"));

            if ("1".equals(billPaymentStatus)) {
                appointment.setPaymentStatus("PAID");
                appointment.setStatus("CONFIRMED");
            } else {
                appointment.setPaymentStatus("FAILED");
                appointment.setStatus("PENDING");
            }

            appointmentsRepository.save(appointment);

            return ResponseEntity.ok("Callback processed");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Callback failed: " + e.getMessage());
        }
    }
}
