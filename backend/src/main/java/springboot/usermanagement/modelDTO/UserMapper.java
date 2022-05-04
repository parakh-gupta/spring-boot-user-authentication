package springboot.usermanagement.modelDTO;

import org.mapstruct.Mapper;
import springboot.usermanagement.model.User;

@Mapper(componentModel = "spring")
public interface UserMapper {

    User userDTOtoUser (UserDTO userDTO);
    UserDTO userToUserDTO (User user);

}
