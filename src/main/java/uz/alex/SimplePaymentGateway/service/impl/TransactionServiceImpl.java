package uz.alex.SimplePaymentGateway.service.impl;

import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;
import uz.alex.SimplePaymentGateway.dto.Merchant;
import uz.alex.SimplePaymentGateway.dto.Transactions;
import uz.alex.SimplePaymentGateway.entity.MerchantEntity;
import uz.alex.SimplePaymentGateway.entity.TransactionsEntity;
import uz.alex.SimplePaymentGateway.repository.MerchantRepository;
import uz.alex.SimplePaymentGateway.repository.TransactionsRepository;
import uz.alex.SimplePaymentGateway.service.TransactionsService;

import java.math.BigDecimal;

@Service
public class TransactionServiceImpl implements TransactionsService {
    private final TransactionsRepository transactionsRepository;
    private final MerchantRepository merchantRepository;

    public TransactionServiceImpl(TransactionsRepository transactionsRepository, MerchantRepository merchantRepository) {
        this.transactionsRepository = transactionsRepository;
        this.merchantRepository = merchantRepository;
    }

    @Override
    @Transactional
    public Transactions processTransaction(String apiKey, BigDecimal amount, String currency) {
        MerchantEntity merchant = merchantRepository.findByApiKey(apiKey)
                .orElseThrow(() -> new IllegalArgumentException("Invalid API Key"));

        TransactionsEntity transactionsEntity = new TransactionsEntity();
        transactionsEntity.setMerchant(merchant);
        transactionsEntity.setAmount(amount);
        transactionsEntity.setCurrency(currency);
        transactionsEntity.setStatus("SUCCESS");  // Basic success status, add fraud checks as needed
        transactionsRepository.save(transactionsEntity);
        return entityToDTO(transactionsEntity);
    }

    private Transactions entityToDTO(TransactionsEntity transactionsEntity) {
        Transactions transactions = new Transactions();
        transactions.setMerchant(entityToMerchant(transactionsEntity.getMerchant()));
        transactions.setAmount(transactionsEntity.getAmount());
        transactions.setCurrency(transactionsEntity.getCurrency());
        transactions.setStatus("SUCCESS");
        return transactions;
    }

    private Merchant entityToMerchant(MerchantEntity merchantEntity) {
        Merchant merchant = new Merchant();
        merchant.setId(merchantEntity.getId());
        merchant.setName(merchantEntity.getName());
        merchant.setApiKey(merchantEntity.getApiKey());
        return merchant;
    }
}
