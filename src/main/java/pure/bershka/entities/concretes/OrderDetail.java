package pure.bershka.entities.concretes;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name="order_detail")
public class OrderDetail {

	@Id
	@Column(name="order_detail_id")
	private int id;
	
	@OneToOne
	@JoinColumn(name="order_id")
	private Order order;
	
	@ManyToMany
	  @JoinTable(name="p_detail_products", joinColumns = @JoinColumn(name = "order_detail_id"),
      inverseJoinColumns = @JoinColumn(name = "product_id"))
	private List<Product> product;
	
	@ManyToMany
	  @JoinTable(name="p_detail_sizes", joinColumns = @JoinColumn(name = "order_detail_id"),
      inverseJoinColumns = @JoinColumn(name = "size_id"))
	private List<Size> size;
	
	@Column(name="piece_amount")
	private int pieceAmount;

	
}
