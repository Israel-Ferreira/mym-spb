package io.codekaffee.ciclosdepagamento.models;


import io.codekaffee.ciclosdepagamento.dto.BillingCycleDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.FieldType;
import org.springframework.data.mongodb.core.mapping.MongoId;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Data
@Document
@NoArgsConstructor
@AllArgsConstructor
public class BillingCycle {

    @MongoId(FieldType.OBJECT_ID)
    private String id;

    private String name;
    private String month;
    private String year;

    @DBRef(lazy = true)
    private List<Credit> credits = new ArrayList<>();

    @DBRef(lazy = true)
    private List<Debit> debits = new ArrayList<>();


    public BillingCycle(String name, String month, String year) {
        this.name = name;
        this.month = month;
        this.year = year;
    }

    public BillingCycle(BillingCycleDTO dto){
        this.name = dto.getName();
        this.month = dto.getMonth();
        this.year = dto.getYear();

        this.credits = dto.getCredits().stream().map(Credit::new).collect(Collectors.toList());
        this.debits = dto.getDebits().stream().map(Debit::new).collect(Collectors.toList());
    }
}
