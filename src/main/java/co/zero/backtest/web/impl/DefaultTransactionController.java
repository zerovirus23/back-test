package co.zero.backtest.web.impl;

import co.zero.backtest.model.Transaction;
import co.zero.backtest.service.TransactionService;
import co.zero.backtest.web.TransactionController;
import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/transactions")
public class DefaultTransactionController implements TransactionController {
    private TransactionService transactionService;

    public DefaultTransactionController(TransactionService transactionService) {
        this.transactionService = transactionService;
    }

    @Override
    @GetMapping
    public List<Transaction> getAllTransactions() {
        return transactionService.getAllTransactions();
    }

    @Override
    @GetMapping("/{transactionType}")
    public List<Transaction> getAllTransactionsByType(@PathVariable String transactionType) {
        return transactionService.getAllTransactionsByType(transactionType);
    }

    @Override
    @GetMapping("/{transactionType}/count")
    public int countTransactionsByType(@PathVariable String transactionType) {
        return transactionService.countTransactionsByType(transactionType);
    }
}
