package model.beans.employees.employeesImplementations;

public class Director extends Employee {

    private int id;
    private double finances;
    private int employeeID;

    public Director() {
    }

    public Director(int id, double finances, int employeeID, String name, String surname,
                    int experience, double salary, int userID,
                    int projectID) {
        super(employeeID, name, surname, experience, salary, userID, projectID);
        this.id = id;
        this.finances = finances;
        this.employeeID = employeeID;
    }

    public Director(double finances, int employeeID, String name, String surname,
                    int experience, double salary, int userID,
                    int projectID) {
        super(employeeID, name, surname, experience, salary, userID, projectID);
        this.finances = finances;
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

    public double getFinances() {
        return finances;
    }

    public void setFinances(double finances) {
        this.finances = finances;
    }

    public int getEmployeeID() {
        return employeeID;
    }

    public void setEmployeeID(int employeeID) {
        this.employeeID = employeeID;
    }
}
