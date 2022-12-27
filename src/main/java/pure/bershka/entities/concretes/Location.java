package pure.bershka.entities.concretes;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

import java.util.List;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "locations")
public class Location {
    @Id
    @Column(name = "location_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "location_title")
    @NotBlank(message = "Title cannot be empty.")
    private String title;

    @Column(name = "address")
    @NotBlank(message = "Address cannot be empty.")
    private String address;

    @Column(name = "city")
    @NotBlank(message = "City cannot be empty.")
    private String city;

    @Column(name = "town")
    private String town;

    @Column(name = "post_code")
    @NotBlank(message = "Post code cannot be empty.")
    private String postCode;

    @JsonIgnore
    @OneToMany(mappedBy = "location", fetch = FetchType.LAZY)
    private List<Order> orders;

    @JsonBackReference
    @OneToMany(mappedBy = "lastLocation", fetch = FetchType.LAZY)
    private List<Customer> customersLastLocation;

    @JsonBackReference
    @ManyToMany(mappedBy = "locations", fetch = FetchType.LAZY)
    private List<Customer> customers;

    public Location(String title, String address, String city, String town, String postCode) {
        this.title = title;
        this.address = address;
        this.city = city;
        this.town = town;
        this.postCode = postCode;
    }

    public void setLocation(Location location){
        this.title = location.getTitle();
        this.city = location.getCity();
        this.address = location.getAddress();
        this.town = location.getTown();
        this.postCode = location.getPostCode();
    }

}
