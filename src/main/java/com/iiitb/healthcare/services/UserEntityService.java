package com.iiitb.healthcare.services;

import com.iiitb.healthcare.model.entities.UserEntity;
import com.iiitb.healthcare.repo.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

@Service
public class UserEntityService {

    @Autowired
    private UserRepository userRepository;

    public List<UserEntity> getAllSpecialists(){
        List<UserEntity> specilists = new ArrayList<UserEntity>();
        userRepository.getAllSpecilists().forEach(user->specilists.add(user));
        return specilists;
    }
    public UserEntity getUserByName(String name){
        UserEntity user = userRepository.findByUsername(name);
        return user;
    }
    public UserEntity getDetails(){
        UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication()
                .getPrincipal();
        String username = userDetails.getUsername();
        UserEntity user = userRepository.findByUsername(username);
        return user;
    }
    public String addUser(Map<String,Object> payload, UserEntity u){
        try{
            UserEntity user = new UserEntity();
            user.setFirstName((String)payload.get("firstname"));
            user.setLastName((String)payload.get("lastname"));
            user.setUsername((String)payload.get("username"));
            user.setEmail((String)payload.get("email"));
            user.setPhoneNumber(String.valueOf(payload.get("phone")));
            user.setPassword((String)payload.get("password"));
            Map<String,Object> map = (Map)payload.get("roletype");
            user.setRoleTypeId(Integer.parseInt((String) map.get("id") ));
            String address = "{ \"addLine1\": \"" + (String) payload.get("addLine1") + "\" ,";
            address = address + "\"district\": \"" + (String) payload.get("district") + "\" ,";
            address = address + "\"state\": \"" + (String) payload.get("state") + "\" ,";
            address = address + "\"pin\": \"" + String.valueOf(payload.get("pincode")) + "\" }";
            user.setAddressDetail(address);
            Date date = new Date();
            user.setCreatedOn(new Timestamp(date.getTime()));
            user.setLastChangeOn(new Timestamp(date.getTime()));
            user.setActive(true);
            user.setTimeZoneId(1);
            user.setCreatedBy(u.getId());
            user.setLastChangeBy(u.getId());
            UserEntity newUser = userRepository.save(user);
            return String.valueOf(user.getId());
        }
        catch (Exception e){
            e.printStackTrace();
            return e.getMessage();
        }

    }
}
