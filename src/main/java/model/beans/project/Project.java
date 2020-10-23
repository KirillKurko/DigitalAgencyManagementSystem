package model.beans.project;

public class Project {

    private int id;
    private String name;
    private String description;
    private double budget;

    public Project() {
    }

    public Project(int id, String name, String description, double budget) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.budget = budget;
    }

    public Project(String name, String description, double budget) {
        this.name = name;
        this.description = description;
        this.budget = budget;
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getBudget() {
        return budget;
    }

    public void setBudget(double budget) {
        this.budget = budget;
    }
}
