package pure.bershka.entities.concretes;


import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Qualifier;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Getter
@Setter
@Table(name = "orders")
public class Order {
    @Id
    @Column(name = "order_id")
    private int orderId;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne
    @JoinColumn(name = "location_id")
    private Location location;

//    @ManyToOne
//    @JoinColumn(name = "billing_location_id")
//    private Location billingLocation;

    @Column(name = "total_price")
    private int totalPrice;

    @Column(name = "creation_date")
    private Date creationDate;

    @ManyToOne
    @JoinColumn(name = "discount_code_id")
    private DiscountCode discountCode;
    
	@OneToOne(mappedBy="order")
	private OrderDetail orderDetail;

//    @ManyToMany
//    @JoinTable(name="order_detail", joinColumns = @JoinColumn(name = "order_id"),
//            inverseJoinColumns = @JoinColumn(name="order_detail_id"))
//    private List<Inventory> inventories;
}
