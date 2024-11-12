package org.ciaf.user;

public class User {
    private int id;
    private String name;
    private String password;
    private String rol;
    private String email;

    public User(int id, String name, String password, String rol) {
        this.id = id;
        this.name = name;
        this.password = password;
        this.rol = rol;
    }

    public User(int id, String name, String email) {
        this.id = id;
        this.name = name;
        this.email = email;
    }

    public String getName() {
        return name;
    }



    public String getRol() {
        return rol;
    }


    public String getEmail() {
        return email;
    }

    public int getId() {
        return id;
    }



    @Override
    public String toString() {
        return "User{" +
                "name=' " + name + '\'' +
                ", rol= ' " + rol + '\'' +
                '}';
    }
}
