package Contability;

import org.springframework.stereotype.Service;

import Contability.model.Transaction;

import java.time.OffsetDateTime;
import java.util.DoubleSummaryStatistics;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

@Service
public class TransactionService {

    private static final Queue<Transaction> transactions = new ConcurrentLinkedQueue<>();
    //biblioteca de lista, ja que não pode usar o database

    public void  addTransaction(Transaction transaction){
        transactions.add(transaction);

    }
    public void clearTransactions(){
        transactions.clear();
    }
 //metodo que retorna as estatiscas de transações nos ultimos  24 horas
    public static DoubleSummaryStatistics getStatistics(){
        OffsetDateTime now = OffsetDateTime.now();
        return transactions.stream()
                .filter(t -> t.getDataHora().isAfter(now.minusHours(24))).
                mapToDouble(Transaction:: getValor).summaryStatistics();
    }
}
