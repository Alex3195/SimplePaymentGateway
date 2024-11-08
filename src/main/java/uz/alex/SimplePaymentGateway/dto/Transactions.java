package uz.alex.SimplePaymentGateway.dto;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class Transactions {
    private BigDecimal amount;
    private String currency;
    private String status;
    private Merchant merchant;
}
