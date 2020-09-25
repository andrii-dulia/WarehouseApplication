package model;

import com.sun.istack.NotNull;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Entity(name="clients")
public class Client implements Serializable {

    @Id
    @Column(name = "client_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Column(name = "short_company_name")
    private String companyName;

    @Column(name = "full_company_name")
    private String fullName;

    @OneToOne
    @JoinColumn(name = "address_id")
    private Address address;

    @OneToMany
    @JoinColumn(name = "Order_id")
    private Set<Order> orders = new HashSet<>();

    @OneToMany
    @JoinColumn(name = "Order_details")
    private Set<OrderDetails> orderDetailsSet = new HashSet<>();


    public long getClientId() {
        return id;
    }

    public void setClientId(Long clientId) {
        this.id = clientId;
    }

    public String getCompanyName(String companyName) {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public void setOrderList(Set<Order> orderList) {
        this.orders = orderList;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }
}

