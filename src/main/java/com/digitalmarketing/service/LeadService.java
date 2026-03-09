package com.digitalmarketing.service;

import com.digitalmarketing.dto.LeadRequest;
import com.digitalmarketing.model.Lead;
import com.digitalmarketing.repository.LeadRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.List;

@Service
@RequiredArgsConstructor
public class LeadService {

    private final LeadRepository leadRepository;

    public Lead createLead(LeadRequest request) {
        Lead lead = new Lead();
        lead.setName(request.getName());
        lead.setEmail(request.getEmail());
        lead.setPhone(request.getPhone());
        lead.setServiceInterested(request.getServiceInterested());
        lead.setMessage(request.getMessage());
        lead.setCreatedAt(Instant.now());
        return leadRepository.save(lead);
    }

    public List<Lead> getAllLeads() {
        return leadRepository.findAll();
    }

    public void deleteLead(String id) {
        leadRepository.deleteById(id);
    }
}
