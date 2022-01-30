package com.example.soai_project.Founderr1;

import java.util.Date;

public class CommonData {

    String First_Name;
    String Last_Name;
    String Date_Of_Birth;
    String City;

    String Email;
    String Password;

    String qualificatioNCommon, workExCommon, linkedinCommon;


    public CommonData(){

    }

    public CommonData(String first_Name, String last_Name, String date_Of_Birth, String city, String email, String password, String qualificatioNCommon, String workExCommon, String linkedinCommon) {
        First_Name = first_Name;
        Last_Name = last_Name;
        Date_Of_Birth = date_Of_Birth;
        City = city;
        Email = email;
        Password = password;
        this.qualificatioNCommon = qualificatioNCommon;
        this.workExCommon = workExCommon;
        this.linkedinCommon = linkedinCommon;
    }


//    public FounderR1(String first_Name, String last_Name, String password, String date_Of_Birth, String city) {
//        First_Name = first_Name;
//        Last_Name = last_Name;
//        Password = password;
//        Date_Of_Birth = date_Of_Birth;
//        City = city;
//    }

    public String getFirst_Name() {
        return First_Name;
    }

    public void setFirst_Name(String first_Name) {
        First_Name = first_Name;
    }

    public String getLast_Name() {
        return Last_Name;
    }

    public void setLast_Name(String last_Name) {
        Last_Name = last_Name;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String password) {
        Password = password;
    }

    public String getDate_Of_Birth() {
        return Date_Of_Birth;
    }

    public void setDate_Of_Birth(String date_Of_Birth) {
        Date_Of_Birth = date_Of_Birth;
    }

    public String getCity() {
        return City;
    }

    public void setCity(String city) {
        City = city;
    }

    public String getQualificatioNCommon() {
        return qualificatioNCommon;
    }

    public void setQualificatioNCommon(String qualificatioNCommon) {
        this.qualificatioNCommon = qualificatioNCommon;
    }

    public String getWorkExCommon() {
        return workExCommon;
    }

    public void setWorkExCommon(String workExCommon) {
        this.workExCommon = workExCommon;
    }

    public String getLinkedinCommon() {
        return linkedinCommon;
    }

    public void setLinkedinCommon(String linkedinCommon) {
        this.linkedinCommon = linkedinCommon;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }


}
