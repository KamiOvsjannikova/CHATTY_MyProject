package dto;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder

public class LoginResponseSuccess {
    private String accessToken;
    private String refreshToken;
    private String expiration;
}
