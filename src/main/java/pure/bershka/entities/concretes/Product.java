package pure.bershka.entities.concretes;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name="product")
public class Product {
	
	@Column(name="id")
	@Id
	private int id;
	
	@Column(name="name")
	private char name;
	
}
