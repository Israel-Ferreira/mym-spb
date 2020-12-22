package io.codekaffee.ciclosdepagamento.dto;


import com.fasterxml.jackson.annotation.JsonProperty;
import io.codekaffee.ciclosdepagamento.models.Credit;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.bson.types.ObjectId;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CreditDTO {
    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private ObjectId id;

    private String name;
    private Double value;

    private String billingCycleId;

    public CreditDTO(Credit credit){
        this.id = credit.getId();
        this.name = credit.getName();
        this.value = credit.getValue();
    }
}
