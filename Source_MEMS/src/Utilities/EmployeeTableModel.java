package Utilities;

import javax.swing.table.AbstractTableModel;

import model.view.EmployeeInfo;

import java.util.List;

public class EmployeeTableModel extends AbstractTableModel {

    private static final long serialVersionUID = 1L;
    private List<EmployeeInfo> employees;
    private final String[] columnNames = {"工號", "姓氏", "名字", "職稱", "部門", "帳號ID", "部門ID"};

    // Constructor
    public EmployeeTableModel(List<EmployeeInfo> employees) {
        this.employees = employees;
    }

    @Override
    public int getRowCount() {
        return employees.size();
    }

    @Override
    public int getColumnCount() {
        return columnNames.length;
    }

    @Override
    public String getColumnName(int column) {
        return columnNames[column];
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        EmployeeInfo employee = employees.get(rowIndex);
        switch (columnIndex) {
            case 0: return employee.getId();
            case 1: return employee.getFirstName();
            case 2: return employee.getLastName();
            case 3: return employee.getPosition();
            case 4: return employee.getDeptName();
            case 5: return employee.getUserId();
            case 6: return employee.getDeptId();
            default: return null;
        }
    }
 // Method to reload the entire list of employees and refresh the table
    public void setEmployees(List<EmployeeInfo> employees) {
        this.employees = employees;
        fireTableDataChanged(); // Notify the table that the entire data has changed
    }
}

