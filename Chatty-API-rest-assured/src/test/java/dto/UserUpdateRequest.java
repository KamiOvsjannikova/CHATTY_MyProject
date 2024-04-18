package dto;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
@JsonInclude(JsonInclude.Include.NON_NULL)
@Data@AllArgsConstructor@NoArgsConstructor@Builder

public class UserUpdateRequest {
    private String avatarUrl;
    private String name;
    private String surname;
    private String birthDate;
    private String phone;
    private String gender;
    private String backgroundUrl;
    private String blocked;

}






