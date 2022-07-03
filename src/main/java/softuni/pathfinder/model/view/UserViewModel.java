package softuni.pathfinder.model.view;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import softuni.pathfinder.model.enums.LevelEnum;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserViewModel {
    private Long id;
    private String username;
    private String fullName;
    private Integer age;
    private LevelEnum levelEnum;
}
