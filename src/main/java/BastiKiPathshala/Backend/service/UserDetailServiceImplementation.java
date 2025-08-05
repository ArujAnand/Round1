package BastiKiPathshala.Backend.service;

import BastiKiPathshala.Backend.entities.UserEntity;
import BastiKiPathshala.Backend.repository.UserRepository;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

@Component
public class UserDetailServiceImplementation implements UserDetailsService {
    private final UserRepository userRepository;

    public UserDetailServiceImplementation(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    //used for getting details from the DB
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserEntity user = userRepository.findByUsername(username);

        if (user != null) {
            UserDetails userDetails = User.builder()
                    .username(user.getUsername())
                    .password(user.getPassword())
                    .roles(user.getRoles().toArray(new String[0]))
                    .build();

            return userDetails;
        }
        throw new UsernameNotFoundException("User not found with username: " + username);
    }
}
