package softuni.pathfinder.service.impl;

import org.springframework.stereotype.Service;
import softuni.pathfinder.model.dto.UserRegistrationDto;
import softuni.pathfinder.model.entity.User;
import softuni.pathfinder.model.enums.LevelEnum;
import softuni.pathfinder.repository.UserRepository;
import softuni.pathfinder.service.UserService;

@Service
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public void registerUser(UserRegistrationDto userRegistrationDto) {
        User user = User.builder()
                .username(userRegistrationDto.getUsername())
                .fullName(userRegistrationDto.getFullName())
                .email(userRegistrationDto.getEmail())
                .age(userRegistrationDto.getAge())
                .password(userRegistrationDto.getPassword())
                .levelEnum(LevelEnum.BEGINNER)
                .build();
                userRepository.save(user);
    }
}
