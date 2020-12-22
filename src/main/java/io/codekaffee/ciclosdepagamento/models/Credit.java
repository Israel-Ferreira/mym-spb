package io.codekaffee.ciclosdepagamento.models;

import io.codekaffee.ciclosdepagamento.dto.CreditDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.FieldType;
import org.springframework.data.mongodb.core.mapping.MongoId;

import javax.validation.constraints.Min;

@Data
@Document
@NoArgsConstructor
public class Credit {

    @MongoId(FieldType.OBJECT_ID)
    private ObjectId id;

    private String name;

    @Min(value = 0)
    private Double value;

    public Credit(String name, Double value) {
        this.name = name;
        this.value = value;
    }

    public Credit(CreditDTO creditDTO){
        this.name = creditDTO.getName();
        this.value = creditDTO.getValue();
    }
}
