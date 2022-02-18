package com.iiitb.healthcare;

import com.iiitb.healthcare.model.User;
import com.iiitb.healthcare.repo.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import java.util.Random;

@SpringBootApplication
public class HealthcareApplication implements CommandLineRunner {

    @Autowired
    private UserRepository userRepository;

    Random random = new Random();

    public void CreateNewUser(){
        var newId = (long) random.nextInt(100);
        User user = new User();
        user.setId(newId);
        user.setUsername("user"+newId);
        user.setRole("admin");
        user.setEmail("user"+newId+"@gmail.com");
        user.setPassword("password");
        user.setEnabled(true);

        User savedUser = userRepository.save(user);

        System.out.println(savedUser);
    }

    public static void main(String[] args) {

        SpringApplication.run(HealthcareApplication.class, args);

    }

    //temporary, to be removed
    @Override
    public void run(String... args) {

        CreateNewUser();
    }
}
