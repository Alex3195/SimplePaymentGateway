package uz.alex.SimplePaymentGateway.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import uz.alex.SimplePaymentGateway.dto.TransactionRequest;
import uz.alex.SimplePaymentGateway.dto.Transactions;
import uz.alex.SimplePaymentGateway.service.TransactionsService;

@RestController
@RequestMapping("/api/transactions")
public class TransactionController {
    private final TransactionsService transactionService;

    public TransactionController(TransactionsService transactionService) {
        this.transactionService = transactionService;
    }

    @PostMapping
    public ResponseEntity<Transactions> processTransaction(
            @RequestHeader("API-Key") String apiKey,
            @RequestBody TransactionRequest request) {

        Transactions transaction = transactionService.processTransaction(apiKey, request.getAmount(), request.getCurrency());
        return new ResponseEntity<>(transaction, HttpStatus.CREATED);
    }
}
