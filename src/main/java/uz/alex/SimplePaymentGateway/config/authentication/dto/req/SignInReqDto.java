package uz.alex.SimplePaymentGateway.config.authentication.dto.req;

import lombok.Getter;
import lombok.Setter;
import org.springframework.validation.annotation.Validated;

@Getter
@Setter
@Validated
public class SignInReqDto {
    private String username;
    private String password;
}

