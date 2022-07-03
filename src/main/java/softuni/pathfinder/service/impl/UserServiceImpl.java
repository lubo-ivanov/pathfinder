package softuni.pathfinder.service.impl;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import softuni.pathfinder.model.entity.User;
import softuni.pathfinder.model.enums.LevelEnum;
import softuni.pathfinder.model.service.UserServiceModel;
import softuni.pathfinder.repository.UserRepository;
import softuni.pathfinder.service.UserService;

import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final ModelMapper modelMapper;

    public UserServiceImpl(UserRepository userRepository, ModelMapper modelMapper) {
        this.userRepository = userRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public void registerUser(UserServiceModel userServiceModel) {
        User user = modelMapper.map(userServiceModel, User.class);
        user.setLevelEnum(LevelEnum.BEGINNER);
        userRepository.save(user);
    }

    @Override
    public UserServiceModel findUserByUsernameAndPassword(String username, String password) {
        Optional<User> user = userRepository.findByUsernameAndPassword(username, password);
        return user.map(value -> modelMapper.map(value, UserServiceModel.class)).orElse(null);
    }

    @Override
    public UserServiceModel findById(Long id) {
        return userRepository.findById(id)
                .map(user -> modelMapper.map(user, UserServiceModel.class))
                .orElse(null);
    }

}
