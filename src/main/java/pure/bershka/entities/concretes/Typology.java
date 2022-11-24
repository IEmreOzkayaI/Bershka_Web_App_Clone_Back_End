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
    @Column(name = "typology_id")
    @Id
    private int typologyId;

    @Column(name = "typology_name")
    private String typologyName;

    @OneToMany(mappedBy = "typology")
    private List<Product> products;
}
