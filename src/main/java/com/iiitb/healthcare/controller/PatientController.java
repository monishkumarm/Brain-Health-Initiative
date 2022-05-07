package com.iiitb.healthcare.controller;

import com.iiitb.healthcare.model.entities.PatientEntity;
import com.iiitb.healthcare.services.PatientEntityService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@CrossOrigin("*")
public class PatientController {

    private final PatientEntityService patientEntityService;

    public PatientController(PatientEntityService patientEntityService) {
        this.patientEntityService = patientEntityService;
    }

    @RequestMapping("/getAllPatients")
    public ResponseEntity<?> getAllPatients(){
        List<PatientEntity> patients = patientEntityService.getAllPatients();
        return ResponseEntity.ok(patients);
    }

    @RequestMapping("/getAllPatientByUser")
    public  ResponseEntity<?> getAllPatientByUser(@RequestHeader Map<String,String> headers){
        List<PatientEntity> patients = patientEntityService.getAllPatientByUser(headers.get("authorization"));
        return ResponseEntity.ok(patients);
    }

    @RequestMapping(value="/addPatient", method = RequestMethod.POST)
    public ResponseEntity<?> addPatient(@RequestBody Map<String,Object> payload, @RequestHeader Map<String,String> headers) {
        String res = patientEntityService.addPatient(payload,headers.get("authorization"));
        return  ResponseEntity.ok(res);
    }

    @RequestMapping(value = "/getSearchPatients",method = RequestMethod.POST)
    public ResponseEntity<?> getSearchPatients(@RequestBody Map<String,Object> payload) {
        List<PatientEntity> patients = patientEntityService.getSearchPatients(payload);
        return ResponseEntity.ok(patients);
    }


    @RequestMapping(value = "/updatePatient",method = RequestMethod.POST)
    public ResponseEntity<?> updatePatien(@RequestBody Map<String,Object> payload, @RequestHeader Map<String,String> headers) throws Exception{
        boolean hasPermission = patientEntityService.checkPermission(payload,headers.get("authorization"));
        if(!hasPermission)
        {
            throw new Exception("User dont have update permission");
        }
        PatientEntity patient = patientEntityService.updatePatients(payload,headers.get("authorization"));
        return ResponseEntity.ok(patient);
    }

}
