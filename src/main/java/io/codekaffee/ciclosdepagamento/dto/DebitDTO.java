package io.codekaffee.ciclosdepagamento.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.codekaffee.ciclosdepagamento.models.Debit;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DebitDTO {

    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private String id;

    private String name;
    private Double value;
    private String status;

    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private String billingCycleId;

    public DebitDTO(Debit debit){
        this.id = debit.getId();
        this.name = debit.getName();
        this.value = debit.getValue();
        this.status = debit.getStatus().getDescription();
    }


}
