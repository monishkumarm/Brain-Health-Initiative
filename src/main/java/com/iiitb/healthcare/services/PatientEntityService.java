package com.iiitb.healthcare.services;

import com.iiitb.healthcare.model.entities.PatientConsultationEntity;
import com.iiitb.healthcare.model.entities.PatientEntity;
import com.iiitb.healthcare.model.entities.UserPermissionPatientEntity;
import com.iiitb.healthcare.repo.PatientRepository;
import com.iiitb.healthcare.repo.UserPermissionPatientEntityRepository;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.*;

@Service
public class PatientEntityService {

    private final PatientRepository patientRepository;

    private final UserPermissionPatientEntityRepository userPermissionPatientEntityRepository;

    private final ConsultationService consultationService;
    public PatientEntityService(PatientRepository patientRepository, UserPermissionPatientEntityRepository userPermissionPatientEntityRepository, ConsultationService consultationService) {
        this.patientRepository = patientRepository;
        this.userPermissionPatientEntityRepository = userPermissionPatientEntityRepository;
        this.consultationService = consultationService;
    }

    public List<Set<PatientEntity>> getAllPatients(Long loggedInUserId) {

        Set<PatientEntity> consultedPatient = new HashSet<>();
        Set<PatientEntity> unconsultedPatient = new HashSet<>();
        List<PatientEntity> patientsList = patientRepository.findAllPatientByUser(loggedInUserId);
        for(int i=0;i<patientsList.size();i++){
            List<PatientConsultationEntity> consultation = this.consultationService.getPatientConsultations(patientsList.get(i).getId());
            for(int j=0;j<consultation.size();j++)
            {
                if(consultation.get(j).getReferredBy()==loggedInUserId)
                {
                    consultedPatient.add(patientsList.get(i));
                }
                else
                {
                    unconsultedPatient.add(patientsList.get(i));
                }
            }
//            if(this.consultationService.getPatientConsultations(patientsList.get(i).getId()).size()>0)
//            {
//                consultedPatient.add(patientsList.get(i));
//            }
//            else
//            {
//                unconsultedPatient.add(patientsList.get(i));
//            }
        }
        List<Set<PatientEntity>> patients = new ArrayList<>();
        patients.add(consultedPatient);
        patients.add(unconsultedPatient);
        return patients;
    }

//    public List<PatientEntity> getAllPatientByUser(String token) {
//        UserEntity user = this.userRepository.findByUsername(this.jwtUtil.extractUsername(token.substring(7)));
//        return new ArrayList<>(patientRepository.findAllPatientByUser(user.getId()));
//    }

    public List<PatientEntity> getSearchPatients(Map<String, Object> payload) {
        List<PatientEntity> patients = new ArrayList<>();
        System.out.println((String) payload.get("value"));
        Integer option = Integer.parseInt((String) payload.get("option"));
        if (option.compareTo(1) == 0) {
            patients.addAll(patientRepository.findByAbhaId((String) payload.get("value")));
        } else if (option.compareTo(2) == 0) {
            patients.addAll(patientRepository.findByFirstName((String) payload.get("value")));
        } else if (option.compareTo(3) == 0) {
            patients.addAll(patientRepository.findByPhoneNumber((String) payload.get("value")));
        } else {
            patients.addAll(patientRepository.findById(Long.parseLong((String) payload.get("value"))));
        }
        return patients;
    }


    public String addPatient(Map<String, Object> payload, Long loggedInUserId) {
        try {
            System.out.println("In add patient service");
            PatientEntity patient = new PatientEntity();

            patient.setAbhaId((String) payload.get("ABHAID"));
            String address = "{ \"addLine1\": \"" + payload.get("addLine1") + "\" ,";
            address = address + "\"addLine2\": \"" + payload.get("addLine2") + "\" ,";
            address = address + "\"district\": \"" + payload.get("district") + "\" ,";
            address = address + "\"state\": \"" + payload.get("state") + "\" ,";
            address = address + "\"pin\": \"" + payload.get("pin") + "\" }";
            patient.setAddressDetail(address);
            patient.setAge((Integer) payload.get("age"));

            patient.setCreatedBy(loggedInUserId);

            Date date = new Date();
            patient.setCreatedOn(new Timestamp(date.getTime()));
            patient.setEducation((String) payload.get("edu"));
            patient.setEmail((String) payload.get("email"));
            patient.setFirstName((String) payload.get("fname"));
            patient.setGender(Integer.parseInt((String) payload.get("gender")));
            patient.setInformantCaregiverName((String) payload.get("carer_name"));
            patient.setLanguages((String) payload.get("lan"));
            patient.setLastChangeBy(loggedInUserId);
            patient.setLastChangeOn(new Timestamp(date.getTime()));
            patient.setLastName((String) payload.get("lname"));
            patient.setOccupation((String) payload.get("occ"));
            patient.setPhoneNumber((String) payload.get("phone"));
            patient.setRelationshipWithPatient((String) payload.get("carer_rel"));

            PatientEntity patient1 = patientRepository.save(patient);
            System.out.println(patient1.getId());

            UserPermissionPatientEntity userPermissionPatientEntity = new UserPermissionPatientEntity();

            userPermissionPatientEntity.setPatientId(patient1.getId());
            userPermissionPatientEntity.setUserId(loggedInUserId);
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

    public boolean checkPermission(Map<String, Object> payload, Long loggedInUserId) {
        List<PatientEntity> patients = this.patientRepository.findByAbhaId((String) payload.get("ABHAID"));
        UserPermissionPatientEntity userPermissionPatientEntity = this.userPermissionPatientEntityRepository.getPatientByUser(loggedInUserId, patients.get(0).getId());
        if (userPermissionPatientEntity == null) {
            return false;
        }
        return userPermissionPatientEntity.isCanModify();
    }

    public PatientEntity updatePatients(Map<String, Object> payload, Long loggedInUserId) {
        List<PatientEntity> patients = this.patientRepository.findByAbhaId((String) payload.get("ABHAID"));
        String address = "{ \"addLine1\": \"" + payload.get("addLine1") + "\" ,";
        address = address + "\"addLine2\": \"" + payload.get("addLine2") + "\" ,";
        address = address + "\"district\": \"" + payload.get("district") + "\" ,";
        address = address + "\"state\": \"" + payload.get("state") + "\" ,";
        address = address + "\"pin\": \"" + payload.get("pin") + "\" }";
        patients.get(0).setAddressDetail(address);
        patients.get(0).setAge((Integer) payload.get("age"));
        Date date = new Date();
        patients.get(0).setEducation((String) payload.get("edu"));
        patients.get(0).setEmail((String) payload.get("email"));
        patients.get(0).setFirstName((String) payload.get("fname"));
        patients.get(0).setGender(Integer.parseInt((String) payload.get("gender")));
        patients.get(0).setInformantCaregiverName((String) payload.get("carer_name"));
        patients.get(0).setLanguages((String) payload.get("lan"));
        patients.get(0).setLastChangeBy(loggedInUserId);
        patients.get(0).setLastChangeOn(new Timestamp(date.getTime()));
        patients.get(0).setLastName((String) payload.get("lname"));
        patients.get(0).setOccupation((String) payload.get("occ"));
        patients.get(0).setPhoneNumber((String) payload.get("phone"));
        patients.get(0).setRelationshipWithPatient((String) payload.get("carer_rel"));
        return patientRepository.save(patients.get(0));
    }
}
