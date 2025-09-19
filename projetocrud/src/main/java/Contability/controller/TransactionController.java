package Contability.controller;

import java.time.OffsetDateTime;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import Contability.TransactionService;
import Contability.dto.TransactionRequest;
import Contability.model.Transaction;


@RestController
@RequestMapping("/transacao")
public class TransactionController{

    private final TransactionService transactionService;

    public TransactionController(TransactionService transactionService, TransactionService transactionService1){

        this.transactionService = transactionService;
    }
    @PostMapping
    public ResponseEntity<Void> createTransaction(@Validated @RequestBody TransactionRequest request){
        if(request.getDataHora().isAfter(OffsetDateTime.now()) || request.getValor() <= 0){
            return ResponseEntity.unprocessableEntity().build();
        }
        transactionService.addTransaction(new Transaction(request.getValor(), request.getDataHora()));
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @DeleteMapping
    public ResponseEntity<Void> clearTransaction(){
         transactionService.clearTransactions();
         return ResponseEntity.ok().build();
    }

}
