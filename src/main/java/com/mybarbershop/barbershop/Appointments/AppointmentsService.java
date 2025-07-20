package com.mybarbershop.barbershop.Appointments;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AppointmentsService {
    private final AppointmentsRepository appointmentsRepository;

    public AppointmentsService(AppointmentsRepository appointmentsRepository) {
        this.appointmentsRepository = appointmentsRepository;
    }

    public void createAppointment(Appointments appointment) {
        appointmentsRepository.save(appointment);
    }

    public Appointments getAppointmentById(Long id) {
        return appointmentsRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Appointment not found with id: " + id));
    }

    public List<Appointments> getAllAppointments() {
        return appointmentsRepository.findAll();
    }

    public void deleteAppointment(Long id) {
        if (!appointmentsRepository.existsById(id)) {
            throw new RuntimeException("Appointment not found with id: " + id);
        }
        appointmentsRepository.deleteById(id);
    }

    public Appointments updateAppointment(Long id, Appointments updatedAppointment) {
        if (!appointmentsRepository.existsById(id)) {
            throw new RuntimeException("Appointment not found with id: " + id);
        }
        updatedAppointment.setAppointmentId(id);
        return appointmentsRepository.save(updatedAppointment);
    }


}
