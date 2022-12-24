package pure.bershka.entities.concretes;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Date;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name="refunds")
public class Refund {
    @Id
    @Column(name = "refund_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Lob
    @Column(name = "cause")
    private String cause;

    @Column(name = "refund_date")
    private LocalDateTime refundDate;

    @Column(name = "is_online")
    private boolean isOnline;

    @ManyToOne
    @JoinColumn(name = "customer_id")
    private Customer customer;

    @OneToOne
    @JoinColumn(name = "order_detail_id")
    private OrderDetail orderDetail;

    public Refund(String cause, LocalDateTime refundDate, boolean isOnline, Customer customer, OrderDetail orderDetail) {
        this.cause = cause;
        this.refundDate = refundDate;
        this.isOnline = isOnline;
        this.customer = customer;
        this.orderDetail = orderDetail;
    }
}
