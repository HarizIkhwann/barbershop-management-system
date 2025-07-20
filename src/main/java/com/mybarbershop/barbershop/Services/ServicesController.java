package com.mybarbershop.barbershop.Services;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/services")
public class ServicesController {
    private final ServicesService servicesService;

    public ServicesController(ServicesService servicesService) {
        this.servicesService = servicesService;
    }

    @PostMapping
    public void createService(@RequestBody Services service) {
        servicesService.createService(service);
    }

    @GetMapping("/{id}")
    public Services getServiceById(@PathVariable Long id) {
        return servicesService.getServiceById(id);
    }

    @DeleteMapping("/{id}")
    public void deleteService(@PathVariable Long id) {
        servicesService.deleteService(id);
    }

    @GetMapping
    public List<Services> getAllServices() {
        return servicesService.getAllServices();
    }

    @PutMapping("/{id}")
    public Services updateService(@PathVariable Long id, @RequestBody Services updatedService) {
        return servicesService.updateService(id, updatedService);
    }

}
