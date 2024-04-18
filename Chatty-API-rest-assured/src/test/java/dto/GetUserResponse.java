package dto;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class GetUserResponse {
    private String id;
    private String name;
    private String surname;
    private String email;
    private String avatarUrl;
    private String phone;
    private String gender;
    private String birthDate;
    private String role;
    private String backgroundUrl;
}
