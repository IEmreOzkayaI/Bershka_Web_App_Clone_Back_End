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
    @Id
    @Column(name="product_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

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

    @ManyToMany(mappedBy = "basket")
    private List<Customer> basketOfCustomers;

    @ManyToMany(mappedBy = "favorites")
    private List<Customer> favoritesOfCustomers;

    public Product() {
    }


}
