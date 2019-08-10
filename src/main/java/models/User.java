package models;

public class User {

    String name,type;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    int id;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
