package model.beans.employees.employeesImplementations;

public class Designer extends Employee {

    private int id;
    private boolean specialEducation;
    private int employeeID;

    public Designer() {
    }

    public Designer(int id, boolean specialEducation, int employeeID,
                    String name, String surname, int experience, double salary, int userID, int projectID) {
        super(employeeID, name, surname, experience, salary, userID, projectID);
        this.id = id;
        this.specialEducation = specialEducation;
        this.employeeID = employeeID;
    }

    public Designer(boolean specialEducation, int employeeID,
                    String name, String surname, int experience, double salary, int userID, int projectID) {
        super(employeeID, name, surname, experience, salary, userID, projectID);
        this.specialEducation = specialEducation;
        this.employeeID = employeeID;
    }

    @Override
    public int getId() {
        return id;
    }

    @Override
    public void setId(int id) {
        this.id = id;
    }

    public boolean isSpecialEducation() {
        return specialEducation;
    }

    public void setSpecialEducation(boolean specialEducation) {
        this.specialEducation = specialEducation;
    }

    public int getEmployeeID() {
        return employeeID;
    }

    public void setEmployeeID(int employeeID) {
        this.employeeID = employeeID;
    }
}
