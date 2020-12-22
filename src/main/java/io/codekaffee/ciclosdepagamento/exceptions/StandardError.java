package io.codekaffee.ciclosdepagamento.exceptions;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;


@Data
@NoArgsConstructor
public class StandardError {
    private String message;
    private Integer status;

    private LocalDateTime timestamp;

    public StandardError(String message, Integer status) {
        this.message = message;
        this.status = status;
    }
}
