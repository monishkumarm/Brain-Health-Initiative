package com.iiitb.healthcare.controller;

import com.iiitb.healthcare.model.entities.OrganizationEntity;
import com.iiitb.healthcare.model.entities.UserEntity;
import com.iiitb.healthcare.services.OrganizationEntityService;
import com.iiitb.healthcare.services.UserEntityService;
import com.iiitb.healthcare.services.UserOrganizationService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@RequestMapping("/admin")
@RestController
@CrossOrigin("*")
public class AdminController {
    private final OrganizationEntityService organizationEntityService;

    private final UserOrganizationService userOrganizationService;

    private final UserEntityService userEntityService;

    public AdminController(OrganizationEntityService organizationEntityService, UserOrganizationService userOrganizationService, UserEntityService userEntityService) {
        this.organizationEntityService = organizationEntityService;
        this.userOrganizationService = userOrganizationService;
        this.userEntityService = userEntityService;
    }

    @RequestMapping(value = "/addHospital", method = RequestMethod.POST)
    public ResponseEntity<?> addHospital(@RequestBody Map<String, Object> payload) {
        String res = organizationEntityService.addHospital(payload);
        return ResponseEntity.ok(payload);
    }

    @RequestMapping(value = "/getAllOrganizations")
    public ResponseEntity<?> getAllOrganizations() {
        List<OrganizationEntity> organizations = organizationEntityService.getAllOrganizations();
        return ResponseEntity.ok(organizations);
    }

    @RequestMapping(value = "/getDiagnosisChartData")
    public ResponseEntity<?> getDiagnosisChartData() {
        var diagnosisCountChart = organizationEntityService.getDiagnosisCountChart();
        return ResponseEntity.ok(diagnosisCountChart);
    }

    @RequestMapping(value = "/addUser", method = RequestMethod.POST)
    public ResponseEntity<?> addUser(@RequestBody Map<String, Object> payload) {
        UserEntity user = userEntityService.getDetails();
        String id = userEntityService.addUser(payload, user);
        userOrganizationService.addUserOrganization((ArrayList<Integer>) payload.get("orgs"), id);
        return ResponseEntity.ok(payload);
    }
}
