package com.example.tugasifapps2.Model;

import java.lang.reflect.Array;

public class User {
    private String id;
    private String name;
    private String email;
    private String archivedAt;
    private String roles;

    public User( String id, String name, String email, String archived_at, String roles){
        this.id = id;
        this.name = name;
        this.email = email;
        this.archivedAt = archivedAt;
        this.roles = roles;
    }

    public String getId(){
        return id;
    }

    public String getName(){
        return name;
    }

    public String getEmail(){
        return email;
    }

    public String getArchivedAt(){
        return archivedAt;
    }

    public String getRoles() {
        return roles;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setArchivedAt(String archivedAt) {
        this.archivedAt = archivedAt;
    }

    public void setRoles(String roles) {
        this.roles = roles;
    }
}
