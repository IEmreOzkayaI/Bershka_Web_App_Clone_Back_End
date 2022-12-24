package pure.bershka.entities.concretes;

import java.util.List;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
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
    @NotNull
    private int id;

    @Column(name = "budget")
    private int budget;


    @Column(name = "identity_number")
    @NotBlank
    private String identityNumber;

    @Column(name = "phone_number")
    @NotNull
    private String phoneNumber;
    
    @Column(name = "is_active")
    private boolean isActive;
    
    @ManyToOne
    @JoinColumn(name = "last_location_id")
    @NotNull
    @JsonBackReference
    private Location lastLocation;

    @JsonIgnore
    @OneToMany(mappedBy = "customer", fetch = FetchType.LAZY)
    private List<Order> order;


    @OneToMany(mappedBy = "customer", fetch = FetchType.LAZY)
    private List<Refund> refunds;

    @JsonManagedReference
    @ManyToMany
    @JoinTable(name="customer_locations", joinColumns = @JoinColumn(name = "customer_id"),
                                    inverseJoinColumns = @JoinColumn(name="location_id"))
    private List<Location> locations;

    @JsonManagedReference
    @ManyToMany
    @JoinTable(name="baskets", joinColumns = @JoinColumn(name = "customer_id"),
                                    inverseJoinColumns = @JoinColumn(name = "product_id"))
    private List<Product> basket;

    @JsonManagedReference
    @ManyToMany
    @JoinTable(name="favorites", joinColumns = @JoinColumn(name = "customer_id"),
            inverseJoinColumns = @JoinColumn(name = "product_id"))
    private List<Product> favorites;

    public void setCustomer(Customer customer){
        this.phoneNumber = customer.getPhoneNumber();
        this.setFirstName(customer.getFirstName());
        this.phoneNumber = customer.getPhoneNumber();
        this.setEmail(customer.getEmail());
        this.setPassword(customer.getPassword());
    }
}
