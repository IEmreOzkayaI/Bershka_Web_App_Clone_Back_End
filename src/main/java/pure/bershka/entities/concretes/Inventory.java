package pure.bershka.entities.concretes;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@Table(name="product_size_amounts")
public class Inventory {
    @Id
    @Column(name = "stock_id")
    private int stockId;

    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product product;

    @ManyToOne
    @JoinColumn(name = "size_id")
    private Size size;

    @Column(name = "count")
    private int count;
}
