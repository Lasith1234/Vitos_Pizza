package online_web_app.model.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PizzaDTO {
    private String pizzaName;
    private String pizzaDescription;
    private String pizzaImage;
    private float pizzaPrice;
    private Integer stockCount;

}
