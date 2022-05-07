package com.iiitb.healthcare.services;

import com.iiitb.healthcare.model.dtos.PieChartDto;
import com.iiitb.healthcare.model.entities.OrganizationEntity;
import com.iiitb.healthcare.repo.OrganizationRepo;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class OrganizationEntityService {
    private final OrganizationRepo organizationRepo;

    public OrganizationEntityService(OrganizationRepo organizationRepo) {
        this.organizationRepo = organizationRepo;
    }

    public List<OrganizationEntity> getAllOrganizations() {
        List<OrganizationEntity> orgs = organizationRepo.findAll();
        return orgs;
    }

    public String addHospital(Map<String, Object> payload, String token) {
        try {
            OrganizationEntity hospital = new OrganizationEntity();
            hospital.setActive(true);
            hospital.setName((String) payload.get("name"));
            String address = "{ \"addLine1\": \"" + (String) payload.get("addLine1") + "\" ,";
            address = address + "\"district\": \"" + (String) payload.get("district") + "\" ,";
            address = address + "\"state\": \"" + (String) payload.get("state") + "\" ,";
            address = address + "\"pin\": \"" + String.valueOf(payload.get("pincode")) + "\" }";
            hospital.setAddressDetail(address);
            organizationRepo.save(hospital);
            return "Hospital Added";
        } catch (Exception e) {
            e.printStackTrace();
            return e.getMessage();
        }
    }

    public PieChartDto getDiagnosisCountChart() {
        var stats = organizationRepo.findDiagnosisCountChart();
        return new PieChartDto(stats);
    }
}
