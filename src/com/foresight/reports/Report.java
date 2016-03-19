/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.foresight.reports;

import com.foresight.boundry.Utils;
import com.foresight.entity.Company;
import com.foresight.entity.Staff;


/**
 *
 * @author hakeemtunde
 */
public class Report {
    
    public void generateIDCard(Staff staff, Company company) {
        
        String template = "idcardtemp1";
        IDCardModel model = getIDCardModel(staff, company);
        IDCardReport report = new IDCardReport(model, template);
        report.generate();
        
    }
    
    private IDCardModel getIDCardModel(Staff staff, Company company) {
        
        String staffId = String.valueOf(staff.getId());        
        IDCardModel model = new IDCardModel();
        model.setEmpId(staff.getEmpId().toUpperCase());
        model.setFirstname(staff.getFirstname().toUpperCase());
        model.setSurname(staff.getSurname().toUpperCase());
        model.setOthername(staff.getOthername().toUpperCase());
        model.setRank(staff.getRank().toUpperCase());
        model.setDepartment(staff.getDepartment().getName().toUpperCase());
        model.setLga(staff.getLga().toUpperCase());
        model.setState(staff.getStateoforigin());
        model.setNationality(staff.getNationality());
        model.setLogo(Utils.getImage(Utils.logoPath, "logo"));
        model.setFrontBackground(Utils.getImage(Utils.backgroundPath, "bg1"));
        model.setBackBackground(Utils.getImage(Utils.backgroundPath, "bg2"));
        model.setStaffImage(Utils.getImage(Utils.staffPath, staffId));
        model.setSignature(Utils.getImage(Utils.staffSign, staffId));
        model.setBarcode(Utils.getImage(Utils.barcodePath, staffId));
        model.setCompany(company.getName().toUpperCase());
        model.setAddress(company.getAddress());
        model.setBackInfo(company.getBackInfo());
        
        return model;
        
    }
    
}
