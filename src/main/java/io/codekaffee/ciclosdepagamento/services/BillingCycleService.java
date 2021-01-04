package io.codekaffee.ciclosdepagamento.services;

import io.codekaffee.ciclosdepagamento.dto.BillingCycleDTO;
import io.codekaffee.ciclosdepagamento.dto.UpdateBillingCycleDTO;
import io.codekaffee.ciclosdepagamento.exceptions.ObjectNotFoundException;
import io.codekaffee.ciclosdepagamento.models.BillingCycle;
import io.codekaffee.ciclosdepagamento.models.Credit;
import io.codekaffee.ciclosdepagamento.models.Debit;
import io.codekaffee.ciclosdepagamento.repositories.BillingCycleRepository;
import io.codekaffee.ciclosdepagamento.repositories.CreditRepository;
import io.codekaffee.ciclosdepagamento.repositories.DebitRepository;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.stream.Collectors;

@Service
public class BillingCycleService {

    @Autowired
    private BillingCycleRepository repository;

    @Autowired
    private CreditRepository creditRepository;

    @Autowired
    private DebitRepository debitRepository;

    public List<BillingCycle> findAll(){
        return repository.findAll();
    }

    public BillingCycle findById(String id){
        return repository.findById(id)
                .orElseThrow(() -> new ObjectNotFoundException("Ciclo de Pagamento não encontrado"));
    }

    public BillingCycle  create(BillingCycleDTO billingCycleDTO){
        BillingCycle billingCycle = new BillingCycle(billingCycleDTO);
        return repository.save(billingCycle);
    }

    public BillingCycle update(String id, UpdateBillingCycleDTO dto){
        System.out.println(id);
        System.out.println(dto);
        List<Credit> credits =  dto.getCredits().stream().map(Credit::new).collect(Collectors.toList());
        List<Debit> debits = dto.getDebits().stream().map(Debit::new).collect(Collectors.toList());

        creditRepository.saveAll(credits);
        debitRepository.saveAll(debits);

        return repository.findById(id)
                .map(billingCycle -> {
                    billingCycle.setName(dto.getName());
                    billingCycle.setMonth(dto.getMonth());
                    billingCycle.setYear(dto.getYear());

                    creditRepository.deleteAll(billingCycle.getCredits());
                    debitRepository.deleteAll(billingCycle.getDebits());

                    billingCycle.setCredits(credits);
                    billingCycle.setDebits(debits);

                    return repository.save(billingCycle);
                }).orElseThrow(() -> new ObjectNotFoundException("Ciclo de Pagamento não encontrado"));
    }


    public void deleteById(String id){
        this.repository.deleteById(id);
    }

    public void deleteAll(List<String> ids){
        List<BillingCycle> billingCycles = this.repository.findAllById(ids);
        this.repository.deleteAll(billingCycles);
    }

}
