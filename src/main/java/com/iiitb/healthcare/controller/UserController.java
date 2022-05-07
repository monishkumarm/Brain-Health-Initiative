package com.iiitb.healthcare.controller;


import com.iiitb.healthcare.model.entities.UserEntity;
import com.iiitb.healthcare.services.UserEntityService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin("*")
public class UserController {

    private final UserEntityService userEntityService;

    public UserController(UserEntityService userEntityService) {
        this.userEntityService = userEntityService;
    }

    @RequestMapping("/getSpecialists")
    public ResponseEntity<?> getAllSpecialists(){
        List<UserEntity> specialists = userEntityService.getAllSpecialists();
        return ResponseEntity.ok(specialists);
    }

}
