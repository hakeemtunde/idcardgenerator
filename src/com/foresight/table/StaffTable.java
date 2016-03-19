
package com.foresight.table;

/**
 *
 * @author hakeemtunde
 */


import com.foresight.crudservice.CrudService;
import com.foresight.entity.Staff;
import com.foresight.entitymngr.StaffJpaController;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author hakeem
 */
public class StaffTable extends AbstractTableModel {
    
    
    private final String[] columnName = {"EmpID",  "Surname", "First name", "State"};
    private int row;
    private List<Staff> staffs;
    private final StaffJpaController staffController;
    
    public StaffTable() {
        staffController = new StaffJpaController(CrudService.getEntityManagerFactory());
        staffs = staffController.findStaffEntities();
        row = staffs.size();        
       
    }
    
   
    @Override
    public int getRowCount() {
        return row;
    }

    @Override
    public int getColumnCount() {
        return columnName.length;
    }
    
    @Override
    public String getColumnName(int col) {
        return columnName[col];
    }

    @Override
    public Object getValueAt(int row, int column) {
        
        Object object;
        Staff staff = staffs.get(row);
        switch(column) {
            case 0:
                object = staff.getEmpId();break;
            case 1:
                object = staff.getSurname(); break;
            case 2:
                object = staff.getFirstname(); break;
            case 3:
                object = staff.getStateoforigin(); break;
                
            default:
                object = "";              
                
        }
        
        return object;
    }
    
    public List<Staff> getStaff() {
        return staffs;
    }
    
    public void refreshTable() {
        staffs = staffController.findStaffEntities();
        row = staffs.size();
        fireTableDataChanged();
    }
    
}
