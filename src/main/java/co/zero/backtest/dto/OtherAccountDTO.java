
package co.zero.backtest.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.Getter;
import lombok.Setter;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "id",
    "holder",
    "number",
    "kind",
    "IBAN",
    "swift_bic",
    "bank",
    "metadata"
})
@Getter
@Setter
public class OtherAccountDTO {

    @JsonProperty("id")
    private String id;
    @JsonProperty("holder")
    private HolderDTO holder;
    @JsonProperty("number")
    private String number;
    @JsonProperty("kind")
    private Object kind;
    @JsonProperty("IBAN")
    private Object iBAN;
    @JsonProperty("swift_bic")
    private Object swiftBic;
    @JsonProperty("bank")
    private BankDTO bank;
    @JsonProperty("metadata")
    private Metadata metadata;
}
