package model;

import javax.persistence.*;


@Entity
@Table(name="administrators")
public class Administrator {

    @Id
    @GeneratedValue
    @Column(name="admin_id")
    long adminId;

    @Column(name="admin_name")
    String name;

    @Column
    String password;

    public long getAdminId() {
        return adminId;
    }

    public void setAdminId(long adminId) {
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

    @Override
    public String toString() {
        return "Administrator{" +
                "adminId=" + adminId +
                ", name='" + name + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}

