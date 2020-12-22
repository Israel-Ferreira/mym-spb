package io.codekaffee.ciclosdepagamento.controllers;

import io.codekaffee.ciclosdepagamento.dto.BillingCycleDTO;
import io.codekaffee.ciclosdepagamento.models.BillingCycle;
import io.codekaffee.ciclosdepagamento.repositories.BillingCycleRepository;
import io.codekaffee.ciclosdepagamento.services.BillingCycleService;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/billing-cycles")
public class BillingCycleController {

    @Autowired
    private BillingCycleService billingCycleService;

    @GetMapping
    public ResponseEntity<List<BillingCycleDTO>> findAll(){
        List<BillingCycleDTO> billingCycles = billingCycleService.findAll().stream().map(BillingCycleDTO::new)
                .collect(Collectors.toList());

        return ResponseEntity.ok(billingCycles);
    }


    @PostMapping
    public ResponseEntity<BillingCycleDTO> create(@RequestBody BillingCycleDTO cicle){
        BillingCycle billingCycle =  billingCycleService.create(cicle);
        BillingCycleDTO billingCycleDTO = new BillingCycleDTO(billingCycle);

        return ResponseEntity.status(HttpStatus.CREATED).body(billingCycleDTO);
    }


    @GetMapping("/{id}")
    public ResponseEntity<BillingCycleDTO> getById(@PathVariable ObjectId id){
        BillingCycle bc = billingCycleService.findById(id);
        var billingCycle = new BillingCycleDTO(bc);

        return ResponseEntity.ok(billingCycle);
    }






}
