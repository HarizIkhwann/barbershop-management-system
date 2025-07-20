package com.mybarbershop.barbershop.Appointments;

import com.mybarbershop.barbershop.Services.Services;
import com.mybarbershop.barbershop.Users.Users;
import jakarta.persistence.*;

import java.time.LocalDate;
import java.time.LocalTime;

@Entity
public class Appointments {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long appointmentId;

    @ManyToOne
    @JoinColumn(name = "userId")
    private Users user;

    @ManyToOne
    @JoinColumn(name = "serviceId")
    private Services service;
    private LocalDate date;
    private LocalTime time;
    private String status;
    private String paymentMethod;
    private String paymentStatus;
    private String paymentUrl;


    public Appointments() {
    }

    public Appointments(Users user, Services service, LocalDate date, LocalTime time, String status, String paymentMethod, String paymentStatus) {
        this.user = user;
        this.service = service;
        this.date = date;
        this.time = time;
        this.status = status;
        this.paymentMethod = paymentMethod;
        this.paymentStatus = paymentStatus;
    }

    public Appointments(Long appointmentId, Users user, Services service, LocalDate date, LocalTime time, String status, String paymentMethod, String paymentStatus) {
        this.appointmentId = appointmentId;
        this.user = user;
        this.service = service;
        this.date = date;
        this.time = time;
        this.status = status;
        this.paymentMethod = paymentMethod;
        this.paymentStatus = paymentStatus;
    }

    public Long getAppointmentId() {
        return appointmentId;
    }

    public void setAppointmentId(Long appointmentId) {
        this.appointmentId = appointmentId;
    }

    public Users getUser() {
        return user;
    }

    public void setUser(Users user) {
        this.user = user;
    }

    public Services getService() {
        return service;
    }

    public void setService(Services service) {
        this.service = service;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public LocalTime getTime() {
        return time;
    }

    public void setTime(LocalTime time) {
        this.time = time;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(String paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public String getPaymentStatus() {
        return paymentStatus;
    }

    public void setPaymentStatus(String paymentStatus) {
        this.paymentStatus = paymentStatus;
    }

    public String getPaymentUrl() {
        return paymentUrl;
    }

    public void setPaymentUrl(String paymentUrl) {
        this.paymentUrl = paymentUrl;
    }
}
