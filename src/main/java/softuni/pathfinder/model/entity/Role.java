package softuni.pathfinder.model.entity;

import softuni.pathfinder.model.entity.enums.UserRoles;

import javax.persistence.*;

@Entity
@Table(name = "roles")
public class Role extends BaseEntity{
    private UserRoles name;

    public Role() {
    }

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    public UserRoles getName() {
        return name;
    }

    public void setName(UserRoles name) {
        this.name = name;
    }
}
