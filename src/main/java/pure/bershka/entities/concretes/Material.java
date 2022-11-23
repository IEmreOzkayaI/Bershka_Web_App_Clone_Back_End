package pure.bershka.entities.concretes;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@Setter
@Table(name = "materials")
public class Material {
    @Id
    @Column(name = "material_id")
    private int materialId;

    @Column(name = "material_name")
    private String materialName;

    @Column(name = "material_percentage")
    private int materialPercentage;

    @OneToMany(mappedBy = "material")
    private List<Product> products;
}
