package com.iiitb.healthcare.controller;


import com.iiitb.healthcare.model.entities.UserEntity;
import com.iiitb.healthcare.services.UserEntityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin("*")
public class UserController {

    @Autowired
    private UserEntityService userEntityService;

    @RequestMapping("/getSpecialists")
    public ResponseEntity<?> getAllSpecilist(){
        System.out.println("In get all specilist api");
        List<UserEntity> specilists = userEntityService.getAllSpecialists();
        return ResponseEntity.ok(specilists);
    }
}
