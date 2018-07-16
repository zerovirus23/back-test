package co.zero.backtest.service;

import co.zero.backtest.model.Transaction;
import java.util.List;

public interface TransactionService {

    List<Transaction> getAllTransactions();

    List<Transaction> getAllTransactionsByType(String transactionType);

    int countTransactionsByType(String transactionType);
}
