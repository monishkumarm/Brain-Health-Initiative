package com.iiitb.healthcare.repo;

import com.iiitb.healthcare.model.dtos.ChartDataDto;
import com.iiitb.healthcare.model.entities.OrganizationEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
public interface OrganizationRepo extends JpaRepository<OrganizationEntity,Long> {
    List<OrganizationEntity> findAll();
    @Query("SELECT new com.iiitb.healthcare.model.dtos.ChartDataDto(QD.diagnosisInfo, COUNT(QD.diagnosisInfo))" +
            "FROM QuestionnaireDiagnosisEntity QD " +
            "INNER JOIN PatientQuestionnaireEntity PQ ON QD.id = PQ.reachedDiagnosisId " +
            "GROUP BY PQ.reachedDiagnosisId")
    List<ChartDataDto> findDiagnosisCountChart();
    @Query(value="SELECT COUNT(*) FROM Organization",nativeQuery = true)
    public long getOrganizationCount();
}
