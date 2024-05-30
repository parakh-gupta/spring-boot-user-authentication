package springboot.usermanagement.services;

import springboot.usermanagement.model.User;

import java.util.List;

public interface UserService {

    User getUser(Long id);
    List<User> getAllUsers();
    User createUser(User user);
    void deleteUser(Long id);
    User updateUserData(User user);
}
