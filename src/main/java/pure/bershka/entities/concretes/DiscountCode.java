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
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "discount_code")
    private String code;

    @Column(name = "discount_code_amount")
    private int amount;

    @Column(name = "discount_price")
    private int price;

    @OneToMany(mappedBy = "discountCode")
    private List<Order> orders;
}
