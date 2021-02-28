package sample.gui.models;

import javafx.collections.ObservableList;
import sample.be.Employee;
import sample.bll.SampleManager;

import java.util.List;

public class SampleModel {

    SampleManager sampleManager = new SampleManager();

    public List<Employee> getEmployees() {
        return sampleManager.getEmployees();
    }

    public List<Employee> searchEmployeeDB(String text) {
        return sampleManager.searchEmployeeDB(text);
    }

    public void deleteEmployee(Employee selectedEmployee) {
        sampleManager.deleteEmployee(selectedEmployee);
    }

    public void insertEmployee(Employee employee) {
        sampleManager.insertEmployee(employee);
    }

    public void editEmployee(Employee selectedEmployee) {
        sampleManager.editEmployee(selectedEmployee);
    }
}
