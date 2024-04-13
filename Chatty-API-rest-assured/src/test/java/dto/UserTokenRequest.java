package dto;
import lombok.*;

@Getter@Setter@AllArgsConstructor@NoArgsConstructor@Builder
public class UserTokenRequest {
    private String email;
    private String password;
}
