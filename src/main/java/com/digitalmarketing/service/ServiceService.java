package com.digitalmarketing.service;

import com.digitalmarketing.dto.ServiceRequest;
import com.digitalmarketing.model.Service;
import com.digitalmarketing.repository.ServiceRepository;
import lombok.RequiredArgsConstructor;

import java.util.List;

@org.springframework.stereotype.Service
@RequiredArgsConstructor
public class ServiceService {

    private final ServiceRepository serviceRepository;

    public List<Service> getAllServices() {
        return serviceRepository.findAll();
    }

    public Service createService(ServiceRequest request) {
        Service service = new Service();
        service.setTitle(request.getTitle());
        service.setDescription(request.getDescription());
        service.setPrice(request.getPrice());
        service.setActive(request.getActive());
        return serviceRepository.save(service);
    }

    public Service updateService(String id, ServiceRequest request) {
        Service existing = serviceRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Service not found"));

        existing.setTitle(request.getTitle());
        existing.setDescription(request.getDescription());
        existing.setPrice(request.getPrice());
        existing.setActive(request.getActive());

        return serviceRepository.save(existing);
    }

    public void deleteService(String id) {
        serviceRepository.deleteById(id);
    }
}
