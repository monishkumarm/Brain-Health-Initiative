package com.iiitb.healthcare.services;

import com.iiitb.healthcare.model.entities.UserOrganizationEntity;
import com.iiitb.healthcare.repo.UserOrganizationRepo;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class UserOrganizationService {
    private final UserOrganizationRepo userOrganizationRepo;

    public UserOrganizationService(UserOrganizationRepo userOrganizationRepo) {
        this.userOrganizationRepo = userOrganizationRepo;
    }

    public void addUserOrganization(ArrayList<Integer> list, String id) {
        try {
            for (Integer integer : list) {
                UserOrganizationEntity uo = new UserOrganizationEntity();
                uo.setUserId(Long.parseLong(id));
                uo.setOrganizationId(Long.valueOf(integer));
                userOrganizationRepo.save(uo);
            }
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
    }
}
