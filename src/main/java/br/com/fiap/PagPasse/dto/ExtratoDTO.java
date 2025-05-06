package br.com.fiap.PagPasse.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import java.util.Date;

public record ExtratoDTO(
        Long id,

        @NotNull(message = "O valor da tarifa é obrigatório.")
        @Positive(message = "O valor da tarifa deve ser positivo.")
        Float valorTarifa,

        @NotNull(message = "A data de pagamento é obrigatória.")
        Date dataPagamento
) {}
