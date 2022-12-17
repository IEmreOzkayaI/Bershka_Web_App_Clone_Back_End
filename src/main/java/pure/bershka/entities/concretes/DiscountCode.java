package pure.bershka.entities.concretes;

import com.fasterxml.jackson.annotation.JsonIgnore;
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

	@JsonIgnore
	@OneToMany(mappedBy = "discountCode", fetch = FetchType.LAZY)
	private List<Order> orders;

	public void setDiscountCode(DiscountCode discountCode){
		this.code = discountCode.getCode();
		this.amount = discountCode.getAmount();
		this.price = discountCode.getPrice();
	}
}
