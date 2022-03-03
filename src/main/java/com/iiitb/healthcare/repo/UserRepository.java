package com.iiitb.healthcare.repo;

import com.iiitb.healthcare.model.entities.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.ArrayList;

public interface UserRepository extends JpaRepository<UserEntity, Long> {

     UserEntity findByUsername (String username);

}
