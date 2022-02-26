package com.iiitb.healthcare.controller;

import com.iiitb.healthcare.model.entities.PatientConsultationEntity;
import com.iiitb.healthcare.services.ConsultationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
public class ConsultationController {

    @Autowired
    private ConsultationService consultationService;

    @RequestMapping(value = "/patients/{patientId}")
    public List<PatientConsultationEntity> getPatientConsultations(@PathVariable Integer patientId) {
        return this.consultationService.getPatientConsultations(patientId);
    }

    @RequestMapping(value = "/patients/consultation/{id}")
    public PatientConsultationEntity getConsultationRecord(@PathVariable Integer id) {
        return this.consultationService.getConsultationRecord(id);
    }

}
