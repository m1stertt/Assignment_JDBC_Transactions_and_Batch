package sample.dal;

import sample.be.Employee;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class SampleDBDAO {

    private DBConnector dataSource = new DBConnector();

    /**
     * Method to return all employees from the DB.
     *
     * @return a list of all employees in the database.
     */
    public List<Employee> getListOfAllEmployees() {
        List<Employee> allEmployees = new ArrayList<>();
        try (Connection con = dataSource.getConnection()) {
            String sql = "SELECT * FROM Employee ORDER BY id";
            PreparedStatement pstmt = con.prepareStatement(sql);
            ResultSet rs = pstmt.executeQuery();

            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                String salary = rs.getString("salary");
                int onLeave = rs.getInt("onLeave");
                String phoneNumber = rs.getString("phoneNumber");

                Employee e = new Employee(id, name, salary, onLeave, phoneNumber);
                allEmployees.add(e);
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return allEmployees;
    }

    /**
     * Insert employee to the Employee table in the database.
     *
     * @param employee to be inserted.
     * @returns the inserted movie with the auto-generated id.
     */
    public void insertEmployee(Employee employee) {
        try (Connection con = dataSource.getConnection()) {

            String sql = "INSERT INTO Employee (name, salary, onLeave, phoneNumber) VALUES (?, ?, ?, ?)";
            PreparedStatement pstmt = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);

            pstmt.setString(1, employee.getName());
            pstmt.setString(2,employee.getPersonalBonus());
            pstmt.setInt(3,employee.getOnLeave());
            pstmt.setString(4,employee.getPhoneNumber());

            pstmt.executeUpdate();


        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }


    /**
     * Deletes the selected employee from the database.
     *
     * @param employee to be deleted.
     */
    public void deleteEmployee(Employee employee) {
        try (Connection con = dataSource.getConnection()) {
            String sql = "DELETE FROM Employee WHERE id=?";
            PreparedStatement pstmt = con.prepareStatement(sql);
            pstmt.setInt(1, employee.getId());
            pstmt.executeUpdate();

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }


    /**
     * Method to update personal rating on chosen movie in the database.
     */
    public void editEmployee(Employee selectedEmployee) {
        try (Connection con = dataSource.getConnection()) {

            String sql = "UPDATE Employee SET name=?, salary=?, onLeave=?, phoneNumber=?  WHERE id=?";
            PreparedStatement pstmt = con.prepareStatement(sql);

            pstmt.setString(1,selectedEmployee.getName());
            pstmt.setString(2, selectedEmployee.getPersonalBonus());
            pstmt.setInt(3,selectedEmployee.getOnLeave());
            pstmt.setString(4,selectedEmployee.getPhoneNumber());
            pstmt.setInt(5, selectedEmployee.getId());
            pstmt.executeUpdate();


        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public List<Employee> searchEmployeeDB(String text) {
        List<Employee> allEmployees = new ArrayList<>();
        try (Connection con = dataSource.getConnection()) {
            String sql = "SELECT * FROM Employee WHERE name LIKE '%" + text + "%'";
            PreparedStatement pstmt = con.prepareStatement(sql);
            ResultSet rs = pstmt.executeQuery();

            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                String salary = rs.getString("salary");
                int onLeave = rs.getInt("onLeave");
                String phoneNumber = rs.getString("phoneNumber");

                Employee e = new Employee(id, name, salary, onLeave, phoneNumber);
                allEmployees.add(e);
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return allEmployees;
    }
    }

