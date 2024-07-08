package online_web_app.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(value = "Customers")
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class Customer {
    @Id
    private Integer id;
    private String firstName;
    private String lastName;
    private String email;
    private String mobileNo;
}
