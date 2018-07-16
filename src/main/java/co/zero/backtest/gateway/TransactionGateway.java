package co.zero.backtest.gateway;

import co.zero.backtest.dto.TransactionDTO;
import co.zero.backtest.dto.TransactionListDTO;
import java.util.List;
import java.util.stream.Collectors;
import org.apache.commons.lang3.StringUtils;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class TransactionGateway {
    private RestTemplate restTemplate;
    private static final String OPEN_BANK_URL = "https://apisandbox.openbankproject.com/obp/v1.2.1/banks/rbs/accounts/savings-kids-john/public/transactions";

    public TransactionGateway(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public List<TransactionDTO> getAllTransactions() {
        ResponseEntity<TransactionListDTO> transactionResponse = restTemplate.exchange(OPEN_BANK_URL,
            HttpMethod.GET, null, new ParameterizedTypeReference<TransactionListDTO>() {});
        return transactionResponse.getBody().getTransactions();
    }

    public List<TransactionDTO> getAllTransactionsByType(String transactionType) {
        return getAllTransactions().stream()
            .filter(transaction -> StringUtils.equals(transaction.getDetails().getType(), transactionType))
            .collect(Collectors.toList());
    }

    public int countTransactionsByType(String transactionType) {
        return getAllTransactionsByType(transactionType).size();
    }
}
