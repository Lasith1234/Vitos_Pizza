package online_web_app.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;
import java.util.List;

@Document(value = "Order")
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class Order {
    @Id
    private String id;
    private List<String> pizzaIds;
    private List<Integer> quantities;
    private String contactNumber;
    private String customerEmail;
    private String delivaryAddress;

    private String customerId;
    private LocalDateTime orderPlacedAt;
    private float totalPrice;
}
