package uz.alex.SimplePaymentGateway.dto;

import lombok.Data;

import java.math.BigDecimal;
@Data
public class TransactionRequest {
    private BigDecimal amount;
    private String currency;
}
