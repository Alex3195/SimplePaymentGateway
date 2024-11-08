package uz.alex.SimplePaymentGateway.service.impl;

import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import uz.alex.SimplePaymentGateway.dto.UserDto;
import uz.alex.SimplePaymentGateway.entity.UserEntity;
import uz.alex.SimplePaymentGateway.repository.UserRepository;
import uz.alex.SimplePaymentGateway.service.UserService;

import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<UserEntity> userEntity = userRepository.findByUsername(username);
        return userEntity.map(this::entityToDto).orElseThrow(() -> new UsernameNotFoundException(username));
    }

    @Override
    public UserDto getUserByEmail(String email) {
        Optional<UserEntity> userEntity = userRepository.findByEmail(email);
        return userEntity.map(this::entityToDto).orElseThrow(() -> new UsernameNotFoundException(email));
    }

    @Override
    public UserDto getUserById(long id) {
        Optional<UserEntity> e = userRepository.findById(id);
        return e.map(this::entityToDto).orElseThrow(() -> new NullPointerException(String.format("User with this id: %d is not found", id)));
    }

    @Override
    public UserDto getUserByEmailAndPassword(String email, String password) {
        Optional<UserEntity> e = userRepository.findByEmailAndPassword(email, password);
        return e.map(this::entityToDto).orElseThrow(() -> new UsernameNotFoundException(email));
    }

    @Override
    public UserDto createUser(UserDto userDto) {
        UserEntity e = dtoToEntity(userDto);
        return entityToDto(userRepository.save(e));
    }

    @Override
    public UserDto updateUser(UserDto userDto) {
        UserEntity e = dtoToEntity(userDto);
        return entityToDto(userRepository.save(e));
    }

    @Override
    public void deleteUser(long id) {
        userRepository.deleteById(id);
    }

    private UserDto entityToDto(UserEntity e) {
        UserDto userDto = new UserDto();
        userDto.setId(e.getId());
        userDto.setUsername(e.getUsername());
        userDto.setPassword(e.getPassword());
        userDto.setEmail(e.getEmail());
        userDto.setFirstName(e.getFirstName());
        userDto.setLastName(e.getLastName());
        return userDto;
    }
    private UserEntity dtoToEntity(UserDto userDto) {
        UserEntity userEntity = new UserEntity();
        userEntity.setId(userDto.getId());
        userEntity.setUsername(userDto.getUsername());
        userEntity.setPassword(userDto.getPassword());
        userEntity.setEmail(userDto.getEmail());
        userEntity.setFirstName(userDto.getFirstName());
        userEntity.setLastName(userDto.getLastName());
        return userEntity;
    }
}
