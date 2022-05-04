package springboot.usermanagement.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.stereotype.Service;
import springboot.usermanagement.model.User;
import springboot.usermanagement.modelDTO.JwtAuthDTO;
import springboot.usermanagement.modelDTO.LoginDTO;
import springboot.usermanagement.modelDTO.UserDTO;
import springboot.usermanagement.modelDTO.UserMapper;
import springboot.usermanagement.repository.UserRepository;
import springboot.usermanagement.security.JwtTokenProvider;
import springboot.usermanagement.services.AuthService;


@Service
public class AuthServiceImpl implements AuthService {

    @Autowired
    JwtTokenProvider tokenProvider;

    @Autowired
    AuthenticationManager authenticationManager;

    @Autowired
    UserRepository userRepository;

    @Autowired
    private UserMapper userMapper;

    @Override
    public JwtAuthDTO login(LoginDTO loginDTO) {
        try{
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
                    loginDTO.getUsername(),
                    loginDTO.getPassword())
            );
        }
        catch(Exception e){
            System.out.println("Error in Authentication");
        }
        String jwt = tokenProvider.generateToken(loginDTO.getUsername());
        return new JwtAuthDTO(jwt);
    }

    @Override
    public void register(UserDTO userDTO) {
        userRepository.save(userMapper.userDTOtoUser(userDTO));
    }
}
