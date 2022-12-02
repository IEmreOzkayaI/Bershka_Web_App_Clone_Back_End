package pure.bershka.entities.concretes;

import java.util.List;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
@Table(name = "customers")
public class Customer extends User {
    @Id
    @Column(name = "customer_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "identity_number")
    private String identityNumber;

    @Column(name = "phone_number")
    private String phoneNumber;
    
    @Column(name = "is_active")
    private boolean isActive;
    
    @ManyToOne
    @JoinColumn(name = "last_location_id")
    private Location lastLocation;

    @JsonIgnore
    @OneToMany(mappedBy = "customer", fetch = FetchType.LAZY)
    private List<Order> order;

    @JsonIgnore
    @OneToMany(mappedBy = "customer", fetch = FetchType.LAZY)
    private List<Refund> refunds;

    @JsonIgnore
    @ManyToMany
    @JoinTable(name="customer_locations", joinColumns = @JoinColumn(name = "customer_id"),
                                    inverseJoinColumns = @JoinColumn(name="location_id"))
    private List<Location> locations;

    @JsonIgnore
    @ManyToMany
    @JoinTable(name="baskets", joinColumns = @JoinColumn(name = "customer_id"),
                                    inverseJoinColumns = @JoinColumn(name = "product_id"))
    private List<Product> basket;

    @JsonIgnore
    @ManyToMany
    @JoinTable(name="favorites", joinColumns = @JoinColumn(name = "customer_id"),
            inverseJoinColumns = @JoinColumn(name = "product_id"))
    private List<Product> favorites;
}
