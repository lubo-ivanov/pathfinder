package softuni.pathfinder.model.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.web.context.annotation.SessionScope;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@SessionScope
public class CurrentUser {
    private Long id;
    private String username;
}