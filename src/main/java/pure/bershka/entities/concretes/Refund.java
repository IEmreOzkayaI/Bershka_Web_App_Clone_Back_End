package pure.bershka.entities.concretes;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Entity
@Getter
@Setter
@Table(name="refunds")
public class Refund {
    @Id
    @Column(name = "refund_id")
    private int refundId;

    @Lob
    @Column(name = "cause")
    private String cause;

    @Column(name = "refund_date")
    private Date refundDate;

    @Column(name = "is_online")
    private boolean isOnline;

    @ManyToOne
    @Column(name = "order_id")
    private Order order;

    @ManyToOne
    @Column(name = "inventory_id")
    private Inventory inventory;

    @ManyToOne
    @Column(name = "user_id")
    private User user;

}
