package pure.bershka.entities.concretes;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.List;


@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "categories")
public class Category {

	
    @Id
    @Column(name = "category_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    
    @JsonIgnore
    @ManyToMany
    @JoinTable(name="typologies_for_category", joinColumns = @JoinColumn(name = "category_id"),
            inverseJoinColumns = @JoinColumn(name="typology_id"))
    private List<Category> typologies;

    @Column(name = "category_name")
    private String name;

    @JsonIgnore
    @OneToMany(mappedBy = "category")
    private List<Product> products;

    @JsonIgnore
    @ManyToMany
    @JoinTable(name="colors_for_category", joinColumns = @JoinColumn(name = "category_id"),
            inverseJoinColumns = @JoinColumn(name="color_id"))
    private List<Color> colors;

    @JsonIgnore
    @ManyToMany
    @JoinTable(name="sizes_for_category", joinColumns = @JoinColumn(name = "category_id"),
            inverseJoinColumns = @JoinColumn(name="size_id"))
    private List<Size> sizes;

}
