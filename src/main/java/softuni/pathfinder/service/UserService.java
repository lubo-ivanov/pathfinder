package softuni.pathfinder.service;

import softuni.pathfinder.model.dto.UserRegistrationDto;
import softuni.pathfinder.model.entity.User;

public interface UserService {
    void registerUser(UserRegistrationDto userRegistrationDto);

    User findUserByUsername(String username);
}
