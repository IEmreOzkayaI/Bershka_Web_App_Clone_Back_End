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
    private int locationId;

    @Column(name = "location_title")
    private String locationTitle;


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

    public Location() {
    }
}
