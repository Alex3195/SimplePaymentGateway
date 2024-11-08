package uz.alex.SimplePaymentGateway.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import uz.alex.SimplePaymentGateway.entity.MerchantEntity;

import java.util.Optional;

public interface MerchantRepository extends JpaRepository<MerchantEntity, Long> {
    Optional<MerchantEntity> findByApiKey(String apiKey);
}
