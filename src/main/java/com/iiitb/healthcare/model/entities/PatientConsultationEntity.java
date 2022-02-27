package com.iiitb.healthcare.model.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonRawValue;
import com.sun.istack.NotNull;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Objects;

@Entity
@Table(name = "PatientConsultation", schema = "BrainHealthInitiative", catalog = "")
@JsonIgnoreProperties({"hibernateLazyInitializer","handler","patientByPatientId","userByDoctorId","userByReferredBy"})
public class PatientConsultationEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "Id")
    private long id;
    @Basic
    @NotNull
    @Column(name = "PatientId")
    private long patientId;
    @Basic
    @NotNull
    @Column(name = "DoctorId")
    private long doctorId;
    @Basic
    @Column(name = "ReferredBy")
    private Long referredBy;
    @Basic
    @Column(name = "ReferredOn")
    private Timestamp referredOn;
    @Basic
    @NotNull
    @Column(name = "AppointmentTime")
    private Timestamp appointmentTime;
    @Basic
    @NotNull
    @Column(name = "ComplaintDetail", columnDefinition = "json")
    @JsonRawValue
    private String complaintDetail;
    @Basic
    @Column(name = "DiagnosisTypeId")
    private Integer diagnosisTypeId;
    @Basic
    @NotNull
    @Column(name = "ICDDetail", columnDefinition = "json")
    @JsonRawValue
    private String icdDetail;
    @Basic
    @Column(name = "ImprovementStatusId")
    private Integer improvementStatusId;
    @Basic
    @NotNull
    @Column(name = "MedicineDetail", columnDefinition = "json")
    @JsonRawValue
    private String medicineDetail;
    @Basic
    @NotNull
    @Column(name = "TreatmentInstruction")
    private String treatmentInstruction;
    @Basic
    @Column(name = "FollowUpDetail", columnDefinition = "json")
    @JsonRawValue
    @NotNull
    private String followUpDetail;
    @Basic
    @NotNull
    @Column(name = "IsConsultationDone")
    private boolean isConsultationDone;
    @ManyToOne
    @JoinColumn(name = "PatientId", referencedColumnName = "Id", nullable = false, insertable=false, updatable=false)
    private PatientEntity patientByPatientId;
    @ManyToOne
    @JoinColumn(name = "DoctorId", referencedColumnName = "Id", nullable = false, insertable=false, updatable=false)
    private UserEntity userByDoctorId;
    @ManyToOne
    @JoinColumn(name = "ReferredBy", referencedColumnName = "Id", insertable=false, updatable=false)
    private UserEntity userByReferredBy;
    @ManyToOne
    @JoinColumn(name = "DiagnosisTypeId", referencedColumnName = "Id", insertable=false, updatable=false)
    private DiagnosisTypeLuEntity diagnosisTypeLuByDiagnosisTypeId;
    @ManyToOne
    @JoinColumn(name = "ImprovementStatusId", referencedColumnName = "Id", insertable=false, updatable=false)
    private ImprovementStatusLuEntity improvementStatusLuByImprovementStatusId;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getPatientId() {
        return patientId;
    }

    public void setPatientId(long patientId) {
        this.patientId = patientId;
    }

    public long getDoctorId() {
        return doctorId;
    }

    public void setDoctorId(long doctorId) {
        this.doctorId = doctorId;
    }

    public Long getReferredBy() {
        return referredBy;
    }

    public void setReferredBy(Long referredBy) {
        this.referredBy = referredBy;
    }

    public Timestamp getReferredOn() {
        return referredOn;
    }

    public void setReferredOn(Timestamp referredOn) {
        this.referredOn = referredOn;
    }

    public Timestamp getAppointmentTime() {
        return appointmentTime;
    }

    public void setAppointmentTime(Timestamp appointmentTime) {
        this.appointmentTime = appointmentTime;
    }

    public String getComplaintDetail() {
        return complaintDetail;
    }

    public void setComplaintDetail(String complaintDetail) {
        this.complaintDetail = complaintDetail;
    }

    public Integer getDiagnosisTypeId() {
        return diagnosisTypeId;
    }

    public void setDiagnosisTypeId(Integer diagnosisTypeId) {
        this.diagnosisTypeId = diagnosisTypeId;
    }

    public String getIcdDetail() {
        return icdDetail;
    }

    public void setIcdDetail(String icdDetail) {
        this.icdDetail = icdDetail;
    }

    public Integer getImprovementStatusId() {
        return improvementStatusId;
    }

    public void setImprovementStatusId(Integer improvementStatusId) {
        this.improvementStatusId = improvementStatusId;
    }

    public Object getMedicineDetail() {
        return medicineDetail;
    }

    public void setMedicineDetail(String medicineDetail) {
        this.medicineDetail = medicineDetail;
    }

    public String getTreatmentInstruction() {
        return treatmentInstruction;
    }

    public void setTreatmentInstruction(String treatmentInstruction) {
        this.treatmentInstruction = treatmentInstruction;
    }

    public String getFollowUpDetail() {
        return followUpDetail;
    }

    public void setFollowUpDetail(String followUpDetail) {
        this.followUpDetail = followUpDetail;
    }

    public boolean isConsultationDone() {
        return isConsultationDone;
    }

    public void setConsultationDone(boolean consultationDone) {
        isConsultationDone = consultationDone;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PatientConsultationEntity that = (PatientConsultationEntity) o;
        return id == that.id && patientId == that.patientId && doctorId == that.doctorId && isConsultationDone == that.isConsultationDone && Objects.equals(referredBy, that.referredBy) && Objects.equals(referredOn, that.referredOn) && Objects.equals(appointmentTime, that.appointmentTime) && Objects.equals(complaintDetail, that.complaintDetail) && Objects.equals(diagnosisTypeId, that.diagnosisTypeId) && Objects.equals(icdDetail, that.icdDetail) && Objects.equals(improvementStatusId, that.improvementStatusId) && Objects.equals(medicineDetail, that.medicineDetail) && Objects.equals(treatmentInstruction, that.treatmentInstruction) && Objects.equals(followUpDetail, that.followUpDetail);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, patientId, doctorId, referredBy, referredOn, appointmentTime, complaintDetail, diagnosisTypeId, icdDetail, improvementStatusId, medicineDetail, treatmentInstruction, followUpDetail, isConsultationDone);
    }

    public PatientEntity getPatientByPatientId() {
        return patientByPatientId;
    }

    public void setPatientByPatientId(PatientEntity patientByPatientId) {
        this.patientByPatientId = patientByPatientId;
    }

    public UserEntity getUserByDoctorId() {
        return userByDoctorId;
    }

    public void setUserByDoctorId(UserEntity userByDoctorId) {
        this.userByDoctorId = userByDoctorId;
    }

    public UserEntity getUserByReferredBy() {
        return userByReferredBy;
    }

    public void setUserByReferredBy(UserEntity userByReferredBy) {
        this.userByReferredBy = userByReferredBy;
    }

    public DiagnosisTypeLuEntity getDiagnosisTypeLuByDiagnosisTypeId() {
        return diagnosisTypeLuByDiagnosisTypeId;
    }

    public void setDiagnosisTypeLuByDiagnosisTypeId(DiagnosisTypeLuEntity diagnosisTypeLuByDiagnosisTypeId) {
        this.diagnosisTypeLuByDiagnosisTypeId = diagnosisTypeLuByDiagnosisTypeId;
    }

    public ImprovementStatusLuEntity getImprovementStatusLuByImprovementStatusId() {
        return improvementStatusLuByImprovementStatusId;
    }

    public void setImprovementStatusLuByImprovementStatusId(ImprovementStatusLuEntity improvementStatusLuByImprovementStatusId) {
        this.improvementStatusLuByImprovementStatusId = improvementStatusLuByImprovementStatusId;
    }
}
