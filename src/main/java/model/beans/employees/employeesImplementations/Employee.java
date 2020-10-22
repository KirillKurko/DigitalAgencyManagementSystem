package model.beans.employees.employeesImplementations;

import model.beans.employees.EmployeeInterface;

public class Employee implements EmployeeInterface {

    private int id;
    private String name;
    private String surname;
    private int experience;
    private double salary;
    private int userID;
    private int projectID;

    public Employee() {
    }

    public Employee(int id, String name, String surname, int experience, double salary, int userID, int projectID) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.experience = experience;
        this.salary = salary;
        this.userID = userID;
        this.projectID = projectID;
    }

    public Employee(String name, String surname, int experience, double salary, int userID, int projectID) {
        this.name = name;
        this.surname = surname;
        this.experience = experience;
        this.salary = salary;
        this.userID = userID;
        this.projectID = projectID;
    }


    @Override
    public int getId() {
        return id;
    }

    @Override
    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String getSurname() {
        return surname;
    }

    @Override
    public void setSurname(String surname) {
        this.surname = surname;
    }

    @Override
    public int getExperience() {
        return experience;
    }

    @Override
    public void setExperience(int experience) {
        this.experience = experience;
    }

    @Override
    public double getSalary() {
        return salary;
    }

    @Override
    public void setSalary(double salary) {
        this.salary = salary;
    }

    @Override
    public int getUserID() {
        return userID;
    }

    @Override
    public void setUserID(int userID) {
        this.userID = userID;
    }

    @Override
    public int getProjectID() {
        return projectID;
    }

    @Override
    public void setProjectID(int projectID) {
        this.projectID = projectID;
    }
}
