package com.iiitb.healthcare.repo;

import com.iiitb.healthcare.model.entities.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface UserRepository extends JpaRepository<UserEntity, Long> {

    UserEntity findByUsername(String username);

    @Query(value = "SELECT * FROM User U WHERE U.RoleTypeId = 2 ", nativeQuery = true)
    List<UserEntity> getAllSpecialists();

}
