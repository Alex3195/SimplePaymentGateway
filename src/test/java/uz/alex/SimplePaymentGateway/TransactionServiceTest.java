package uz.alex.SimplePaymentGateway;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import uz.alex.SimplePaymentGateway.dto.Transactions;
import uz.alex.SimplePaymentGateway.entity.MerchantEntity;
import uz.alex.SimplePaymentGateway.repository.MerchantRepository;
import uz.alex.SimplePaymentGateway.service.TransactionsService;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class TransactionServiceTest {
    @Autowired
    private TransactionsService transactionService;

    @Autowired
    private MerchantRepository merchantRepository;

    @BeforeEach
    public void setup() {
        MerchantEntity merchant = new MerchantEntity();
        merchant.setName("Test Merchant");
        merchant.setApiKey("test-key");
        merchantRepository.save(merchant);
    }

    @Test
    public void testProcessTransaction() {
        Transactions transaction = transactionService.processTransaction("test-key", new BigDecimal("100.00"), "USD");
        assertEquals("SUCCESS", transaction.getStatus());
    }
}
