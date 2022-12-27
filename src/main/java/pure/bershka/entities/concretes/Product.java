package pure.bershka.entities.concretes;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.*;
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
    @NotNull
    private int id;

    @Column(name = "name")
    @NotBlank
    private String name;

    @Column(name = "price")
    private BigDecimal price;

    @Enumerated(EnumType.STRING)
    @Column(name = "gender")
    @NotNull
    private Gender gender;

    @Column(name = "discount_percentage")
    @Min(0)
    @Max(100)
    private BigDecimal discountPercentage;

    @ManyToOne
    @JoinColumn(name="category_id")
    @NotNull
    private Category category;

    @ManyToOne
    @JoinColumn(name="color_id")
    @NotNull
    private Color color;

/*    @ManyToOne
    @JoinColumn(name="material_id")
    private Material material;*/

    @ManyToOne
    @JoinColumn(name = "typology_id")
    @NotNull
    private Typology typology;

    @JsonIgnore
    @ManyToMany
    @JoinTable(name="product_sizes", joinColumns = @JoinColumn(name = "product_id"),
            inverseJoinColumns = @JoinColumn(name = "size_id"))
    private List<Size> sizes;

    @JsonManagedReference
    @OneToMany(mappedBy = "product", fetch = FetchType.LAZY)
    @NotEmpty
    private List<Image> images;

    @JsonIgnore
    @ManyToMany(mappedBy = "basket", fetch = FetchType.LAZY)
    @NotEmpty
    private List<Customer> basketOfCustomers;

    @JsonIgnore
    @ManyToMany(mappedBy = "favorites", fetch = FetchType.LAZY)
    @NotEmpty
    private List<Customer> favoritesOfCustomers;

    public void setProduct(Product product){
        this.name = product.getName();
        this.price = product.getPrice();
        this.gender = product.getGender();
        this.discountPercentage = product.getDiscountPercentage();
    }
}
