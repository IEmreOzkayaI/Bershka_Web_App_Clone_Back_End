package pure.bershka.entities.concretes;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@Setter
@Table(name="products")
public class Product {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name="product_id")
    private int productID;

    @Column(name = "name")
    private String name;

    @Lob
    @Column(name = "description")
    private String description;

    @Column(name = "price")
    private int price;

    @Column(name = "gender")
    private String gender;

    @Column(name = "discount_percentage")
    private int discountPercentage;

    @ManyToOne
    @JoinColumn(name="category_id")
    private Category category;

    @ManyToOne
    @JoinColumn(name="color_id")
    private Color color;

    @ManyToOne
    @JoinColumn(name="material_id")
    private Material material;

    @ManyToOne
    @JoinColumn(name = "typology_id")
    private Typology typology;

    @OneToMany(mappedBy = "product")
    private List<Image> images;


//    @OneToMany(mappedBy = "product")
//    private List<Refund> returnedProducts;
//
//    @OneToMany(mappedBy = "product")
//    private List<ProductSizeAmount> productSizeAmounts;

//    @ManyToMany
//    @JoinTable(name="campaigns", joinColumns = @JoinColumn(name = "product_id"),
//                                    inverseJoinColumns = @JoinColumn(name="discount_id"))
//    private List<Discount> campaigns;

    public Product() {
    }


}
