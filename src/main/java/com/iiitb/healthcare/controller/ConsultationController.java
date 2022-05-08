package com.iiitb.healthcare.controller;

import com.iiitb.healthcare.model.CustomUserDetails;
import com.iiitb.healthcare.model.entities.PatientConsultationEntity;
import com.iiitb.healthcare.services.ConsultationService;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@CrossOrigin("*")
public class ConsultationController {

    private final ConsultationService consultationService;

    public ConsultationController(ConsultationService consultationService) {
        this.consultationService = consultationService;
    }

    @RequestMapping(value = "/patients/getAllConsultations")
    public ResponseEntity<?> getPatientConsultations(@RequestParam Map<String, String> param) {
        List<PatientConsultationEntity> patientConsultationEntities = this.consultationService.getPatientConsultations(Long.parseLong(param.get("patientId")));
        return ResponseEntity.ok(patientConsultationEntities);
    }

    @RequestMapping(value = "/patients/consultation/{id}")
    public PatientConsultationEntity getConsultationRecord(@PathVariable Integer id) {
        return this.consultationService.getConsultationRecord(id);
    }

    @RequestMapping(value = "/patients/addConsultation")
    public ResponseEntity<?> addConsultationRecord(@RequestBody Map<String, Object> payload, @RequestHeader Map<String, String> headers, @RequestParam Map<String, String> param) {
        var loggedInUserId = getLoggedInUserId();
        String res = consultationService.addConsultationRecord(payload, loggedInUserId, param.get("abhaId"));
        return ResponseEntity.ok(res);
    }

    private Long getLoggedInUserId() {
        var auth = SecurityContextHolder.getContext().getAuthentication();
        var loggedInUser = (CustomUserDetails) auth.getPrincipal();
        return loggedInUser.getUserId();
    }
}
