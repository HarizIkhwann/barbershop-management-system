package com.mybarbershop.barbershop.Services;

import com.mybarbershop.barbershop.Appointments.Appointments;
import jakarta.persistence.*;

import java.util.List;

@Entity
public class Services {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long serviceId;
    private String serviceName;
    private Integer duration; // in minutes
    private Double price;

    @OneToMany(mappedBy = "service")
    private List<Appointments> appointments;

    public Services() {
    }

    public Services(String serviceName, Integer duration, Double price, List<Appointments> appointments) {
        this.serviceName = serviceName;
        this.duration = duration;
        this.price = price;
        this.appointments = appointments;
    }

    public Services(Long serviceId, String serviceName, Integer duration, Double price, List<Appointments> appointments) {
        this.serviceId = serviceId;
        this.serviceName = serviceName;
        this.duration = duration;
        this.price = price;
        this.appointments = appointments;
    }

    public Long getServiceId() {
        return serviceId;
    }

    public void setServiceId(Long serviceId) {
        this.serviceId = serviceId;
    }

    public String getServiceName() {
        return serviceName;
    }

    public void setServiceName(String serviceName) {
        this.serviceName = serviceName;
    }

    public Integer getDuration() {
        return duration;
    }

    public void setDuration(Integer duration) {
        this.duration = duration;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public List<Appointments> getAppointments() {
        return appointments;
    }

    public void setAppointments(List<Appointments> appointments) {
        this.appointments = appointments;
    }
}
