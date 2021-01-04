package io.codekaffee.ciclosdepagamento.controllers;

import io.codekaffee.ciclosdepagamento.dto.CreditDTO;
import io.codekaffee.ciclosdepagamento.dto.MultipleCreditDTO;
import io.codekaffee.ciclosdepagamento.models.Credit;
import io.codekaffee.ciclosdepagamento.services.CreditService;
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
@RequestMapping("/credits")
public class CreditController {

    @Autowired
    private CreditService creditService;

    @PostMapping
    public ResponseEntity<CreditDTO> createCredit(@RequestBody CreditDTO creditDTO){
        Credit credit = creditService.addCredit(creditDTO);

        var response = new CreditDTO(credit);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @PostMapping("/multi")
    public ResponseEntity<List<CreditDTO>> addMultiCredits(@RequestBody MultipleCreditDTO creditsDTO){
        List<Credit> credits = creditService.addCredits(creditsDTO);

        var response = credits.stream().map(CreditDTO::new).collect(Collectors.toList());
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }
}
