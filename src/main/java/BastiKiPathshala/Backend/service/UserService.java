package BastiKiPathshala.Backend.service;

import BastiKiPathshala.Backend.dto.UserDTO;
import BastiKiPathshala.Backend.entities.UserEntity;
import BastiKiPathshala.Backend.repository.UserRepository;
import org.modelmapper.ModelMapper;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserService {
    private final UserRepository userRepository;
    private final ModelMapper mapper;
    private final PasswordEncoder passwordEncoder;

    public UserService(UserRepository userRepository, ModelMapper mapper, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.mapper = mapper;
        this.passwordEncoder = passwordEncoder;
    }

    public boolean saveNewUser(UserEntity newUser) {
        UserEntity userToSave = mapper.map(newUser, UserEntity.class);
        userToSave.setPassword(passwordEncoder.encode(userToSave.getPassword()));
        try {
            userRepository.save(userToSave);
        } catch (Exception exception) {
            System.out.println(exception.getMessage());
            throw new RuntimeException("An erro occured while saving the user: " + newUser.getName());
        }
        return true;
    }

    public List<UserDTO> getAllUsers() {
        List<UserEntity> users = userRepository.findAll();
        return users.stream()
                .map(UserEntity -> mapper.map(UserEntity, UserDTO.class))
                .collect(Collectors.toList());
    }
}
