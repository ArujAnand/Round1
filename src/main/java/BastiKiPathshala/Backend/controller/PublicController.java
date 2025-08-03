package BastiKiPathshala.Backend.controller;

import BastiKiPathshala.Backend.entities.UserEntity;
import BastiKiPathshala.Backend.service.UserService;
import org.springframework.security.core.userdetails.User;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/register")
public class PublicController {

    private final UserService userService;

    public PublicController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping
    public void createUser(@RequestBody UserEntity newUser) {
        userService.saveNewUser(newUser);
    }
}
