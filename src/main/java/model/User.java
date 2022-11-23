package model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name="users")
@Getter
@Setter
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "identity_number")
    private String identityNumber;

    @Column(name = "phone_number")
    private String phoneNumber;

    @Column(name = "email")
    private String email;

    @Column(name = "password")
    private String password;

    @Column(name = "date_of_register")
    private Date addDate;

    @Column(name = "is_active")
    private boolean isActive;

    @OneToMany(mappedBy = "user")
    private List<Location> locationList;

    @OneToOne // many to many olduğunda değişmeli
    private Location lastLocation;

    public User() {
    }

    public User(String firstName, String lastName, String identityNumber,
                String phoneNumber, String email, String password, Date addDate,
                boolean isActive, List<Location> locationList, Location lastLocation) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.identityNumber = identityNumber;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.password = password;
        this.addDate = addDate;
        this.isActive = isActive;
        this.locationList = locationList;
        this.lastLocation = lastLocation;
    }
}
