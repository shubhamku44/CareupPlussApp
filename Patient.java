package com.example.pc.careuppluss;

public class Patient {
    String name;
    String pass;
    String mail;
    String contact;

    public Patient() {

    }

    public Patient(String name, String pass, String mail, String contact) {
        this.name = name;
        this.pass = pass;
        this.mail = mail;
        this.contact = contact;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }
}

