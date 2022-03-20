package com.iiitb.healthcare.services;

import com.iiitb.healthcare.helper.JwtUtil;
import com.iiitb.healthcare.model.entities.PatientConsultationEntity;
import com.iiitb.healthcare.model.entities.PatientEntity;
import com.iiitb.healthcare.model.entities.UserEntity;
import com.iiitb.healthcare.model.entities.UserPermissionPatientEntity;
import com.iiitb.healthcare.repo.ConsultationRepository;
import com.iiitb.healthcare.repo.PatientRepository;
import com.iiitb.healthcare.repo.UserPermissionPatientEntityRepository;
import com.iiitb.healthcare.repo.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.*;

@Service
public class ConsultationService {

    @Autowired
    private ConsultationRepository consultationRepository;

    @Autowired
    private PatientRepository patientRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserPermissionPatientEntityRepository userPermissionPatientEntityRepository;
    @Autowired
    private JwtUtil jwtUtil;



    public List<PatientConsultationEntity> getPatientConsultations(long patientId){
        return consultationRepository.getAllByPatientIdOrderByReferredOnDesc(patientId);
    }

    public PatientConsultationEntity getConsultationRecord(Integer id){
        return consultationRepository.getById(id);
    }

    public String  addConsultationRecord(Map<String,Object> payload,String token,String abhaId){
        System.out.println("In add consultation service");

        List<PatientEntity> patients =  this.patientRepository.findByAbhaId(abhaId);
        PatientConsultationEntity consultationEntity = new PatientConsultationEntity();
        Date date = new Date();
        UserEntity user = this.userRepository.findByUsername(this.jwtUtil.extractUsername(token.substring(7)));
        UserEntity referUser = this.userRepository.findByUsername((String) payload.get("refer"));
        consultationEntity.setAppointmentTime(new Timestamp(date.getTime()));
        String complaintDetail = "{ \"complaint\": \"" + (String) payload.get("complaint") + "\" ,";
        complaintDetail = complaintDetail + "\"history\": \"" + (String) payload.get("history") + "\" ,";
        complaintDetail = complaintDetail + "\"examination\": \"" + (String) payload.get("examination") + "\" ,";
        complaintDetail = complaintDetail + "\"illnessSummary\": \"" + (String) payload.get("illnessSummary") + "\" }";
        consultationEntity.setComplaintDetail(complaintDetail);
        System.out.println(complaintDetail);
        consultationEntity.setDiagnosisTypeId(Integer.parseInt((String) payload.get("type")));
        consultationEntity.setDoctorId((long)referUser.getId());

        String followUpDetails = "{ \"followUp\": \"" + (String) payload.get("followup") + "\" ,";
        followUpDetails = followUpDetails + "\"moveToIp\": " + (Boolean) payload.get("moveToIp") + " ,";
        followUpDetails = followUpDetails + "\"referSos\": " + (Boolean) payload.get("referSos") + " }";
        consultationEntity.setFollowUpDetail(followUpDetails);
        System.out.println(followUpDetails);

        String icdDetails = "{ \"icd10\": \"" + (String) payload.get("icd10") + "\" ,";
        icdDetails = icdDetails + "\"icdDescription\": \"" + (String) payload.get("icdDescription") + "\" }";
        consultationEntity.setIcdDetail(icdDetails);
        System.out.println(icdDetails);


        String medicineDetails ="{ ";
        consultationEntity.setImprovementStatusId(Integer.parseInt((String) payload.get("improvementStatus")));
        String medicines = " \"medicines\" : [";

        List<LinkedHashMap<String,Object>> medicineList = (ArrayList<LinkedHashMap<String,Object>>)payload.get("medicine");
        int n = medicineList.size();
        System.out.println(n);
        if(n>0)
        {
            medicineDetails = medicineDetails + " \"medicineDuration\" : \"" + (String) payload.get("medicineDuration") + "\" ,";
            medicineDetails = medicineDetails + " \"remarks\" : \"" + (String) payload.get("remarks") + "\" ,";
            LinkedHashMap<String,Object> medicine = medicineList.get(0);
            String med = "{ \"medicineName\": \"" + (String) medicine.get("medicineName") + "\" ,";
            med = med + "\"Dosage\": \"" + (String) medicine.get("Dosage") + "\" ,";
            med = med + "\"isMorning\": " + (Boolean) medicine.get("isMorning") + " ,";
            med = med + "\"isAfternoon\": " + (Boolean) medicine.get("isAfternoon") + " ,";
            med = med + "\"isNight\": " + (Boolean) medicine.get("isNight") + " }";

            medicines = medicines + med;

        }

        for (int i = 1;i<n;i++) {
            LinkedHashMap<String,Object> medicine = medicineList.get(i);
            String med = ", { \"medicineName\": \"" + (String) medicine.get("medicineName") + "\" ,";
            med = med + "\"Dosage\": \"" + (String) medicine.get("Dosage") + "\" ,";
            med = med + "\"isMorning\": " + (Boolean) medicine.get("isMorning") + " ,";
            med = med + "\"isAfternoon\": " + (Boolean) medicine.get("isAfternoon") + ",";
            med = med + "\"isNight\": " + (Boolean) medicine.get("isNight") + " }";
            medicines = medicines + med;
        }
        medicines = medicines + " ] }";
        medicineDetails = medicineDetails + medicines;
        consultationEntity.setMedicineDetail(medicineDetails);
        System.out.println(medicineDetails);
//        System.out.println(consultationEntity.getMedicineDetail());
        consultationEntity.setPatientId((long)patients.get(0).getId());
        consultationEntity.setReferredBy((long)user.getId());
        consultationEntity.setReferredOn(new Timestamp(date.getTime()));
        consultationEntity.setTreatmentInstruction((String) payload.get("treatmentInstructions"));
        PatientConsultationEntity patientConsultationEntity = consultationRepository.save(consultationEntity);
        System.out.println(patientConsultationEntity.toString());

        if(userPermissionPatientEntityRepository.getPatientByUser((long)referUser.getId(),(long)patients.get(0).getId())==null){
            UserPermissionPatientEntity userPermissionPatientEntity = new UserPermissionPatientEntity();
            userPermissionPatientEntity.setPatientId((long)patients.get(0).getId());
            userPermissionPatientEntity.setUserId((long)referUser.getId());
            userPermissionPatientEntity.setCanDelete(false);
            userPermissionPatientEntity.setCanModify(false);
            userPermissionPatientEntity.setCanView(true);
            UserPermissionPatientEntity permission = userPermissionPatientEntityRepository.save(userPermissionPatientEntity);
        }


        return "Consultaion Record Added";
    }
}
