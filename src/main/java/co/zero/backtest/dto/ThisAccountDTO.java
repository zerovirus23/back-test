
package co.zero.backtest.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.Getter;
import lombok.Setter;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "id",
    "holders",
    "number",
    "kind",
    "IBAN",
    "swift_bic",
    "bank"
})
@Getter
@Setter
public class ThisAccountDTO {

    @JsonProperty("id")
    private String id;
}
