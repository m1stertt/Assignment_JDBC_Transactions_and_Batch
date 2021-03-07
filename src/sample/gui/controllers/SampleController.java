package sample.gui.controllers;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;
import sample.be.Employee;
import sample.gui.models.SampleModel;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class SampleController implements Initializable {

    SampleModel sampleModel = new SampleModel();

    @FXML
    private TableView<Employee> employeeTableview;
    @FXML
    private TableColumn<Employee, String> name;
    @FXML
    private TableColumn<Employee, String> salary;
    @FXML
    private TextField searchEmployee;

    private ObservableList<Employee> employeesList;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        initializeEmployeeTableview();
        employeeSearch();

    }

    public void onAddEmployee(ActionEvent actionEvent) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("../views/SampleEditModal.fxml"));
            Parent root = loader.load();
            handleStageGeneral(root, "Add New Employee");

        } catch (IOException e) {
            e.printStackTrace();
        }
        employeesList = FXCollections.observableList(sampleModel.getEmployees());
        employeeTableview.setItems(employeesList);
    }

    public void onEditEmployee(ActionEvent actionEvent) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("../views/SampleEditModal.fxml"));
            Parent root = loader.load();
            SampleEditModalController controller = loader.getController();
            controller.initializeEdit(employeeTableview.getSelectionModel().getSelectedItem());
            handleStageGeneral(root, "Edit Existing Employee");

        } catch (IOException e) {
            e.printStackTrace();
        }
        employeesList = FXCollections.observableList(sampleModel.getEmployees());
        employeeTableview.setItems(employeesList);
    }

    /**
     * Used to avoid duplicate code multiple places.
     */
    private void handleStageGeneral(Parent root, String title) {
        Scene scene = new Scene(root);
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.setResizable(false);
        stage.setTitle(title);
        stage.showAndWait();

    }

        public void initializeEmployeeTableview() {
        name.setCellValueFactory(new PropertyValueFactory<Employee, String>("name"));
        salary.setCellValueFactory(new PropertyValueFactory<Employee, String>("personalBonus"));
        employeesList = FXCollections.observableList(sampleModel.getEmployees());
        employeeTableview.setItems(employeesList);
        employeeTableview.setOnKeyPressed(new EventHandler<KeyEvent>() {
            @Override
            public void handle(final KeyEvent keyEvent) {
                final Employee selectedItem = employeeTableview.getSelectionModel().getSelectedItem();

                if (selectedItem != null) {
                    if (keyEvent.getCode().equals(KeyCode.DELETE)) {
                        //Delete or whatever you like:
                        onDelete();
                    }
                }
            }
        });
    }


    public void employeeSearch() {
        searchEmployee.textProperty().addListener((observableValue, oldText, newText) -> {
            employeesList.setAll(sampleModel.searchEmployeeDB(newText));

        });
    }

    public void onDelete() {
        sampleModel.deleteEmployee(employeeTableview.getSelectionModel().getSelectedItem());
        employeesList = FXCollections.observableList(sampleModel.getEmployees());
        employeeTableview.setItems(employeesList);
    }

    public void onIncrementPersonalBonus(ActionEvent actionEvent) {
        sampleModel.updateEmployeePersonalBonus(employeeTableview.getItems().subList(0,employeeTableview.getItems().size()), 10);

    }

    public void onDecrementPersonalBonus(ActionEvent actionEvent) {
        sampleModel.updateEmployeePersonalBonus(employeeTableview.getItems().subList(0,employeeTableview.getItems().size()), -10);
    }
}
