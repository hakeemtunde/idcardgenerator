/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.foresight.reports;

import com.foresight.resources.ReportManager;
import java.io.InputStream;
import java.util.HashMap;
import net.sf.jasperreports.engine.JREmptyDataSource;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;

/**
 *
 * @author hakeemtunde
 */
public class IDCardReport {
    
    private final IDCardModel bean;
    private final String template;
    
    public IDCardReport(IDCardModel model, String temp) {
        this.bean = model;
        this.template = temp;
    }
    
    public void generate() {
        InputStream is = ReportManager.get().getJasperFile(template);
        
        HashMap<String, Object> param = new HashMap<String, Object>();
        param.put(Parameters.EMPID.getDescription(), bean.getEmpId());
        param.put(Parameters.FIRST_NAME.getDescription(), bean.getFirstname());
        param.put(Parameters.SURNAME.getDescription(), bean.getSurname());
        param.put(Parameters.OTHER_NAME.getDescription(), bean.getOthername());
        param.put(Parameters.RANK.getDescription(), bean.getRank());
        param.put(Parameters.DOA.getDescription(), bean.getDateOfAppointment());
        param.put(Parameters.LGA.getDescription(), bean.getLga());
        param.put(Parameters.STATE.getDescription(), bean.getState());
        param.put(Parameters.NATIONALITY.getDescription(), bean.getNationality());
        param.put(Parameters.COMPANY_NAME.getDescription(), bean.getCompany());
        param.put(Parameters.COMPANY_ADDR.getDescription(), bean.getAddress());
        param.put(Parameters.LOGO.getDescription(), bean.getLogo());
        param.put(Parameters.FRONT_BACKGROUND.getDescription(), bean.getFrontBackground());
        param.put(Parameters.BACK_BACKGROUND.getDescription(), bean.getBackBackground());
        param.put(Parameters.STAFF_IMAGE.getDescription(), bean.getStaffImage());
        param.put(Parameters.STAFF_SIGN.getDescription(), bean.getSignature());
        param.put(Parameters.STAFF_BARCODE.getDescription(), bean.getBarcode());
        param.put(Parameters.DEPARTMENT.getDescription(), bean.getDepartment());
        param.put(Parameters.BACK_INFO.getDescription(), bean.getBackInfo());
        
        
        
        try {
            JasperPrint jasperPrint = JasperFillManager.fillReport(is, param, new JREmptyDataSource());
            JasperExportManager.exportReportToPdfFile(jasperPrint, "idCard.pdf");
        } catch (Exception e) {
            System.err.println("error generating report: "+ e.getMessage());
            
        }
    }
    
    
}
