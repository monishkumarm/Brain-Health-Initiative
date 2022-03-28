package com.iiitb.healthcare.controller;

import com.iiitb.healthcare.model.entities.PatientConsultationEntity;
import com.iiitb.healthcare.services.ConsultationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@CrossOrigin("*")
public class ConsultationController {

    @Autowired
    private ConsultationService consultationService;

    @RequestMapping(value = "/patients/getAllConsultations")
    public ResponseEntity<?> getPatientConsultations(@RequestParam Map<String,String> param) {
        System.out.println(("in get consultation api"));
        List<PatientConsultationEntity> patientConsultationEntities =  this.consultationService.getPatientConsultations(Long.parseLong(param.get("patientId")));
        return  ResponseEntity.ok(patientConsultationEntities);
    }

    @RequestMapping(value = "/patients/consultation/{id}")
    public PatientConsultationEntity getConsultationRecord(@PathVariable Integer id) {
        return this.consultationService.getConsultationRecord(id);
    }

    @RequestMapping(value = "/patients/addConsultation")
    public ResponseEntity<?> addConsultationRecord(@RequestBody Map<String,Object> payload,@RequestHeader Map<String,String> headers,@RequestParam Map<String,String> param){
        System.out.println("In add consultation record api");
        String res = consultationService.addConsultationRecord(payload,headers.get("authorization"),param.get("abhaId"));
        return ResponseEntity.ok(res);
    }


}
