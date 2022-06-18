package softuni.pathfinder.model.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserRegistrationDto {

    @Length(min = 2)
    private String username;

    @NotNull
    private String fullName;

    @NotNull
    @Email
    private String email;

    private Integer age;

    @Length(min = 2)
    private String password;

    @Length(min = 2)
    private String confirmPassword;
}
