package model;

import javax.persistence.*;

@Entity
@Table(name="warehouse_items")
public class Warehouse {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="item_id")

    long    id ;

    @Column(name = "material_name")
    String warehouseUniqueName;

    @OneToOne
    @JoinColumn(name="product_id")

    private Product product;

    @Column(name="quantity")
    int quantity;

    //GETTERS ANE SETTERS


    public long getId() {
        return id;
    }

    public void setId(long id) {
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

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    // CONSTRUCTORS


    public Warehouse() {
    }

    public Warehouse(Product product, int quantity) {
        this.product = product;
        this.quantity = quantity;
    }
}
