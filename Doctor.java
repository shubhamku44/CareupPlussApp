package com.example.pc.careuppluss;

public class Doctor {

    String name;
    String pass;
    String add;
    String clinic;
    String contact;
    String specialist;
    String mail;
    public Doctor() {


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

    public String getAdd() {
        return add;
    }

    public void setAdd(String add) {
        this.add = add;
    }

    public String getClinic() {
        return clinic;
    }

    public void setClinic(String clinic) {
        this.clinic = clinic;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public String getSpecialist() {
        return specialist;
    }

    public void setCategories(String specialist) {
        this.specialist = specialist;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public Doctor(String name, String pass, String add, String clinic, String contact, String specialist, String mail) {
        this.name = name;
        this.pass = pass;
        this.add = add;
        this.clinic = clinic;
        this.contact = contact;
        this.specialist = specialist;
        this.mail = mail;
    }
}



