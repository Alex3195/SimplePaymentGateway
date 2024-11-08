package uz.alex.SimplePaymentGateway.service;

import org.springframework.security.core.userdetails.UserDetailsService;
import uz.alex.SimplePaymentGateway.dto.UserDto;

public interface UserService extends UserDetailsService {
    UserDto getUserByEmail(String email);
    UserDto getUserById(long id);
    UserDto getUserByEmailAndPassword(String email, String password);
    UserDto createUser(UserDto userDto);
    UserDto updateUser(UserDto userDto);
    void deleteUser(long id);
}
