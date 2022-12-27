package pure.bershka.entities.concretes;

import java.util.List;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import lombok.*;

@Data
@Entity
@Table(name="order_detail")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class OrderDetail {
	@Id
	@Column(name = "order_detail_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@ManyToOne
	@JoinColumn(name = "order_id")
	@NotNull(message = "Order id must be given.")
	private Order order;

	@ManyToOne
	@JoinColumn(name = "product_id")
	@NotNull(message = "Product id must be given.")
	private Product product;

	@ManyToOne
	@JoinColumn(name = "size_id")
	@NotNull(message = "Size id must be given.")
	private Size size;

	@Column(name = "amount")
	@NotNull(message = "Amount of this related product to buy must be given.")
	@Min(value = 1,message = "Minimum amount must be 1.")
	private int amount;

	@Column(name = "isRefunded")
	@NotNull(message = "To check this product's refund status, it should be given false default.")
	private boolean isRefunded;

	public OrderDetail(Order order, Product product, Size size, int amount, boolean isRefunded) {
		this.order = order;
		this.product = product;
		this.size = size;
		this.amount = amount;
		this.isRefunded = isRefunded;
	}
}
