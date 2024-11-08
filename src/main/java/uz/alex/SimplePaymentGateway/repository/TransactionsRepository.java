package uz.alex.SimplePaymentGateway.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import uz.alex.SimplePaymentGateway.entity.MerchantEntity;
import uz.alex.SimplePaymentGateway.entity.TransactionsEntity;

import java.util.List;

public interface TransactionsRepository extends JpaRepository<TransactionsEntity, Long> {
    List<TransactionsEntity> findByMerchant(MerchantEntity merchant);
}
