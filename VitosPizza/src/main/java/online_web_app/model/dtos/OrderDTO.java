package online_web_app.model.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderDTO {

    private List<String> pizzaIds;
    private List<Integer> quantities;
    private String contactNumber;
    private String customerEmail;
    private String delivaryAddress;

}
