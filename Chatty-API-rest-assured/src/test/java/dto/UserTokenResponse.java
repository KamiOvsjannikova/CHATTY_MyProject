package dto;

import lombok.*;

@Getter@Setter@AllArgsConstructor@NoArgsConstructor@Builder
public class UserTokenResponse {
    private String accessToken;
    private String refreshToken;
    private String expiration;
}
