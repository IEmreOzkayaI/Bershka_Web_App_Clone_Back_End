package pure.bershka.entities.concretes;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@Setter
@Table(name = "discount_codes")
public class DiscountCode {
    @Id
    @Column(name = "discount_code_id")
    private int discountCodeId;

    @Column(name = "discount_code")
    private String discountCode;

    @Column(name = "discount_code_amount")
    private int discountCodeAmount;

    @Column(name = "discount_price")
    private int discountPrice;

    @OneToMany(mappedBy = "discountCode")
    private List<Order> orders;



}
