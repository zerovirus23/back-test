
package co.zero.backtest.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.Getter;
import lombok.Setter;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "id",
    "this_account",
    "other_account",
    "details",
    "metadata"
})
@Getter
@Setter
public class TransactionDTO {

    @JsonProperty("id")
    private String id;
    @JsonProperty("this_account")
    private ThisAccountDTO thisAccount;
    @JsonProperty("other_account")
    private OtherAccountDTO otherAccount;
    @JsonProperty("details")
    private DetailsDTO details;
}
