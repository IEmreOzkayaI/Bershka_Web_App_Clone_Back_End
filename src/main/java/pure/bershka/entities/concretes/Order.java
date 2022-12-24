package pure.bershka.entities.concretes;


import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "orders")
public class Order {
    @Id
    @Column(name = "order_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "total_price")
    private int totalPrice;

    @Column(name = "creation_date")
    private LocalDateTime creationDate;

    @ManyToOne
    @JoinColumn(name = "customer_id")
    private Customer customer;

    @ManyToOne
    @JoinColumn(name = "location_id")
    private Location location;

    @ManyToOne
    @JoinColumn(name = "billing_location_id")
    private Location billingLocation;

    @ManyToOne
    @JoinColumn(name = "discount_code_id")
    private DiscountCode discountCode;

    @JsonIgnore
    @OneToMany(mappedBy = "order", fetch = FetchType.LAZY)
    private List<OrderDetail> orderDetails;

    @JsonIgnore
    @OneToMany(mappedBy = "product", fetch = FetchType.LAZY)
    private List<OrderDetail> products;

    @JsonIgnore
    @OneToMany(mappedBy = "size", fetch = FetchType.LAZY)
    private List<OrderDetail> sizes;

    public Order(int totalPrice, LocalDateTime creationDate, Customer customer,
                 Location location, Location billingLocation, DiscountCode
                         discountCode) {
        this.totalPrice = totalPrice;
        this.creationDate = creationDate;
        this.customer = customer;
        this.location = location;
        this.billingLocation = billingLocation;
        this.discountCode = discountCode;
    }

//    public Order(Date creationDate, int totalPrice,
//                 int customerId, int locationId, int billingLocationId, int discountCodeId, List<OrderDetail> orderDetails,){
//        this.creationDate = creationDate;
//        this.totalPrice = totalPrice;
//        this.billingLocation.setId(billingLocationId);
//        this.customer.setId(customerId);
//        this.discountCode.setId(discountCodeId);
//        this.location.setId(locationId);
//
//    }
    public void setOrder(Order order){
        this.location = order.getLocation();
    }
}
