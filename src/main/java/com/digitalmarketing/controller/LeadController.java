package com.digitalmarketing.controller;

import com.digitalmarketing.dto.LeadRequest;
import com.digitalmarketing.model.Lead;
import com.digitalmarketing.service.LeadService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/leads")
@RequiredArgsConstructor
public class LeadController {

    private final LeadService leadService;

    @PostMapping
    public ResponseEntity<Lead> createLead(@Valid @RequestBody LeadRequest request) {
        return ResponseEntity.ok(leadService.createLead(request));
    }

    @GetMapping
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<List<Lead>> getLeads() {
        return ResponseEntity.ok(leadService.getAllLeads());
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<Void> deleteLead(@PathVariable String id) {
        leadService.deleteLead(id);
        return ResponseEntity.noContent().build();
    }
}
