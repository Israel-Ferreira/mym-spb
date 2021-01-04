package io.codekaffee.ciclosdepagamento.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class MultipleCreditDTO {
    private String billingCycleId;
    private List<CreditDTO> credits = new ArrayList<>();
}
