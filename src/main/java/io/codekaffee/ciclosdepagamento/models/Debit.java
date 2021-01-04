package io.codekaffee.ciclosdepagamento.models;

import io.codekaffee.ciclosdepagamento.dto.DebitDTO;
import io.codekaffee.ciclosdepagamento.models.enums.DebitStatus;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.FieldType;
import org.springframework.data.mongodb.core.mapping.MongoId;

@Data
@Document
@NoArgsConstructor
public class Debit {
    @MongoId(FieldType.OBJECT_ID)
    private String id;

    private String name;

    private Double value;

    private DebitStatus status;

    public Debit(String name, Double value, String status) {
        this.name = name;
        this.value = value;
        this.status = DebitStatus.valueOf(status);
    }

    public Debit(DebitDTO dto){
        this.name = dto.getName();
        this.value = dto.getValue();
        this.status = DebitStatus.getEnum(dto.getStatus());
    }
}
