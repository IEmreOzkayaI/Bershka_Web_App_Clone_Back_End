package pure.bershka.entities.concretes;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Entity
@Getter
@Setter
@Table(name="returned_products")
public class ReturnedProduct {
    @Id
    @Column(name = "returned_product_id")
    private int returnedProductId;

    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product product;

    @Column(name = "request_date")
    private Date requestDate;

    @Lob
    @Column(name = "cause")
    private String cause;

}
