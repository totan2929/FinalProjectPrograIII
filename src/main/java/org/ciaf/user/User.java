package org.ciaf.user;

public class User {
    private String name;
    private String password;
    private String rol;

    public User(String name, String password, String rol) {
        this.name = name;
        this.password = password;
        this.rol = rol;
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
