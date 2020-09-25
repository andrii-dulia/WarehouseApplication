package model;

import javax.persistence.*;


@Entity(name="administrators")
public class Administrator {

    @Id
    @GeneratedValue
    @Column(name="admin_id")
    private Long adminId;

    @Column(name="admin_name")
    private String name;

    @Column
    private String password;

    public Long getAdminId() {
        return adminId;
    }

    public void setAdminId(Long adminId) {
        this.adminId = adminId;
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

