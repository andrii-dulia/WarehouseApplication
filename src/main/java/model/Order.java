package model;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name="orders")
public class Order {
    @Id
    @Column(name="order_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @OneToMany(mappedBy = "order",cascade = CascadeType.ALL)
    private Set<OrderDetails> ordersDetails=new HashSet<>();

    @ManyToOne
    @JoinColumn(name = "Client")
    private Client client;


    @Column
    String  address;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Set<OrderDetails> getOrdersDetails() {
        return ordersDetails;
    }

    public void setOrdersDetails(Set<OrderDetails> ordersDetails) {
        this.ordersDetails = ordersDetails;
    }

    public String getAdress() {
        return address;
    }

    public void setAdress(String adress) {
        this.address = adress;
    }

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", ordersDetails=" + ordersDetails +
                ", adress='" + address + '\'' +
                '}';
    }
}


