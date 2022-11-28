package pure.bershka.entities.concretes;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

import java.util.Date;
import java.util.List;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor

@Table(name = "sizes")
public class Size {
	@Id
	@Column(name = "size_id")
	private int sizeID;

	@Column(name = "size_name")
	private String sizeName;

	@ManyToMany(mappedBy = "sizes")
	private List<Category> categories;

}
