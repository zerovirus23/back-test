
package co.zero.backtest.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.Getter;
import lombok.Setter;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "national_identifier",
    "name"
})
@Getter
@Setter
public class BankDTO {

    @JsonProperty("national_identifier")
    private String nationalIdentifier;
    @JsonProperty("name")
    private String name;
}