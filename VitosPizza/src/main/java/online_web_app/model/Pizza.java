package online_web_app.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(value = "Pizza")
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class Pizza {
    @Id
    private String id;
    private String pizzaName;
    private String pizzaDescription;
    private String pizzaImage;
    private float pizzaPrice;
    private Integer stockCount;

    // audit

}
