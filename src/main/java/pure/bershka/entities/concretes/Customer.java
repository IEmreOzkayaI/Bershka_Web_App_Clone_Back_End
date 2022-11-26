package pure.bershka.entities.concretes;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@EqualsAndHashCode(callSuper = true)
@AllArgsConstructor
@NoArgsConstructor
@Entity
@PrimaryKeyJoinColumn(name = "user_id", referencedColumnName = "id")
@Table(name = "customers")
public class Customer extends User {

    @Column(name = "identity_number")
    private String identityNumber;

    @Column(name = "phone_number")
    private String phoneNumber;
    
    @Column(name = "is_active")
    private boolean isActive;
    
    @ManyToOne
    @JoinColumn(name = "last_location_id")
    private Location lastLocation;

    @OneToMany(mappedBy = "user")
    private List<Order> order;

    @ManyToMany
    @JoinTable(name="user_locations", joinColumns = @JoinColumn(name = "user_id"),
                                    inverseJoinColumns = @JoinColumn(name="location_id"))
    private List<Location> locations;

    @ManyToMany
    @JoinTable(name="baskets", joinColumns = @JoinColumn(name = "user_id"),
                                    inverseJoinColumns = @JoinColumn(name = "product_id"))
    private List<Product> basket;


    @ManyToMany
    @JoinTable(name="favorites", joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "product_id"))
    private List<Product> favorites;
}
