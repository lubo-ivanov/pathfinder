package softuni.pathfinder.model.service;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import softuni.pathfinder.model.entity.Role;
import softuni.pathfinder.model.enums.LevelEnum;
import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserServiceModel {
    private Long id;
    private String fullName;
    private String username;
    private String password;
    private String email;
    private Integer age;
    private LevelEnum levelEnum;
    private Set<Role> roles;
}
