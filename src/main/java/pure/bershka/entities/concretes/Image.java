package pure.bershka.entities.concretes;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "images")
public class Image {
	@Id
	@Column(name = "image_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Column(name = "img_url")
	@NotBlank(message = "Image url cannot be empty.")
	private String url;

	@JsonBackReference
	@ManyToOne
	@JoinColumn(name = "product_id")
	@NotNull(message = "Image must be belong to only 1 product.")
	private Product product;

	public void setImage(Image image){
		this.url = image.getUrl();
	}
}
