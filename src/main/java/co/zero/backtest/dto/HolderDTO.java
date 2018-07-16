
package co.zero.backtest.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.Getter;
import lombok.Setter;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "name",
    "is_alias"
})
@Getter
@Setter
public class HolderDTO {

    @JsonProperty("name")
    private String name;
    @JsonProperty("is_alias")
    private Boolean isAlias;
}
