package com.iiitb.healthcare.services;

import com.iiitb.healthcare.model.entities.PatientConsultationEntity;
import com.iiitb.healthcare.model.entities.PatientEntity;
import com.iiitb.healthcare.model.entities.UserEntity;
import com.iiitb.healthcare.model.entities.UserPermissionPatientEntity;
import com.iiitb.healthcare.repo.ConsultationRepository;
import com.iiitb.healthcare.repo.PatientRepository;
import com.iiitb.healthcare.repo.UserPermissionPatientEntityRepository;
import com.iiitb.healthcare.repo.UserRepository;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.*;

@Service
public class ConsultationService {

    private final ConsultationRepository consultationRepository;

    private final PatientRepository patientRepository;

    private final UserRepository userRepository;

    private final UserPermissionPatientEntityRepository userPermissionPatientEntityRepository;

    public ConsultationService(ConsultationRepository consultationRepository, PatientRepository patientRepository, UserRepository userRepository, UserPermissionPatientEntityRepository userPermissionPatientEntityRepository) {
        this.consultationRepository = consultationRepository;
        this.patientRepository = patientRepository;
        this.userRepository = userRepository;
        this.userPermissionPatientEntityRepository = userPermissionPatientEntityRepository;
    }


    public List<PatientConsultationEntity> getPatientConsultations(long patientId) {
        return consultationRepository.getAllByPatientIdOrderByReferredOnDesc(patientId);
    }

    public PatientConsultationEntity getConsultationRecord(Integer id) {
        return consultationRepository.getById(id);
    }

    public String addConsultationRecord(Map<String, Object> payload, Long loggedInUserId, String abhaId,String diagnosisId) {
        List<PatientEntity> patients = this.patientRepository.findByAbhaId(abhaId);
        PatientConsultationEntity consultationEntity = new PatientConsultationEntity();
        Date date = new Date();
        UserEntity referUser = this.userRepository.findByUsername((String) payload.get("refer"));
        consultationEntity.setAppointmentTime(new Timestamp(date.getTime()));
        String complaintDetail = "{ \"complaint\": \"" + payload.get("complaint") + "\" ,";
        complaintDetail = complaintDetail + "\"history\": \"" + payload.get("history") + "\" ,";
        complaintDetail = complaintDetail + "\"examination\": \"" + payload.get("examination") + "\" ,";
        complaintDetail = complaintDetail + "\"illnessSummary\": \"" + payload.get("illnessSummary") + "\" }";
        consultationEntity.setComplaintDetail(complaintDetail);
        System.out.println(complaintDetail);
        consultationEntity.setDiagnosisTypeId(Integer.parseInt((String) payload.get("type")));
        consultationEntity.setDoctorId(referUser.getId());

        String followUpDetails = "{ \"followUp\": \"" + payload.get("followup") + "\" ,";
        followUpDetails = followUpDetails + "\"moveToIp\": " + payload.get("moveToIp") + " ,";
        followUpDetails = followUpDetails + "\"referSos\": " + payload.get("referSos") + " }";
        consultationEntity.setFollowUpDetail(followUpDetails);
        System.out.println(followUpDetails);

        String icdDetails = "{ \"icd10\": \"" + payload.get("icd10") + "\" }";
        consultationEntity.setIcdDetail(icdDetails);
        System.out.println(icdDetails);


        String medicineDetails = "{ ";
        consultationEntity.setImprovementStatusId(Integer.parseInt((String) payload.get("improvementStatus")));
        StringBuilder medicines = new StringBuilder(" \"medicines\" : [");

        List<LinkedHashMap<String, Object>> medicineList = (ArrayList<LinkedHashMap<String, Object>>) payload.get("medicine");
        int n = medicineList.size();
        System.out.println(n);
        if (n > 0) {
            medicineDetails = medicineDetails + " \"medicineDuration\" : \"" + payload.get("medicineDuration") + "\" ,";
            medicineDetails = medicineDetails + " \"remarks\" : \"" + payload.get("remarks") + "\" ,";
            LinkedHashMap<String, Object> medicine = medicineList.get(0);
            String med = "{ \"medicineName\": \"" + medicine.get("medicineName") + "\" ,";
            med = med + "\"Dosage\": \"" + medicine.get("Dosage") + "\" ,";
            med = med + "\"isMorning\": " + medicine.get("isMorning") + " ,";
            med = med + "\"isAfternoon\": " + medicine.get("isAfternoon") + " ,";
            med = med + "\"isNight\": " + medicine.get("isNight") + " }";

            medicines.append(med);

        }

        for (int i = 1; i < n; i++) {
            LinkedHashMap<String, Object> medicine = medicineList.get(i);
            String med = ", { \"medicineName\": \"" + medicine.get("medicineName") + "\" ,";
            med = med + "\"Dosage\": \"" + medicine.get("Dosage") + "\" ,";
            med = med + "\"isMorning\": " + medicine.get("isMorning") + " ,";
            med = med + "\"isAfternoon\": " + medicine.get("isAfternoon") + ",";
            med = med + "\"isNight\": " + medicine.get("isNight") + " }";
            medicines.append(med);
        }
        medicines.append(" ] }");
        medicineDetails = medicineDetails + medicines;
        consultationEntity.setMedicineDetail(medicineDetails);
        System.out.println(medicineDetails);
//        System.out.println(consultationEntity.getMedicineDetail());
        consultationEntity.setPatientId(patients.get(0).getId());
        consultationEntity.setReferredBy(loggedInUserId);
        consultationEntity.setReferredOn(new Timestamp(date.getTime()));
        consultationEntity.setTreatmentInstruction((String) payload.get("treatmentInstructions"));
        consultationEntity.setReachedDiagnosisId(Long.parseLong(diagnosisId));
        PatientConsultationEntity patientConsultationEntity = consultationRepository.save(consultationEntity);
        System.out.println(patientConsultationEntity);

        if (userPermissionPatientEntityRepository.getPatientByUser(referUser.getId(), patients.get(0).getId()) == null) {
            UserPermissionPatientEntity userPermissionPatientEntity = new UserPermissionPatientEntity();
            userPermissionPatientEntity.setPatientId(patients.get(0).getId());
            userPermissionPatientEntity.setUserId(referUser.getId());
            userPermissionPatientEntity.setCanDelete(false);
            userPermissionPatientEntity.setCanModify(false);
            userPermissionPatientEntity.setCanView(true);
            UserPermissionPatientEntity permission = userPermissionPatientEntityRepository.save(userPermissionPatientEntity);
        }

        return "Consultaion Record Added";
    }
}
