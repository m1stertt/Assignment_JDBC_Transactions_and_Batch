package sample.be;

public class Employee {

    private int id;
    private String name;
    private String personalBonus;
    private int onLeave;
    private String phoneNumber;
    private int salaryGroupId;
    private String groupName;
    private double salary;

    public Employee(int id, String name, String personalBonus, int onLeave, String phoneNumber, int salaryGroupId, String groupName, double salary) {
        this.id = id;
        this.name = name;
        this.personalBonus = personalBonus;
        this.onLeave = onLeave;
        this.phoneNumber = phoneNumber;
        this.salaryGroupId = salaryGroupId;
    }
    public Employee(String name, String personalBonus, int onLeave, String phoneNumber, int salaryGroupId, String groupName, double salary) {
        this.name = name;
        this.personalBonus = personalBonus;
        this.onLeave = onLeave;
        this.phoneNumber = phoneNumber;
        this.salaryGroupId = salaryGroupId;
    }

    public int getSalaryGroupId() {
        return salaryGroupId;
    }

    public void setSalaryGroupId(int salaryGroupId) {
        this.salaryGroupId = salaryGroupId;
    }

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPersonalBonus() {
        return personalBonus;
    }

    public void setPersonalBonus(String personalBonus) {
        this.personalBonus = personalBonus;
    }

    public int getOnLeave() {
        return onLeave;
    }

    public void setOnLeave(int onLeave) {
        this.onLeave = onLeave;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }


}
