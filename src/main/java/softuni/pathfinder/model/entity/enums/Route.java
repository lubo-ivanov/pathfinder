package softuni.pathfinder.model.entity.enums;

import softuni.pathfinder.model.entity.User;

import javax.persistence.*;

public class Route {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(columnDefinition = "TEXT")
    private String description;

    @Column(name = "gpx_coordinates", columnDefinition = "LONGTEXT")
    private String gpxCoordinates;

    @Enumerated(EnumType.STRING)
    private Level level;

    @Column
    private String name;

    @Column(name = "video_url")
    private String videoUrl;

    @ManyToOne
    private User author;
}
