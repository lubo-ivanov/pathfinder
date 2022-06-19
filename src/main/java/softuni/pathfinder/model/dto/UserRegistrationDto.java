package softuni.pathfinder.model.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserRegistrationDto {

    @Length(min = 5, max = 20)
    private String username;

    @Length(min = 5, max = 20)
    private String fullName;

    @NotNull
    @Email
    private String email;

    @Min(0)
    @Max(90)
    private Integer age;

    @Length(min = 5, max = 20)
    private String password;

    @Length(min = 5, max = 20)
    private String confirmPassword;
}
