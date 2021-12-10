package by.bsuir.code.lab4.entity;

import java.io.Serializable;

public class User implements Serializable {

    private int id;
    private String name;
    private String login;
    private String passHash;
    private String role;

    public class UserRole {
        public static final String guest = "guest";
        public static final String user = "user";
        public static final String admin = "admin";
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

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassHash() {
        return passHash;
    }

    public void setPassHash(String passHash) {
        this.passHash = passHash;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public User() {

    }

    public User(String name, String login, String passHash, String role) {
        this.name = name;
        this.login = login;
        this.passHash = passHash;
        this.role = role;
    }

    public User(int id, String name, String login, String passHash, String role) {
        this.id = id;
        this.name = name;
        this.login = login;
        this.passHash = passHash;
        this.role = role;
    }
}