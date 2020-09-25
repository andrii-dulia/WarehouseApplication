package model;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity(name="products")
public class Product {
    @Id
    @Column(name="product_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long productId;

    @Column(name="product_name")
    private String name;

    @Column(name="product_price")
    private Long price;


    @OneToMany(mappedBy = "product")
    private Set<OrderDetails> ordersDetails=new HashSet<>();

    @OneToOne(mappedBy = "product")
    private Warehouse warehouseItem;


    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public void setOrdersDetails(Set<OrderDetails> ordersDetails) {
        this.ordersDetails = ordersDetails;
    }

    public void setWarehouseItem(Warehouse warehouseItem) {
        this.warehouseItem = warehouseItem;
    }

    public Long getProductId() {
        return productId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getPrice() {
        return price;
    }

    public void setPrice(Long price) {
        this.price = price;
    }
}

