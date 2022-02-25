package com.iiitb.healthcare.services;

import com.iiitb.healthcare.helper.JwtUtil;
import com.iiitb.healthcare.model.entities.PatientEntity;
import com.iiitb.healthcare.model.entities.UserEntity;
import com.iiitb.healthcare.repo.PatientRepository;
import com.iiitb.healthcare.repo.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigInteger;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

@Service
public class PatientEntityService {

    @Autowired
    private PatientRepository patientRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private JwtUtil jwtUtil;

    public List<PatientEntity> getAllPatients(){
        List<PatientEntity> patients = new ArrayList<PatientEntity>();
        patientRepository.findAll().forEach(patient ->patients.add(patient));
        return patients;
    }

    public String addPatient(Map<String,Object> payload,String token){
        try {
            System.out.println("In add patient service");
            PatientEntity patient = new PatientEntity();
            patient.setAbhaId((String) payload.get("ABHAID"));
            String add1 = (String) payload.get("addLine1");
            String add2 = (String) payload.get("addLine2");
            patient.setAddressDetail("{ \"add1\":\"" + add1 + "\", \"add2\":\"" + add2 + "\"}");
            patient.setAge(Integer.parseInt((String) payload.get("age")) );
            UserEntity user = this.userRepository.findByUsername(this.jwtUtil.extractUsername(token.substring(7)));
            patient.setCreatedBy((long)user.getId());
            Date date = new Date();
            patient.setCreatedOn(new Timestamp(date.getTime()));
            patient.setEducation((String) payload.get("edu"));
            patient.setEmail((String) payload.get("email"));
            patient.setFirstName((String) payload.get("fname"));
            patient.setGender(Integer.parseInt((String) payload.get("gender")));
            patient.setInformantCaregiverName((String) payload.get("carer_name"));
            patient.setLanguages((String) payload.get("lan"));
            patient.setLastChangeBy((long)user.getId());
            patient.setLastChangeOn(new Timestamp(date.getTime()));
            patient.setLastName((String) payload.get("lname"));
            patient.setOccupation((String) payload.get("occ"));
            patient.setPhoneNumber((String) payload.get("phone"));
            patient.setRelationshipWithPatient((String) payload.get("carer_rel"));
            PatientEntity patient1 = patientRepository.save(patient);
            System.out.println(patient1);
            return "Pateint Added";
        }catch (Exception e){
            e.printStackTrace();
            return e.getMessage();
        }
    }
}
