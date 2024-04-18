package dto;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
@JsonInclude(JsonInclude.Include.NON_NULL)
@Data@AllArgsConstructor@NoArgsConstructor@Builder
public class PutUpdateRequest {

  private String id;
  private String name;
  private String surname;
  private String phone;
  private String email;
  private String gender;
  private String role;
  private String birthDate;
  private String avatarUrl;
  private String backgroundUrl;
}



