package io.codekaffee.ciclosdepagamento.dto;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.codekaffee.ciclosdepagamento.models.BillingCycle;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.bson.types.ObjectId;


import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BillingCycleDTO {

    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private String id;

    private String name;
    private String month;
    private String year;


    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private List<CreditDTO> credits = new ArrayList<>();

    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private List<DebitDTO> debits = new ArrayList<>();


    public BillingCycleDTO(BillingCycle billingCycle){
        this.id = billingCycle.getId();
        this.name = billingCycle.getName();
        this.month = billingCycle.getMonth();
        this.year = billingCycle.getYear();

        this.credits = billingCycle.getCredits().stream().map(CreditDTO::new).collect(Collectors.toList());
        this.debits = billingCycle.getDebits().stream().map(DebitDTO::new).collect(Collectors.toList());
    }
}
