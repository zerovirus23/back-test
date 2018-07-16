package co.zero.backtest.service.impl;

import co.zero.backtest.dto.TransactionDTO;
import co.zero.backtest.gateway.TransactionGateway;
import co.zero.backtest.model.Transaction;
import co.zero.backtest.service.TransactionService;
import java.util.List;
import java.util.stream.Collectors;
import ma.glasnost.orika.MapperFacade;
import org.springframework.stereotype.Service;

@Service
public class DefaultTransactionService implements TransactionService {
    private TransactionGateway transactionGateway;
    private MapperFacade transactionMapper;

    public DefaultTransactionService(TransactionGateway transactionGateway, MapperFacade transactionMapper) {
        this.transactionGateway = transactionGateway;
        this.transactionMapper = transactionMapper;
    }

    @Override
    public List<Transaction> getAllTransactions() {
        List<TransactionDTO> transactionDTOList = transactionGateway.getAllTransactions();
        return transformDtoToEntity(transactionDTOList);
    }

    @Override
    public List<Transaction> getAllTransactionsByType(String transactionType) {
        List<TransactionDTO> transactionDTOList = transactionGateway.getAllTransactionsByType(transactionType);
        return transformDtoToEntity(transactionDTOList);
    }

    @Override
    public int countTransactionsByType(String transactionType) {
        return transactionGateway.countTransactionsByType(transactionType);
    }

    private List<Transaction> transformDtoToEntity(List<TransactionDTO> transactionDtoList) {
        return transactionDtoList.stream()
            .map(transactionDTO -> transactionMapper.map(transactionDTO, Transaction.class))
            .collect(Collectors.toList());
    }
}
