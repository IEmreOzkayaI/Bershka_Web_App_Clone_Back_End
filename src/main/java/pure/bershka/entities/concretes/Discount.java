package pure.bershka.entities.concretes;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import java.util.List;

@Entity
@Getter
@Setter
public class Discount {
    @Id
    private int discountId;

    @ManyToMany(mappedBy = "discountList")
    private List<Product> productList;
}
