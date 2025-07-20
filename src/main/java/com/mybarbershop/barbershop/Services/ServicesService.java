package com.mybarbershop.barbershop.Services;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServicesService {
    private final ServicesRepository servicesRepository;

    public ServicesService(ServicesRepository servicesRepository) {
        this.servicesRepository = servicesRepository;
    }

    public void createService(Services service) {
        servicesRepository.save(service);
    }

    public Services getServiceById(Long id) {
        return servicesRepository.findById(id).orElse(null);
    }

    public void deleteService(Long id) {
        servicesRepository.deleteById(id);
    }
    public List<Services> getAllServices() {
        return servicesRepository.findAll();
    }

    public Services updateService(Long id, Services updatedService) {
        if (!servicesRepository.existsById(id)) {
            throw new RuntimeException("Service not found with id: " + id);
        }
        updatedService.setServiceId(id);
        return servicesRepository.save(updatedService);
    }

}
