package com.iiitb.healthcare.services;

import com.iiitb.healthcare.model.entities.PatientConsultationEntity;
import com.iiitb.healthcare.repo.ConsultationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ConsultationService {

    @Autowired
    private ConsultationRepository consultationRepository;

    public List<PatientConsultationEntity> getPatientConsultations(Integer patientId){
        return consultationRepository.getAllByPatientIdOrderByReferredOnDesc(patientId);
    }

    public PatientConsultationEntity getConsultationRecord(Integer id){
        return consultationRepository.getById(id);
    }
}
