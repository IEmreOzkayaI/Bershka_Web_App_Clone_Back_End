package pure.bershka.entities.concretes;

import java.util.List;

import javax.persistence.*;

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
	private Order order;

	@ManyToOne
	@JoinColumn(name = "product_id")
	private Product product;

	@ManyToOne
	@JoinColumn(name = "size_id")
	private Size size;

	@Column(name = "amount")
	private int amount;

	@Column(name = "isRefunded")
	private boolean isRefunded;

	public OrderDetail(Order order, Product product, Size size, int amount, boolean isRefunded) {
		this.order = order;
		this.product = product;
		this.size = size;
		this.amount = amount;
		this.isRefunded = isRefunded;
	}
}
