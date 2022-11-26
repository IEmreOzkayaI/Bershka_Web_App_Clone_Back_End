package pure.bershka.entities.concretes;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@Setter
@Table(name = "locations")
public class Location {
    @Id
    @Column(name = "location_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "location_title")
    private String title;

    @Column(name = "address")
    private String address;

    @Column(name = "city")
    private String city;

    @Column(name = "town")
    private String town;

    @Column(name = "post_code")
    private String postCode;

    @Column(name = "another_adress_info")
    private String anotherAddressInfo;

    @OneToMany(mappedBy = "location")
    private List<Order> orders;

    @OneToMany(mappedBy = "lastLocation")
    private List<Customer> customersLastLocation;

    @ManyToMany(mappedBy = "locations")
    private List<Customer> customers;

    public Location() {
    }
}
