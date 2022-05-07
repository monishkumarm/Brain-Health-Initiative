package com.iiitb.healthcare.controller;

import com.iiitb.healthcare.helper.JwtUtil;
import com.iiitb.healthcare.model.JwtRequest;
import com.iiitb.healthcare.model.entities.UserEntity;
import com.iiitb.healthcare.services.CustomUserDetailsService;
import com.iiitb.healthcare.services.UserEntityService;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;

@RestController
@CrossOrigin(origins = "*")
public class JwtController {

    private final AuthenticationManager authenticationManager;

    private final CustomUserDetailsService customUserDetailsService;

    private final JwtUtil jwtUtil;

    private final UserEntityService userEntityService;

    public JwtController(AuthenticationManager authenticationManager, CustomUserDetailsService customUserDetailsService, JwtUtil jwtUtil, UserEntityService userEntityService) {
        this.authenticationManager = authenticationManager;
        this.customUserDetailsService = customUserDetailsService;
        this.jwtUtil = jwtUtil;
        this.userEntityService = userEntityService;
    }

    @RequestMapping(value = "/token", method = RequestMethod.POST)
    public ResponseEntity<?> generateToken(@RequestBody JwtRequest jwtRequest) throws Exception {
        try{
            this.authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(jwtRequest.getUsername(), jwtRequest.getPassword()));
        }
        catch (UsernameNotFoundException e){
            e.printStackTrace();
            throw new Exception("Username not found");
        }
        catch (BadCredentialsException e){
            e.printStackTrace();
            throw new Exception("Username or Password are wrong  ");
        }

        UserDetails userDetails = this.customUserDetailsService.loadUserByUsername(jwtRequest.getUsername());

        String token = this.jwtUtil.generateToken(userDetails);
        UserEntity user = userEntityService.getUserByName(userDetails.getUsername());


        HashMap<String,String> map  = new HashMap<>();
        map.put("token",token);
        map.put("RoleTypeId",String.valueOf(user.getRoleTypeId()));

        return ResponseEntity.ok(map);
     }
}
