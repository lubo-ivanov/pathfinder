package softuni.pathfinder.model.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import softuni.pathfinder.model.entity.enums.Level;

import javax.persistence.*;
import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "users")
public class User{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true, nullable = false)
    private String username;
    //o Accepts values, which should be at least 2 characters

    @Column(nullable = false)
    private String password;
    //o Accepts values, which should be at least 2 characters

    @Column(unique = false, nullable = false)
    private String email;
    //o Accepts values, which contain the '@' symbol

    @ManyToMany
    private Set<Role> roles;
    //o Each registered user should have a "User" role

    @Enumerated(EnumType.STRING)
    private Level level;
}
