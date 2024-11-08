package uz.alex.SimplePaymentGateway.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Entity
@Table(name = "transactions")
@Setter
@Getter
public class TransactionsEntity extends BaseEntity {

    @ManyToOne
    private MerchantEntity merchant;

    private BigDecimal amount;
    private String currency;
    private String status;//SUCCESS,FAILED




}
