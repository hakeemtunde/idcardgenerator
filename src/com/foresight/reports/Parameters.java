/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.foresight.reports;

/**
 *
 * @author hakeemtunde
 */
public enum Parameters {
    
    EMPID("empId"),
    SURNAME("surname"),
    OTHER_NAME("otherName"),
    FIRST_NAME("firstName"),
    RANK("rank"),
    DOA("dateOfAppointment"),
    LGA("lga"),
    STATE("state"), NATIONALITY("nationality"),
    COMPANY_NAME("companyName"), COMPANY_ADDR("companyAddr"),
    STAFF_SIGN("signature"), STAFF_IMAGE("staffImage"), 
    LOGO("logo"), FRONT_BACKGROUND("frontBackground"), 
    BACK_BACKGROUND("backBackground"), STAFF_BARCODE("barcode"), 
    DEPARTMENT("department"), BACK_INFO("backInfo");
    
    private final String description;
    
    Parameters(String desc ) {
        this.description = desc;
    }
    
    public String getDescription() {
        return this.description;
    }
    
    
    
}
