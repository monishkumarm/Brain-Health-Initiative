package com.iiitb.healthcare.services;

import com.iiitb.healthcare.model.entities.UserEntity;
import com.iiitb.healthcare.repo.UserRepository;
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

    private final UserRepository userRepository;

    public UserEntityService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<UserEntity> getAllSpecialists() {
        return new ArrayList<>(userRepository.getAllSpecialists());
    }

    public UserEntity getUserByName(String name) {
        return userRepository.findByUsername(name);
    }

    public UserEntity getDetails() {
        UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication()
                .getPrincipal();
        String username = userDetails.getUsername();
        return userRepository.findByUsername(username);
    }

    public String addUser(Map<String, Object> payload, UserEntity u) {
        try {
            UserEntity user = new UserEntity();
            user.setFirstName((String) payload.get("firstname"));
            user.setLastName((String) payload.get("lastname"));
            user.setUsername((String) payload.get("username"));
            user.setEmail((String) payload.get("email"));
            user.setPhoneNumber(String.valueOf(payload.get("phone")));
            user.setPassword((String) payload.get("password"));
            Map<String, Object> map = (Map) payload.get("roletype");
            user.setRoleTypeId(Integer.parseInt((String) map.get("id")));
            String address = "{ \"addLine1\": \"" + payload.get("addLine1") + "\" ,";
            address = address + "\"district\": \"" + payload.get("district") + "\" ,";
            address = address + "\"state\": \"" + payload.get("state") + "\" ,";
            address = address + "\"pin\": \"" + payload.get("pincode") + "\" }";
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
        } catch (Exception e) {
            e.printStackTrace();
            return e.getMessage();
        }

    }
}
