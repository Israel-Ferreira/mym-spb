package io.codekaffee.ciclosdepagamento.dto;

import io.codekaffee.ciclosdepagamento.models.Debit;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DebitDTO {
    private String name;
    private Double value;
    private String status;

    private String billingCycleId;

    public DebitDTO(Debit debit){
        this.name = debit.getName();
        this.value = debit.getValue();
        this.status = debit.getStatus().getDescription();
    }

}
