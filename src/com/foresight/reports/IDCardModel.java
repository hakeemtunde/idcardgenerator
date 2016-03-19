/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.foresight.reports;

import java.awt.Image;

/**
 *
 * @author hakeemtunde
 */
public class IDCardModel {
    
    private String empId;
    private String surname;
    private String firstname;
    private String othername;
    private String rank;
    private String dateOfAppointment;
    private String company;
    private String department;
    private String lga;
    private String state;
    private String nationality;
    private Image logo;
    private Image frontBackground; 
    private Image backBackground;
    private Image staffImage;
    private Image signature;
    private Image barcode;
    private String address;
    private String backInfo;
    
    public IDCardModel() {
        
    }

    public IDCardModel(String empId, String surname, String firstname, 
            String othername, String rank, String dateOfAppointment, 
            String company, String department, String lga, String state, 
            String nationality, Image logo, Image frontBackground, 
            Image backBackground, Image staffImage, Image signature, Image barcode) {
        this.empId = empId;
        this.surname = surname;
        this.firstname = firstname;
        this.othername = othername;
        this.rank = rank;
        this.dateOfAppointment = dateOfAppointment;
        this.company = company;
        this.department = department;
        this.lga = lga;
        this.state = state;
        this.nationality = nationality;
        this.logo = logo;
        this.frontBackground = frontBackground;
        this.backBackground = backBackground;
        this.staffImage = staffImage;
        this.signature = signature;
        this.barcode = barcode;
    }
    
    public String getEmpId() {
        return empId;
    }

    public void setEmpId(String empId) {
        this.empId = empId;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getOthername() {
        return othername;
    }

    public void setOthername(String othername) {
        this.othername = othername;
    }

    public String getRank() {
        return rank;
    }

    public void setRank(String rank) {
        this.rank = rank;
    }

    public String getDateOfAppointment() {
        return dateOfAppointment;
    }

    public void setDateOfAppointment(String dateOfAppointment) {
        this.dateOfAppointment = dateOfAppointment;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getLga() {
        return lga;
    }

    public void setLga(String lga) {
        this.lga = lga;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    public Image getLogo() {
        return logo;
    }

    public void setLogo(Image logo) {
        this.logo = logo;
    }

    public Image getFrontBackground() {
        return frontBackground;
    }

    public void setFrontBackground(Image frontBackground) {
        this.frontBackground = frontBackground;
    }

    public Image getBackBackground() {
        return backBackground;
    }

    public void setBackBackground(Image backBackground) {
        this.backBackground = backBackground;
    }

    public Image getStaffImage() {
        return staffImage;
    }

    public void setStaffImage(Image staffImage) {
        this.staffImage = staffImage;
    }

    public Image getSignature() {
        return signature;
    }

    public void setSignature(Image signature) {
        this.signature = signature;
    }

    public Image getBarcode() {
        return barcode;
    }

    public void setBarcode(Image barcode) {
        this.barcode = barcode;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getBackInfo() {
        return backInfo;
    }

    public void setBackInfo(String backInfo) {
        this.backInfo = backInfo;
    }
    
    
    
}
