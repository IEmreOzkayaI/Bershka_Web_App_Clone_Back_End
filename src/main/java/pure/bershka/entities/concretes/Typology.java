package pure.bershka.entities.concretes;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@Setter
@Table(name="typologies")
public class Typology {
    @Id
    @Column(name = "typology_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToMany(mappedBy = "typologies")
    private List<Category> categories;

    @Column(name = "typology_name")
    private String name;

    @OneToMany(mappedBy = "typology")
    private List<Product> products;
}
