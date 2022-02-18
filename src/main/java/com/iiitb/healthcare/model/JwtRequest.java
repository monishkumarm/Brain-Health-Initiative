package com.iiitb.healthcare.model;

public class JwtRequest {
    String username;
    String password;

    public JwtRequest(){

    }

    public JwtRequest(String username, String password){
        this.username = username;
        this.password = password;
    }

    @Override
    public String toString() {
        return "JwtRequest{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                '}';
    }

    public String getPassword() {
        return password;
    }

    public String getUsername() {
        return username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
