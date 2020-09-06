package model;

import javax.persistence.*;

@Entity
@Table(name="Order_details")
public class OrderDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="detail_id")
    private long orderDetailsId ;

    @ManyToOne
    @JoinColumn(name="product_id")
    private Product product;

    @Column(name="quantity")
    private int quantity;

    @ManyToOne
    @JoinColumn(name = "Order_id")

    private Order order;

    @ManyToOne
    @JoinColumn(name = "Client")
    private Client client;

    // CONSTRUCTORS


    public OrderDetails(Product product, int quantity) {
        this.product = product;
        this.quantity = quantity;
    }

    public Client getClient() {
        return client;
    }

    public long getOrder_details_id() {
        return orderDetailsId;
    }

    public void setOrder_details_id(long order_details_id) {
        this.orderDetailsId = orderDetailsId;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    @Override
    public String toString() {
        return "OrderDetails{" +
                "orederDetailsId=" + orderDetailsId +
                ", product=" + product.getName() +
                ", quantity=" + quantity +
                ", order=" + order +
                '}';
    }
}