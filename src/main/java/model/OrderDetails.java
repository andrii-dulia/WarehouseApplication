package model;

import javax.persistence.*;

@Entity(name="order_details")
public class OrderDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="detail_id")

    private Long orderDetailsId ;

    @ManyToOne
    @JoinColumn(name="product_id")

    private Product product;

    @Column(name="quantity")
    private Long quantity;

    @ManyToOne
    @JoinColumn(name="order_id")

    private Order order;

    // CONSTRUCTORS


    public OrderDetails(Product product, Long quantity) {
        this.product = product;
        this.quantity = quantity;
    }

    public long getOrderDetailsId() {
        return orderDetailsId;
    }

    public void setOrderDetailsId(Long orderDetailsId) {
        this.orderDetailsId = orderDetailsId;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public Long getQuantity() {
        return quantity;
    }

    public void setQuantity(Long quantity) {
        this.quantity = quantity;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }
}