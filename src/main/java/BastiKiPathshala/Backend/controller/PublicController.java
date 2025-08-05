package BastiKiPathshala.Backend.controller;

import BastiKiPathshala.Backend.dto.UserDTO;
import BastiKiPathshala.Backend.entities.UserEntity;
import BastiKiPathshala.Backend.service.UserService;
import jakarta.validation.Valid;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/register")
public class PublicController {

    private final UserService userService;
    private final ModelMapper mapper;

    public PublicController(UserService userService, ModelMapper mapper) {
        this.userService = userService;
        this.mapper = mapper;
    }

    @PostMapping
    public ResponseEntity<?> createUser(@RequestBody @Valid UserDTO newUser) {
        UserEntity user = mapper.map(newUser, UserEntity.class);
        if(userService.saveNewUser(user)) {
            return new ResponseEntity<>(HttpStatus.CREATED);
        }
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

    @GetMapping("/health-check")
    public String healthCheck() {
        return "OK";
    }
}
