package models;

public class Merchant {
    private int id;
    private String email,pass,name;

    public Merchant(int id,String name, String email, String pass) {
        this.email = email;
        this.pass = pass;
        this.name = name;
        this.id=id;
    }
    public Merchant(int id,String name, String email) {
        this.email = email;

        this.name = name;
        this.id=id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


}
