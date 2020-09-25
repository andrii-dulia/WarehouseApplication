package model;

import javax.persistence.*;
import java.io.Serializable;

@Entity(name="managers")
public class Manager implements Serializable {

    @Id
    @Column(name = "manager_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="manager_name")
    private String name;

    @Column
    private String password;

    public void setManagerId(long managerId) {
        this.id = managerId;
    }

    public Long getManagerId() {
        return id;
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
}
