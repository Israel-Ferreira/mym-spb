package io.codekaffee.ciclosdepagamento.services;

import io.codekaffee.ciclosdepagamento.dto.CreditDTO;
import io.codekaffee.ciclosdepagamento.models.BillingCycle;
import io.codekaffee.ciclosdepagamento.models.Credit;
import io.codekaffee.ciclosdepagamento.repositories.BillingCycleRepository;
import io.codekaffee.ciclosdepagamento.repositories.CreditRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CreditService {

    @Autowired
    private CreditRepository creditRepository;

    @Autowired
    private BillingCycleRepository repository;

    @Autowired
    private BillingCycleService billingCycleService;



    public Credit addCredit(CreditDTO creditDTO){
        Credit credit = new Credit(creditDTO.getName(), creditDTO.getValue());

        BillingCycle billingCycle = billingCycleService.findById(creditDTO.getId());
        billingCycle.getCredits().add(credit);

        var obj = creditRepository.save(credit);

        repository.save(billingCycle);

        return obj;
    }
}
