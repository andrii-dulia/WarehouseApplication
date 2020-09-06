package model;

import javax.persistence.*;

@Entity
@Table(name="warehouse_items")
public class Warehouse {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="item_id")

    private long id;

    @Column(name = "material_number")
    String warehouseUniqueId;

    @OneToOne
    @JoinColumn(name="product_id")

    private Product product;

    @Column(name="quantity")
    int quantity;

    //GETTERS ANE SETTERS


    public void setId(long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public String getWarehouseUniqueId() {
        return warehouseUniqueId;
    }

    public void setWarehouseUniqueId(String warehouseUniqId) {
        this.warehouseUniqueId = warehouseUniqId;
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

    // CONSTRUCTORS

    public Warehouse(Product product, int quantity) {
        this.product = product;
        this.quantity = quantity;
    }
}
