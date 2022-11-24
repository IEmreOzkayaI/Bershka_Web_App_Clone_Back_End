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

    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product product;

    @Column(name = "refund_date")
    private Date refundDate;

    @Lob
    @Column(name = "cause")
    private String cause;

}
