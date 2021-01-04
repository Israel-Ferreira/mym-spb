package io.codekaffee.ciclosdepagamento.models.enums;

import java.util.Arrays;
import java.util.stream.Collectors;

public enum DebitStatus {
    QUITADO(1, "Quitado"),
    AGENDADO(2, "Agendado"), PENDENTE(3, "Pendente");

    private Integer id;
    private String description;

    DebitStatus(Integer id, String description) {
        this.id = id;
        this.description = description;
    }


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }


    public static DebitStatus getEnum(String description){
        return Arrays.stream(DebitStatus.values())
                .filter(debitStatus -> debitStatus.getDescription().equals(description))
                .findFirst().orElseThrow();
    }
}
