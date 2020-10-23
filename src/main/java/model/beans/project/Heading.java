package model.beans.project;

public class Heading {

    private int id;
    private String name;
    private String description;
    private String periodicity;

    public Heading() {
    }

    public Heading(int id, String name, String description, String periodicity) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.periodicity = periodicity;
    }

    public Heading(String name, String description, String periodicity) {
        this.name = name;
        this.description = description;
        this.periodicity = periodicity;
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

    public String getPeriodicity() {
        return periodicity;
    }

    public void setPeriodicity(String periodicity) {
        this.periodicity = periodicity;
    }
}
