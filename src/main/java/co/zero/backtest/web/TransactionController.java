package co.zero.backtest.web;

import co.zero.backtest.model.Transaction;
import java.util.List;

public interface TransactionController {

    List<Transaction> getAllTransactions();

    List<Transaction> getAllTransactionsByType(String transactionType);

    int countTransactionsByType(String transactionType);
}