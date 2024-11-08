package uz.alex.SimplePaymentGateway.service;

import uz.alex.SimplePaymentGateway.dto.Transactions;

import java.math.BigDecimal;

public interface TransactionsService {
    Transactions processTransaction(String apiKey, BigDecimal amount, String currency);
}
