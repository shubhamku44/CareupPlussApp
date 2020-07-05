package com.example.pc.careuppluss;

public class UserDetails {


    private String username;
    private String mobile;

    public UserDetails() {
    }

    public UserDetails(String username, String mobile) {
        this.username = username;
        this.mobile = mobile;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }
}
