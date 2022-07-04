package softuni.pathfinder.model.service;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import softuni.pathfinder.model.entity.Category;
import softuni.pathfinder.model.entity.Picture;
import softuni.pathfinder.model.entity.User;
import softuni.pathfinder.model.enums.LevelEnum;

import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class RouteServiceModel {
    private Long id;
    private String description;
    private String gpxCoordinates;
    private LevelEnum levelEnum;
    private String name;
    private String videoUrl;
    private User author;
    private Set<Category> categories;
    public Set<Picture> pictures;
}
