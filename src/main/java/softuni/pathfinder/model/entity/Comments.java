package softuni.pathfinder.model.entity;


import softuni.pathfinder.model.entity.enums.Route;

import javax.persistence.*;
import java.time.LocalDateTime;

public class Comments {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private boolean approved;

    @Column
    private LocalDateTime created;

    @Column(name = "text_content", columnDefinition = "TEXT")
    private String textContent;

    @ManyToOne
    private User author;

    @OneToOne
    private Route route;
}
