package sample.gui.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import sample.be.Employee;
import sample.gui.models.SampleModel;

public class SampleEditModalController {


    @FXML
    private Button cancelButton;
    @FXML
    private TextField nameTextfield;
    @FXML
    private TextField salaryTextfield;
    @FXML
    private TextField onLeaveTextfield;
    @FXML
    private TextField phoneNumberTextfield;
    @FXML
    private TextField salaryGroupIdTextfield;

    private SampleModel sampleModel = new SampleModel();

    private Employee selectedEmployee;

    private Boolean editMode = false;

    public void setSelectedEmployee(Employee selectedEmployee) {
        this.selectedEmployee = selectedEmployee;
    }

    public void initializeEdit(Employee employee) {
    nameTextfield.setText(employee.getName());
    salaryTextfield.setText(employee.getPersonalBonus());
    onLeaveTextfield.setText(String.valueOf( employee.getOnLeave()));
    phoneNumberTextfield.setText(employee.getPhoneNumber());
    salaryGroupIdTextfield.setText(String.valueOf(employee.getSalaryGroupId()));
    setEditMode(true);
    setSelectedEmployee(employee);
    }

    public void onSave(ActionEvent actionEvent) {
        if (editMode){
            onSaveEdit();
            Stage window = (Stage) cancelButton.getScene().getWindow();
            window.close();
            return;
        }
        sampleModel.insertEmployee(new Employee(nameTextfield.getText(), salaryTextfield.getText(), Integer.valueOf(onLeaveTextfield.getText()), phoneNumberTextfield.getText(), Integer.valueOf(salaryGroupIdTextfield.getText()), "", 0));
        Stage window = (Stage) cancelButton.getScene().getWindow();
        window.close();
    }

    public void setEditMode(Boolean editMode) {
        this.editMode = editMode;
    }

    public void onSaveEdit(){
        sampleModel.editEmployee(new Employee(selectedEmployee.getId(), nameTextfield.getText(), salaryTextfield.getText(), Integer.valueOf(onLeaveTextfield.getText()), phoneNumberTextfield.getText(), Integer.valueOf(salaryGroupIdTextfield.getText()), "", 0));
    }

    public void onCancel(ActionEvent actionEvent) {
        Stage window = (Stage) cancelButton.getScene().getWindow();
        window.close();
    }
}
