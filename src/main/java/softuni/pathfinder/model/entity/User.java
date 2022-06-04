package softuni.pathfinder.model.entity;

import softuni.pathfinder.model.entity.enums.Level;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "users")
public class User extends BaseEntity {
    private String username;
    //o Accepts values, which should be at least 2 characters
    private String password;
    //o Accepts values, which should be at least 2 characters
    private String email;
    //o Accepts values, which contain the '@' symbol
    private Set<Role> roles;
    //o Each registered user should have a "User" role
    private Level level;

    public User() {
    }

    @Column(unique = true, nullable = false)
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Column(nullable = false)
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Column(unique = false, nullable = false)
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @ManyToMany
    public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }

    @Enumerated(EnumType.STRING)
    public Level getLevel() {
        return level;
    }

    public void setLevel(Level level) {
        this.level = level;
    }
}
