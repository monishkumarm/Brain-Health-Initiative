package com.iiitb.healthcare.services;

import com.iiitb.healthcare.helper.JwtUtil;
import com.iiitb.healthcare.model.entities.PatientEntity;
import com.iiitb.healthcare.model.entities.UserEntity;
import com.iiitb.healthcare.model.entities.UserPermissionPatientEntity;
import com.iiitb.healthcare.repo.PatientRepository;
import com.iiitb.healthcare.repo.UserPermissionPatientEntityRepository;
import com.iiitb.healthcare.repo.UserRepository;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

@Service
public class PatientEntityService {

    private final PatientRepository patientRepository;

    private final UserRepository userRepository;

    private final UserPermissionPatientEntityRepository userPermissionPatientEntityRepository;
    private final JwtUtil jwtUtil;

    public PatientEntityService(PatientRepository patientRepository, UserRepository userRepository, UserPermissionPatientEntityRepository userPermissionPatientEntityRepository, JwtUtil jwtUtil) {
        this.patientRepository = patientRepository;
        this.userRepository = userRepository;
        this.userPermissionPatientEntityRepository = userPermissionPatientEntityRepository;
        this.jwtUtil = jwtUtil;
    }

    public List<PatientEntity> getAllPatients() {
        List<PatientEntity> patients = new ArrayList<PatientEntity>();
        patientRepository.findAll().forEach(patient -> patients.add(patient));
        return patients;
    }

    public List<PatientEntity> getAllPatientByUser(String token) {
        List<PatientEntity> patients = new ArrayList<PatientEntity>();
        UserEntity user = this.userRepository.findByUsername(this.jwtUtil.extractUsername(token.substring(7)));
        patientRepository.findAllPatientByUser((long) user.getId()).forEach(patient -> patients.add(patient));
        return patients;
    }

    public List<PatientEntity> getSearchPatients(Map<String, Object> payload) {
        List<PatientEntity> patients = new ArrayList<PatientEntity>();
        System.out.println((String) payload.get("value"));
        Integer option = Integer.parseInt((String) payload.get("option"));
        if (option.compareTo(1) == 0) {
            patientRepository.findByAbhaId((String) payload.get("value")).forEach(patient -> patients.add(patient));
        } else if (option.compareTo(2) == 0) {
            patientRepository.findByFirstName((String) payload.get("value")).forEach(patient -> patients.add(patient));
        } else if (option.compareTo(3) == 0) {
            patientRepository.findByPhoneNumber((String) payload.get("value")).forEach(patient -> patients.add(patient));
        } else {
            patientRepository.findById(Long.parseLong((String) payload.get("value"))).forEach(patient -> patients.add(patient));
        }
        System.out.println(patients.toString());
        return patients;
    }


    public String addPatient(Map<String, Object> payload, String token) {
        try {
            System.out.println("In add patient service");
            PatientEntity patient = new PatientEntity();

            patient.setAbhaId((String) payload.get("ABHAID"));
            String add1 = (String) payload.get("addLine1");
            String add2 = (String) payload.get("addLine2");
            String address = "{ \"addLine1\": \"" + (String) payload.get("addLine1") + "\" ,";
            address = address + "\"addLine2\": \"" + (String) payload.get("addLine2") + "\" ,";
            address = address + "\"district\": \"" + (String) payload.get("district") + "\" ,";
            address = address + "\"state\": \"" + (String) payload.get("state") + "\" ,";
            address = address + "\"pin\": \"" + (String) payload.get("pin") + "\" }";
            patient.setAddressDetail(address);
            patient.setAge((Integer) payload.get("age"));

            UserEntity user = this.userRepository.findByUsername(this.jwtUtil.extractUsername(token.substring(7)));
            patient.setCreatedBy((long) user.getId());

            Date date = new Date();
            patient.setCreatedOn(new Timestamp(date.getTime()));
            patient.setEducation((String) payload.get("edu"));
            patient.setEmail((String) payload.get("email"));
            patient.setFirstName((String) payload.get("fname"));
            patient.setGender(Integer.parseInt((String) payload.get("gender")));
            patient.setInformantCaregiverName((String) payload.get("carer_name"));
            patient.setLanguages((String) payload.get("lan"));
            patient.setLastChangeBy((long) user.getId());
            patient.setLastChangeOn(new Timestamp(date.getTime()));
            patient.setLastName((String) payload.get("lname"));
            patient.setOccupation((String) payload.get("occ"));
            patient.setPhoneNumber((String) payload.get("phone"));
            patient.setRelationshipWithPatient((String) payload.get("carer_rel"));

            PatientEntity patient1 = patientRepository.save(patient);
            System.out.println(patient1.getId());

            UserPermissionPatientEntity userPermissionPatientEntity = new UserPermissionPatientEntity();

            userPermissionPatientEntity.setPatientId((long) patient1.getId());
            userPermissionPatientEntity.setUserId((long) user.getId());
            userPermissionPatientEntity.setCanDelete(true);
            userPermissionPatientEntity.setCanModify(true);
            userPermissionPatientEntity.setCanView(true);
            UserPermissionPatientEntity permission = userPermissionPatientEntityRepository.save(userPermissionPatientEntity);
            return "Pateint Added";
        } catch (Exception e) {
            e.printStackTrace();
            return e.getMessage();
        }
    }

    public boolean checkPermission(Map<String, Object> payload, String token) {
        System.out.println("in check permission service");
        long userId = this.userRepository.findByUsername(this.jwtUtil.extractUsername(token.substring(7))).getId();
        List<PatientEntity> patients = this.patientRepository.findByAbhaId((String) payload.get("ABHAID"));
        System.out.println(patients.get(0).getId());
        UserPermissionPatientEntity userPermissionPatientEntity = this.userPermissionPatientEntityRepository.getPatientByUser(userId, patients.get(0).getId());
        if (userPermissionPatientEntity == null) {
            return false;
        }
        return userPermissionPatientEntity.isCanModify();
    }

    public PatientEntity updatePatients(Map<String, Object> payload, String token) {
        System.out.println("in Update service");
        List<PatientEntity> patients = this.patientRepository.findByAbhaId((String) payload.get("ABHAID"));
        String address = "{ \"addLine1\": \"" + (String) payload.get("addLine1") + "\" ,";
        address = address + "\"addLine2\": \"" + (String) payload.get("addLine2") + "\" ,";
        address = address + "\"district\": \"" + (String) payload.get("district") + "\" ,";
        address = address + "\"state\": \"" + (String) payload.get("state") + "\" ,";
        address = address + "\"pin\": \"" + (String) payload.get("pin") + "\" }";
        patients.get(0).setAddressDetail(address);
        System.out.println("get user");
        patients.get(0).setAge((Integer) payload.get("age"));
        UserEntity user = this.userRepository.findByUsername(this.jwtUtil.extractUsername(token.substring(7)));
        Date date = new Date();
        patients.get(0).setEducation((String) payload.get("edu"));
        patients.get(0).setEmail((String) payload.get("email"));
        patients.get(0).setFirstName((String) payload.get("fname"));
        patients.get(0).setGender(Integer.parseInt((String) payload.get("gender")));
        patients.get(0).setInformantCaregiverName((String) payload.get("carer_name"));
        patients.get(0).setLanguages((String) payload.get("lan"));
        patients.get(0).setLastChangeBy((long) user.getId());
        patients.get(0).setLastChangeOn(new Timestamp(date.getTime()));
        patients.get(0).setLastName((String) payload.get("lname"));
        patients.get(0).setOccupation((String) payload.get("occ"));
        patients.get(0).setPhoneNumber((String) payload.get("phone"));
        patients.get(0).setRelationshipWithPatient((String) payload.get("carer_rel"));
        PatientEntity patient1 = patientRepository.save(patients.get(0));
        return patient1;


    }
}
