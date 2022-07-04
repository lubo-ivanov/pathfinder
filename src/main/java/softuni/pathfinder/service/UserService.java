package softuni.pathfinder.service;

import softuni.pathfinder.model.service.UserServiceModel;

public interface UserService {
    void registerUser(UserServiceModel userServiceModel);

    UserServiceModel findUserByUsernameAndPassword(String username, String password);

    UserServiceModel findById(Long id);

    boolean nameExists(String username);
}
