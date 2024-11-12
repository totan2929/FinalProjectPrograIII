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

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRol() {
        return rol;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }

    public String getEmail() {
        return email;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public boolean verifyPassword(String password){
        return this.password.equals(password);
    }

    @Override
    public String toString() {
        return "User{" +
                "name=' " + name + '\'' +
                ", rol= ' " + rol + '\'' +
                '}';
    }
}
