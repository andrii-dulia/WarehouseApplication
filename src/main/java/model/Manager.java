package model;

import javax.persistence.*;
import java.util.Scanner;

@Entity
@Table(name="managers")
public class Manager {
    @Id
    @GeneratedValue
    @Column(name="manager_id")

    long managerId;

    @Column(name="manager_name")

    String name;

    @Column
    String password;

    public void setManagerId(long managerId) {
        this.managerId = managerId;
    }

    public long getManagerId() {
        return managerId;
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

    @Override
    public String toString() {
        return "model.Client.Manager{" +
                "managerId=" + managerId +
                ", name='" + name + '\'' +
                ", password='" + password + '\'' +
                '}';
    }



}
