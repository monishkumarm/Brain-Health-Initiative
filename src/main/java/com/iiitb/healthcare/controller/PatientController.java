package com.iiitb.healthcare.controller;

import com.iiitb.healthcare.model.CustomUserDetails;
import com.iiitb.healthcare.model.entities.PatientEntity;
import com.iiitb.healthcare.services.PatientEntityService;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
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
    public ResponseEntity<?> getAllPatients() {
        var loggedInUserId = getLoggedInUserId();
        List<List<PatientEntity>> patients = patientEntityService.getAllPatients(loggedInUserId);
        return ResponseEntity.ok(patients);
    }

//    @RequestMapping("/getAllPatientByUser")
//    public ResponseEntity<?> getAllPatientByUser() {
//        var loggedInUserId = getLoggedInUserId();
//        List<PatientEntity> patients = patientEntityService.getAllPatientByUser(loggedInUserId);
//        return ResponseEntity.ok(patients);
//    }

    @RequestMapping(value = "/addPatient", method = RequestMethod.POST)
    public ResponseEntity<?> addPatient(@RequestBody Map<String, Object> payload) {
        var loggedInUserId = getLoggedInUserId();
        String s = patientEntityService.addPatient(payload, loggedInUserId);
        Map<String,String> res = new HashMap<>();
        res.put("msg",s);
        return ResponseEntity.ok(res);
    }

    @RequestMapping(value = "/getSearchPatients", method = RequestMethod.POST)
    public ResponseEntity<?> getSearchPatients(@RequestBody Map<String, Object> payload) {
        List<PatientEntity> patients = patientEntityService.getSearchPatients(payload);
        return ResponseEntity.ok(patients);
    }


    @RequestMapping(value = "/updatePatient", method = RequestMethod.POST)
    public ResponseEntity<?> updatePatient(@RequestBody Map<String, Object> payload) throws Exception {
        var loggedInUserId = getLoggedInUserId();
        boolean hasPermission = patientEntityService.checkPermission(payload, loggedInUserId);
        if (!hasPermission) {
            throw new Exception("User dont have update permission");
        }
        PatientEntity patient = patientEntityService.updatePatients(payload, loggedInUserId);
        return ResponseEntity.ok(patient);
    }

    private Long getLoggedInUserId() {
        var auth = SecurityContextHolder.getContext().getAuthentication();
        var loggedInUser = (CustomUserDetails) auth.getPrincipal();
        return loggedInUser.getUserId();
    }
}
