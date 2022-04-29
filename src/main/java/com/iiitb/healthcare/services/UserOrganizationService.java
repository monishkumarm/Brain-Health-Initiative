package com.iiitb.healthcare.services;

import com.iiitb.healthcare.model.entities.UserEntity;
import com.iiitb.healthcare.model.entities.UserOrganizationEntity;
import com.iiitb.healthcare.repo.UserOrganizationRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Map;

@Service
public class UserOrganizationService {
    @Autowired
    private UserOrganizationRepo userOrganizationRepo;

    public void addUserOrganization(ArrayList<Integer> list, String id){
        try{

            for(int i=0;i<list.size();i++){
                UserOrganizationEntity uo = new UserOrganizationEntity();
                uo.setUserId(Long.valueOf(id));
                uo.setOrganizationId(Long.valueOf(list.get(i)));
                userOrganizationRepo.save(uo);
            }
        }
        catch (Exception e){
            e.printStackTrace();
            throw e;
        }
    }
}
