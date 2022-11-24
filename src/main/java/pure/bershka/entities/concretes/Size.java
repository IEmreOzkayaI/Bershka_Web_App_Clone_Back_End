package pure.bershka.entities.concretes;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@Setter
@Table(name = "sizes")
public class Size {
    @Id
    @Column(name = "size_id")
    private int sizeID;

    @Column(name = "size_name")
    private String sizeName;

    @OneToMany(mappedBy = "size")
    private List<Inventory> productSizeAmounts;


}
