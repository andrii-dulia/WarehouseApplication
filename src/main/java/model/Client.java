package model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "Client")
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
    @JoinColumn(name = "Order")
    List<Order> orderList;

    public Client(String fullName) {
        this.fullName = fullName;
    }

    public long getClientId() {
        return clientId;
    }

    public void setClientId(int clientId) {
        this.clientId = clientId;
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
