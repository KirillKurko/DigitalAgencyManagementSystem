package model.beans;

public class DigitalAgency {

    private int id;
    private String name;
    private String email;
    private String description;
    private int directorID;

    public DigitalAgency() {
    }

    public DigitalAgency(int id, String name, String email, String description, int directorID) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.description = description;
        this.directorID = directorID;
    }

    public DigitalAgency(String name, String email, String description, int directorID) {
        this.name = name;
        this.email = email;
        this.description = description;
        this.directorID = directorID;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getDirectorID() {
        return directorID;
    }

    public void setDirectorID(int directorID) {
        this.directorID = directorID;
    }
}
