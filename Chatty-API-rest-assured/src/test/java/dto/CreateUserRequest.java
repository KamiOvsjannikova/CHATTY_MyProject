package dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
@JsonInclude(JsonInclude.Include.NON_NULL)
@Data@AllArgsConstructor@NoArgsConstructor@Builder
public class CreateUserRequest {
    private String email;
    private String password;
    private String confirmPassword;
    private String role;
}
