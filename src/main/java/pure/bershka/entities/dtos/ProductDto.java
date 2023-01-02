package pure.bershka.entities.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductDto {
	private String img_1;
	private String img_2;
	private String img_3;
    private String name;
    private int price;
    private int colorId;
    private String gender;
    private int categoryId;
    private int typologyId;

    private int[] sizeId;
    private BigDecimal discountPercentage;
}
