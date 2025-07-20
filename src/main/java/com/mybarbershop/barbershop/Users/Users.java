package com.mybarbershop.barbershop.Users;

import com.mybarbershop.barbershop.Appointments.Appointments;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

import java.util.List;

@Entity
public class Users {
    @Id
    @GeneratedValue
    private Long userId;
    private String name;
    private String email;
    private String password;
    private String phoneNo;
    private String role;

    @OneToMany(mappedBy = "user")
    private List<Appointments> appointments;

    public Users() {
    }

    public Users(String name, String email, String password, String phoneNo, String role, List<Appointments> appointments) {
        this.name = name;
        this.email = email;
        this.password = password;
        this.phoneNo = phoneNo;
        this.role = role;
        this.appointments = appointments;
    }

    public Users(Long userId, String name, String email, String password, String phoneNo, String role, List<Appointments> appointments) {
        this.userId = userId;
        this.name = name;
        this.email = email;
        this.password = password;
        this.phoneNo = phoneNo;
        this.role = role;
        this.appointments = appointments;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPhoneNo() {
        return phoneNo;
    }

    public void setPhoneNo(String phoneNo) {
        this.phoneNo = phoneNo;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public List<Appointments> getAppointments() {
        return appointments;
    }

    public void setAppointments(List<Appointments> appointments) {
        this.appointments = appointments;
    }
}
