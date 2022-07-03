package softuni.pathfinder.model.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import softuni.pathfinder.model.enums.LevelEnum;

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

    @Column(name = "full_name", nullable = false)
    private String fullName;

    @Column
    private Integer age;

    @Column(unique = true, nullable = false)
    private String username;
    //o Accepts values, which should be at least 2 characters

    @Column(nullable = false)
    private String password;
    //o Accepts values, which should be at least 2 characters

    @Column(unique = true)
    private String email;
    //o Accepts values, which contain the '@' symbol

    @ManyToMany(fetch = FetchType.EAGER)
    private Set<Role> roles;

    @Enumerated(EnumType.STRING)
    @Column(name = "level")
    private LevelEnum levelEnum;

    @OneToMany(targetEntity = Message.class, mappedBy = "author", fetch = FetchType.EAGER)
    private Set<Message> sentMessages;

    @OneToMany(targetEntity = Message.class, mappedBy = "recipient", fetch = FetchType.EAGER)
    private Set<Message> receivedMessages;
}
