package pure.bershka.entities.concretes;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

import java.util.List;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "discount_codes")
public class DiscountCode {
	@Id
	@Column(name = "discount_code_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Column(name = "discount_code")
	private String code;

	@Column(name = "discount_code_amount")
	private int amount;

	@Column(name = "discount_price")
	private int price;

	@OneToMany(mappedBy = "discountCode")
	private List<Order> orders;
}
