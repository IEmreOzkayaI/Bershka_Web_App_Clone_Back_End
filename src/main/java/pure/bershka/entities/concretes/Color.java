package pure.bershka.entities.concretes;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@Setter
@Table(name = "colors")
public class Color {
    @Id
    @Column(name = "color_id")
    private int colorId;

    @Column(name = "color_name")
    private String colorName;

    @OneToMany(mappedBy = "color")
    private List<Product> products;
}
