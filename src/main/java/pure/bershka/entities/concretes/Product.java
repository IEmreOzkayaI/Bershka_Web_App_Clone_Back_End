package pure.bershka.entities.concretes;


import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name="products")

public class Product{
    @Id
    @Column(name="product_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "name")
    private String name;

    @Column(name = "price")
    private BigDecimal price;

    @Enumerated(EnumType.STRING)
    @Column(name = "gender")
    private Gender gender;

    @Column(name = "discount_percentage")
    private BigDecimal discountPercentage;

    @ManyToOne
    @JoinColumn(name="category_id")
    private Category category;

    @ManyToOne
    @JoinColumn(name="color_id")
    private Color color;

/*    @ManyToOne
    @JoinColumn(name="material_id")
    private Material material;*/

    @ManyToOne
    @JoinColumn(name = "typology_id")
    private Typology typology;

    @JsonIgnore
    @ManyToMany
    @JoinTable(name="product_sizes", joinColumns = @JoinColumn(name = "product_id"),
            inverseJoinColumns = @JoinColumn(name = "size_id"))
    private List<Size> sizes;

    @JsonIgnore
    @OneToMany(mappedBy = "product", fetch = FetchType.LAZY)
    private List<Image> images;

    @JsonIgnore
    @ManyToMany(mappedBy = "basket", fetch = FetchType.LAZY)
    private List<Customer> basketOfCustomers;

    @JsonIgnore
    @ManyToMany(mappedBy = "favorites", fetch = FetchType.LAZY)
    private List<Customer> favoritesOfCustomers;

}
