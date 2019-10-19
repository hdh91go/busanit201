package com.example.todosampleapp.model;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "loginItem")
public class LoginItem {
    @PrimaryKey(autoGenerate = true)
    int no;
    String email;
    String password;

    public int getNo() {
        return no;
    }

    public void setNo(int no) {
        this.no = no;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String title) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String content) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "loginItem {" +
                "no=" + no +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
