package com.mybarbershop.barbershop.Appointments;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/appointments")
public class AppointmentsController {
    private final AppointmentsService appointmentsService;

    public AppointmentsController(AppointmentsService appointmentsService) {
        this.appointmentsService = appointmentsService;
    }

    @PostMapping
    public void createAppointment(@RequestBody Appointments appointment) {
        appointmentsService.createAppointment(appointment);
    }

    @GetMapping("/{id}")
    public Appointments getAppointmentById(@PathVariable Long id) {
        return appointmentsService.getAppointmentById(id);
    }

    @GetMapping
    public List<Appointments> getAllAppointments() {
        return appointmentsService.getAllAppointments();
    }

    @DeleteMapping("/{id}")
    public void deleteAppointment(@PathVariable Long id) {
        appointmentsService.deleteAppointment(id);
    }

    @PutMapping("/{id}")
    public Appointments updateAppointment(@PathVariable Long id,@RequestBody Appointments updatedAppointment) {
        return appointmentsService.updateAppointment(id, updatedAppointment);
    }
}
