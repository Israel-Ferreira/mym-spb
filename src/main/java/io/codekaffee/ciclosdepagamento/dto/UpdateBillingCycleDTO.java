package io.codekaffee.ciclosdepagamento.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
public class UpdateBillingCycleDTO {
    private String name;
    private String month;
    private String year;

    private List<CreditDTO> credits = new ArrayList<>();
    private List<DebitDTO>  debits = new ArrayList<>();

    public UpdateBillingCycleDTO(String name, String month, String year) {
        this.name = name;
        this.month = month;
        this.year = year;
    }

    public UpdateBillingCycleDTO(String name, String month, String year, List<CreditDTO> credits, List<DebitDTO> debits) {
        this.name = name;
        this.month = month;
        this.year = year;
        this.credits = credits;
        this.debits = debits;
    }
}
