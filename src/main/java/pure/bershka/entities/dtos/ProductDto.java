package pure.bershka.entities.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductDto {
    private int id;
    private String name;
    private BigDecimal price;
    private String gender;
    private String categoryName;
    private String typologyName;
    private String sizeName;
    private String colorName;
}
