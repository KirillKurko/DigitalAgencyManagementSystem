package model.beans.employees.employeesImplementations;

public class Copywriter extends Employee {

    private int id;
    private String mainStyle;
    private int employeeID;

    public Copywriter() {
    }

    public Copywriter(int id, String mainStyle, int employeeID,
                      String name, String surname, int experience, double salary, int userID, int projectID) {
        super(employeeID, name, surname, experience, salary, userID, projectID);
        this.id = id;
        this.mainStyle = mainStyle;
        this.employeeID = employeeID;
    }

    public Copywriter(String mainStyle, int employeeID,
                      String name, String surname, int experience, double salary, int userID, int projectID) {
        super(employeeID, name, surname, experience, salary, userID, projectID);
        this.mainStyle = mainStyle;
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

    public String getMainStyle() {
        return mainStyle;
    }

    public void setMainStyle(String mainStyle) {
        this.mainStyle = mainStyle;
    }

    public int getEmployeeID() {
        return employeeID;
    }

    public void setEmployeeID(int employeeID) {
        this.employeeID = employeeID;
    }
}
