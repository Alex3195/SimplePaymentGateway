package uz.alex.SimplePaymentGateway.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import uz.alex.SimplePaymentGateway.entity.UserEntity;

import java.util.Optional;

public interface UserRepository extends JpaRepository<UserEntity, Long> {
    Optional<UserEntity> findByUsername(String username);
    Optional<UserEntity> findByEmail(String email);
    Optional<UserEntity> findByUsernameAndPassword(String username, String password);
    Optional<UserEntity> findByEmailAndPassword(String email, String password);
}
