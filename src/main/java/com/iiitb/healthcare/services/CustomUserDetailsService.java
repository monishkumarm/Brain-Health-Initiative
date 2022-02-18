package com.iiitb.healthcare.services;

import com.iiitb.healthcare.model.CustomUserDetails;
import com.iiitb.healthcare.model.User;
import com.iiitb.healthcare.repo.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        final User user = this.userRepository.findByUsername(username);

        if(user == null){
            throw new UsernameNotFoundException("Not found");
        }

        return new CustomUserDetails(user);
    }
}
