package pure.bershka.entities.dtos;



import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CustomerDto {

    private String firstName;

    private String lastName;

    private String email;

    private String password;
    
    private String identityNumber;

    private String phoneNumber;
	
}
