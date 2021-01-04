package io.codekaffee.ciclosdepagamento.services;

import io.codekaffee.ciclosdepagamento.dto.DebitDTO;
import io.codekaffee.ciclosdepagamento.dto.MultipleDebitDTO;
import io.codekaffee.ciclosdepagamento.models.BillingCycle;
import io.codekaffee.ciclosdepagamento.models.Debit;
import io.codekaffee.ciclosdepagamento.repositories.BillingCycleRepository;
import io.codekaffee.ciclosdepagamento.repositories.DebitRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class DebitService {

    @Autowired
    private DebitRepository debitRepository;

    @Autowired
    private BillingCycleRepository billingCycleRepository;

    @Autowired
    private BillingCycleService bcService;


    public Debit addDebit(DebitDTO debitDTO){
        BillingCycle billingCycle = bcService.findById(debitDTO.getBillingCycleId());
        Debit debit = new Debit(debitDTO);

        var obj = debitRepository.save(debit);
        billingCycle.getDebits().add(debit);

        return  obj;
    }



    public List<Debit> addDebits(MultipleDebitDTO debitsDTO){
        BillingCycle billingCycle = bcService.findById(debitsDTO.getBillingCycleId());
        List<Debit> debits =  debitsDTO.getDebits().stream().map(Debit::new).collect(Collectors.toList());

        var obj = debitRepository.saveAll(debits);
        billingCycle.getDebits().addAll(debits);

        billingCycleRepository.save(billingCycle);


        return obj;
    }
}
