package pure.bershka.entities.concretes;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.List;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "colors")
public class Color {
    @Id
    @Column(name = "color_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "color_name")
    private String name;

    @JsonIgnore
    @OneToMany(mappedBy = "color")
    private List<Product> products;

    @JsonIgnore
    @ManyToMany(mappedBy = "colors")
    private List<Category> categories;
}
