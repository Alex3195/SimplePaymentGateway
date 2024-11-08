package uz.alex.SimplePaymentGateway.dto;

import lombok.Data;

@Data
public class Merchant {
    private Long id;
    private String name;
    private String apiKey;
}
