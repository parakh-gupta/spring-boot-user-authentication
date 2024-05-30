package springboot.usermanagement.services;

import springboot.usermanagement.modelDTO.JwtAuthDTO;
import springboot.usermanagement.modelDTO.LoginDTO;
import springboot.usermanagement.modelDTO.UserDTO;

public interface AuthService {
    JwtAuthDTO login(LoginDTO loginDto);
    void register(UserDTO userDTO);
}
