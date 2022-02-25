package com.iiitb.healthcare.repo;

import com.iiitb.healthcare.model.entities.PatientEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;


public interface PatientRepository extends JpaRepository<PatientEntity,Integer> {


}
