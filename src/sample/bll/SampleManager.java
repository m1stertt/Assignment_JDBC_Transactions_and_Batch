package sample.bll;

import javafx.collections.ObservableList;
import sample.be.Employee;
import sample.dal.SampleDBDAO;

import java.util.List;

public class SampleManager {

    SampleDBDAO sampleDBDAO = new SampleDBDAO();

    public List<Employee> getEmployees() {
        return sampleDBDAO.getListOfAllEmployees();
    }

    public List<Employee> searchEmployeeDB(String text) {
        return sampleDBDAO.searchEmployeeDB(text);
    }

    public void deleteEmployee(Employee selectedEmployee) {
        sampleDBDAO.deleteEmployee(selectedEmployee);
    }

    public void insertEmployee(Employee employee) {
        sampleDBDAO.insertEmployee(employee);
    }

    public void editEmployee(Employee selectedEmployee) {
        sampleDBDAO.editEmployee(selectedEmployee);
    }
}
