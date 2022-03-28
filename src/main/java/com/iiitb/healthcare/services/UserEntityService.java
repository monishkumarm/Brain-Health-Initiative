package com.iiitb.healthcare.services;

import com.iiitb.healthcare.model.entities.UserEntity;
import com.iiitb.healthcare.repo.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserEntityService {

    @Autowired
    private UserRepository userRepository;

    public List<UserEntity> getAllSpecialists(){
        List<UserEntity> specilists = new ArrayList<UserEntity>();
        userRepository.getAllSpecilists().forEach(user->specilists.add(user));
        return specilists;
    }
}
