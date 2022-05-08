package com.iiitb.healthcare.repo;

import com.iiitb.healthcare.model.entities.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface UserRepository extends JpaRepository<UserEntity, Long> {

    public UserEntity findByUsername(String username);

    @Query(value="SELECT * FROM user U WHERE U.RoleTypeId = 2 ",nativeQuery = true)
    public List<UserEntity> getAllSpecilists();
    @Query(value="SELECT COUNT(*) FROM User",nativeQuery = true)
    public long getUserCount();
}
