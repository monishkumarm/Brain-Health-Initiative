package com.iiitb.healthcare.controller;

import com.iiitb.healthcare.model.entities.OrganizationEntity;
import com.iiitb.healthcare.services.OrganizationEntityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RequestMapping("/admin")
@RestController
@CrossOrigin("*")
public class AdminController {
    @Autowired
    private OrganizationEntityService organizationEntityService;

    @RequestMapping(value = "/addHospital",method = RequestMethod.POST)
    public ResponseEntity<?> addHospital(@RequestBody Map<String,Object> payload, @RequestHeader Map<String,String> headers) throws Exception{
        String res = organizationEntityService.addHospital(payload,headers.get("authorization"));
        return ResponseEntity.ok(payload);
    }
    @RequestMapping(value = "/getAllOrganizations")
    public ResponseEntity<?> getAllOrganizations(@RequestHeader Map<String,String> headers){
      List<OrganizationEntity> orgs = organizationEntityService.getAllOrganizations();
      return ResponseEntity.ok(orgs);
    }

}
