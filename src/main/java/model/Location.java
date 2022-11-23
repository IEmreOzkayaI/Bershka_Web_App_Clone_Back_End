package model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Getter
@Setter
@Table(name = "location")
public class Location {
    @Id
    private int locationId;

    private String address;
    private String city;
    private String town;
    private String mailBox;
    @ManyToOne
    private User user;

    public Location(String address, String city, String town, String mailBox, User user) {
        this.address = address;
        this.city = city;
        this.town = town;
        this.mailBox = mailBox;
        this.user = user;
    }

    public Location() {
    }
}
