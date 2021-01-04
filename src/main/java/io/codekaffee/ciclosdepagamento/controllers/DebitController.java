package io.codekaffee.ciclosdepagamento.controllers;

import io.codekaffee.ciclosdepagamento.dto.DebitDTO;
import io.codekaffee.ciclosdepagamento.dto.MultipleDebitDTO;
import io.codekaffee.ciclosdepagamento.models.Debit;
import io.codekaffee.ciclosdepagamento.services.DebitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/debits")
public class DebitController {

    @Autowired
    private DebitService debitService;

    @PostMapping
    public ResponseEntity<DebitDTO> addDebit(@RequestBody DebitDTO debitDTO){
        Debit debit = debitService.addDebit(debitDTO);
        DebitDTO response = new DebitDTO(debit);

        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }





    @PostMapping("/multi")
    public ResponseEntity<List<DebitDTO>> addDebits(@RequestBody MultipleDebitDTO debitDTO){
        List<Debit> debits = debitService.addDebits(debitDTO);
        List<DebitDTO> response = debits.stream().map(DebitDTO::new).collect(Collectors.toList());

        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }
}
