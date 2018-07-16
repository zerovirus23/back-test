
package co.zero.backtest.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import java.util.List;
import lombok.Getter;
import lombok.Setter;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "transactions"
})
@Getter
@Setter
public class TransactionListDTO {

    @JsonProperty("transactions")
    private List<TransactionDTO> transactions;
}
