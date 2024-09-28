package sp.ms.userservice.DTO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class UserDto {
    // private Long departmentId;
    private Long userId;
    private String firstName;
    private String lastName;
    private String email;

}
