package pure.bershka.entities.concretes;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@Setter
public class Product {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private int productID;

    @ManyToOne
    private Category category;

    @ManyToOne
    private Color color;

    @ManyToOne
    private Material material;

    private String name;

    @Lob
    private String description;

    private int price;

    private String gender;

    @ManyToMany
    @JoinTable(name="campaign_id", joinColumns = @JoinColumn(name = "productId"),
                                    inverseJoinColumns = @JoinColumn(name="discountId"))
    private List<Discount> discountList;

    @ManyToOne
    private Size size;

    public Product() {
    }


}
