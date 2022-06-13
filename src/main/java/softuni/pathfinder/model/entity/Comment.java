package softuni.pathfinder.model.entity;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "comments")
public class Comment {
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
