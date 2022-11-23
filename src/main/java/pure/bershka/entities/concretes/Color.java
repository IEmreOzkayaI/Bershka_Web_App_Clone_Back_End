package pure.bershka.entities.concretes;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.List;

@Entity
@Getter
@Setter
public class Color {
    @Id
    private int colorId;

    @OneToMany(mappedBy = "color")
    private List<Product> productList;
}
