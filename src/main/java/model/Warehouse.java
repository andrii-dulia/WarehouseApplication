package model;

import javax.persistence.*;

@Entity(name="warehouse_items")
public class Warehouse {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="item_id")
    Long id;

    @Column(name = "material_name")
    private String warehouseUniqueName;

    @OneToOne
    @JoinColumn(name="product_id")
    private Product product;

    @Column(name="quantity")
    private Long quantity;

    //GETTERS ANE SETTERS


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getWarehouseUniqueName() {
        return warehouseUniqueName;
    }

    public void setWarehouseUniqueName(String warehouseUniqId) {
        this.warehouseUniqueName = warehouseUniqId;
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

    // CONSTRUCTORS


    public Warehouse() {
    }

    public Warehouse(Product product, Long quantity) {
        this.product = product;
        this.quantity = quantity;
    }
}
