package com.mediclarify.api.controller;

import com.mediclarify.api.dto.PatientRegistrationRequest;
import com.mediclarify.api.service.PatientRegistrationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/patients")
public class PatientController {
    @Autowired
    private PatientRegistrationService patientRegistrationService;

    @PostMapping("/register")
    public ResponseEntity<String> registerPatient(@RequestBody PatientRegistrationRequest request) {
        try {
            patientRegistrationService.registerNewPatient(request.getPatientId(), request.getName(), request.getEmail());
            return ResponseEntity.ok("Success: Patient registered!");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Error registering patient.");
        }
    }
}
