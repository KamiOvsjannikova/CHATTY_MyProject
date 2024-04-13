package dto;

import lombok.*;

import java.util.ArrayList;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class LoginResponseError {
    private String httpStatus;
    private String message;
    private ArrayList<String> email;

}
