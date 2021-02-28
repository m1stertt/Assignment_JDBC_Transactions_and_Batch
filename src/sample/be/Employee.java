package sample.be;

public class Employee {

    private int id;
    private String name;
    private String personalBonus;
    private int onLeave;
    private String phoneNumber;

    public Employee(int id, String name, String personalBonus, int onLeave, String phoneNumber) {
        this.id = id;
        this.name = name;
        this.personalBonus = personalBonus;
        this.onLeave = onLeave;
        this.phoneNumber = phoneNumber;
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
