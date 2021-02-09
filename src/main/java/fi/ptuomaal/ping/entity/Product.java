package fi.ptuomaal.ping.entity;

import javax.persistence.*;

/*
    Product luokka määrittelee mallin (model).
*/

@Entity
@NamedQueries({
        @NamedQuery
                (
                name=Product.NAMED_QUERY_GET_ALL,
                query="SELECT p FROM Product p"
                ),@NamedQuery
        (
                name=Product.NAMED_QUERY_FIND_BY_CATEGORY,
                query="SELECT p FROM Product p where p.category =:category"
        )
})
public class Product {
    public static final String NAMED_QUERY_GET_ALL="N3";
    public static final String NAMED_QUERY_FIND_BY_CATEGORY="N4";

    @Id
    @GeneratedValue
    private int id;

    @Column
    private String serial;

    @Column
    private String category;

    public Product() {   }

    public Product (int id, String serial, String category) {
        this.id = id;
        this.serial = serial;
        this.category = category;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSerial() {
        return serial;
    }

    public void setSerial(String serial) {
        this.serial = serial;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

}
