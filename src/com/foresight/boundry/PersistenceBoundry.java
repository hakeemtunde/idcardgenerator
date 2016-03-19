/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.foresight.boundry;

import com.foresight.crudservice.CrudService;
import com.foresight.entity.Company;
import com.foresight.entity.Department;
import com.foresight.entity.Staff;
import com.foresight.entitymngr.CompanyJpaController;
import com.foresight.entitymngr.DepartmentJpaController;
import com.foresight.entitymngr.StaffJpaController;
import com.foresight.reports.Report;
import java.io.File;
import java.util.Calendar;
import java.util.List;

/**
 *
 * @author hakeemtunde
 */
public class PersistenceBoundry {
    
    private final CompanyJpaController compController;
    private final DepartmentJpaController depController;
    private final StaffJpaController staffController;
    private Report report;
    
    public PersistenceBoundry () {    
        compController = new CompanyJpaController(CrudService.getEntityManagerFactory());
        depController = new DepartmentJpaController(CrudService.getEntityManagerFactory());
        staffController = new StaffJpaController(CrudService.getEntityManagerFactory());
    }
    
    public Company createCompany(Company company) throws Exception {        
        compController.create(company);
        return company;
    }
    
    public Department createDepartment(Department dep) throws Exception {                
        depController.create(dep);
        return dep;
    }
    
    public Company getCompany() {
        return compController.findCompany(1);
    }
    
    public void updateCompany(Company comp) {
        
        try {
            compController.edit(comp);
        }catch (Exception e) {
            System.err.println("Fail upating company: "+ e.getMessage());
        }
    }
    
    public List<Department> getDepartments() {        
        List<Department> deps = depController.findDepartmentEntities();
        return deps;
        
    }
    
    public Staff createStaff(Staff staff) {
        return staffController.create(staff);
//        return staff;
    }
    
    public void updateStaff(Staff staff) {
        try {
            staffController.edit(staff);
        } catch(Exception nee) {
            System.err.println("Error updating staff "+ nee.getMessage());
        }
    }
    
    public void deleteStaff(Staff staff) {
        try {
            staffController.destroy(staff.getId());
        } catch(Exception e) {
            System.err.println("Error deleting staff ... " + e.getMessage());
        }
        
    }
    
    public List<Staff> getStaffs() {
        return staffController.findStaffEntities();
    }
    
    
    //barcode 
     public void generateBarcode(String uid, String msg) {
        try {
            SampleBarcodeEnhanced app = new SampleBarcodeEnhanced();
            File outputFile = new File(Utils.getImageLocation(Utils.barcodePath, uid+".png"));
            app.generate(outputFile, uid, msg);
        } catch (Exception e) {
            e.printStackTrace();
            System.exit(-1);
        }
        
    }
    
    public String getBarcodeMessage(Company company, String empid) {
        Calendar c = Calendar.getInstance();
        String msg = String.format("Company Name: %s \n Address: %s \n Employee Id: %s \n printed on: %tB %te, %tY%n", 
                company.getName(), company.getAddress(), empid, c, c, c);
        return msg;
    }
    
    public void generateIDCard(Staff staff, Company company) {        
        report = new Report();
        report.generateIDCard(staff, company);
        
    }
    
    
}
