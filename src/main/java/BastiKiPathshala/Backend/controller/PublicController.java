package BastiKiPathshala.Backend.controller;

import BastiKiPathshala.Backend.entities.UserEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/register")
public class PublicController {

    @PostMapping
    public void createUser(@RequestBody UserEntity newUser) {
        userService.saveNewUser(newUser);
    }
}
