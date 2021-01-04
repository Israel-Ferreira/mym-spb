package io.codekaffee.ciclosdepagamento.services;

import io.codekaffee.ciclosdepagamento.dto.CreditDTO;
import io.codekaffee.ciclosdepagamento.dto.MultipleCreditDTO;
import io.codekaffee.ciclosdepagamento.models.BillingCycle;
import io.codekaffee.ciclosdepagamento.models.Credit;
import io.codekaffee.ciclosdepagamento.repositories.BillingCycleRepository;
import io.codekaffee.ciclosdepagamento.repositories.CreditRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CreditService {

    @Autowired
    private CreditRepository creditRepository;

    @Autowired
    private BillingCycleRepository bcRepository;

    @Autowired
    private BillingCycleService billingCycleService;


    public Credit addCredit(CreditDTO creditDTO){
        Credit credit = new Credit(creditDTO.getName(), creditDTO.getValue());

        BillingCycle billingCycle = billingCycleService.findById(creditDTO.getBillingCycleId());

        var obj = creditRepository.save(credit);
        billingCycle.getCredits().add(credit);

        bcRepository.save(billingCycle);

        return obj;
    }

    public List<Credit> addCredits(MultipleCreditDTO creditsDto){
        BillingCycle billingCycle = billingCycleService.findById(creditsDto.getBillingCycleId());
        List<Credit> credits = creditsDto.getCredits().stream().map(Credit::new).collect(Collectors.toList());

        var obj = creditRepository.saveAll(credits);
        billingCycle.getCredits().addAll(credits);

        bcRepository.save(billingCycle);

        return  obj;
    }

}
