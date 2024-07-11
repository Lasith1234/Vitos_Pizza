package online_web_app.model.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CustomerDTO {
    private String firstName;
    private String lastName;
    private String email;
    private String mobileNo;
    private String password;
}
