package model;

import javax.persistence.*;

@Entity
@Table(name="order_details")
public class OrderDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="detail_id")

    long    orederDetailsId ;

    @ManyToOne
    @JoinColumn(name="product_id")

    private Product product;

    @Column(name="quantity")
    private int quantity;

    @ManyToOne
    @JoinColumn(name="order_id")

    private Order order;

    // CONSTRUCTORS


    public OrderDetails(Product product, int quantity) {
        this.product = product;
        this.quantity = quantity;
    }

    public long getOrederDetailsId() {
        return orederDetailsId;
    }

    public void setOrederDetailsId(long orederDetailsId) {
        this.orederDetailsId = orederDetailsId;
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
                "orederDetailsId=" + orederDetailsId +
                ", product=" + product.getName() +
                ", quantity=" + quantity +
                ", order=" + order +
                '}';
    }
}