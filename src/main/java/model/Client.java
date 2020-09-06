package model;

import javax.persistence.*;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name="Client")
public class Client {

    @Id
    @Column(name="client_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long clientId;

    @Column(name = "full_name")
    private String fullName;

    @OneToOne
    @JoinColumn(name = "address_id")
    private Address address;

    @OneToMany
    @JoinColumn(name = "Order_id")
    private Set<Order> orders=new HashSet<>();

    @OneToMany
    @JoinColumn(name = "Order_details")
    private Set<OrderDetails> orderDetailsSet = new HashSet<>();


    public Client(String fullName) {
        this.fullName = fullName;
    }

    public void setClientId(long clientId) {
        this.clientId = clientId;
    }

    public void setOrderList(Set<Order> orderList) {
        this.orders = orderList;
    }

    public long getClientId() {
        return clientId;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "Client{" +
                "clientId=" + clientId +
                ", fullName='" + fullName + '\'' +
                ", addressList=" + address +
                '}';
    }
}
