package pure.bershka.entities.concretes;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
@Entity
@Getter
@Setter
@Table(name = "images")
public class Image {
    @Column(name="image_id")
    @Id
    private int imageId;

    @Column(name = "img_url")
    private String url;

    @ManyToOne
    @JoinColumn(name="product_id")
    private Product product;
}
