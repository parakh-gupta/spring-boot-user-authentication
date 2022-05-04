package springboot.usermanagement.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;;
import springboot.usermanagement.modelDTO.JwtAuthDTO;
import springboot.usermanagement.modelDTO.LoginDTO;
import springboot.usermanagement.modelDTO.UserDTO;
import springboot.usermanagement.services.impl.AuthServiceImpl;

import javax.validation.Valid;

@RestController
@RequestMapping(path = "/auth")
public class AuthController {

   @Autowired
   AuthServiceImpl authService;

    @PostMapping(path = "/login")
    public JwtAuthDTO loginUser(@Valid @RequestBody LoginDTO loginDTO){
        return authService.login(loginDTO);
    }

    @PostMapping(path = "/register")
    public void createUser(@RequestBody UserDTO userDTO){
        authService.register(userDTO);
    }
}
