
package co.zero.backtest.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.Getter;
import lombok.Setter;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "currency",
    "amount"
})
@Getter
@Setter
public class NewBalanceDTO {

    @JsonProperty("currency")
    private String currency;
    @JsonProperty("amount")
    private Object amount;
}
