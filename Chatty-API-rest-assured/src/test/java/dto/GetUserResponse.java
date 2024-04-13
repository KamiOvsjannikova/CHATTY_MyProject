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




//    "id": "string",
//            "name": "string",
//            "surname": "string",
//            "phone": "string",
//            "email": "string",
//            "role": "USER",
//            "gender": "MALE",
//            "birthDate": "2024-04-11T10:22:17.505Z",
//            "avatarUrl": "string",
//            "backgroundUrl": "string"
}
