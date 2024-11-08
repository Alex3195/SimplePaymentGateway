package uz.alex.SimplePaymentGateway.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;
import uz.alex.SimplePaymentGateway.dto.Transactions;

import java.util.List;

@Entity
@Table(name = "merchant")
@Getter
@Setter
public class MerchantEntity extends BaseEntity {
    @Column(name = "name", nullable = false, unique = true)
    private String name;

    @Column(name = "api_key", nullable = false, unique = true)
    private String apiKey;

    @OneToMany(mappedBy = "merchant")
    private List<TransactionsEntity> transactions;
}

