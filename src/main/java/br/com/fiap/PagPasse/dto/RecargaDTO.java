package br.com.fiap.PagPasse.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import java.util.Date;

public record RecargaDTO(
        Long id,

        @NotNull(message = "O valor da recarga é obrigatório.")
        @Positive(message = "O valor da recarga deve ser positivo.")
        Float valorRecarga,

        @NotBlank(message = "O método de pagamento é obrigatório.")
        String metodoPagamento,

        @NotNull(message = "A data de recarga é obrigatória.")
        Date dataRecarga,

        @NotNull(message = "O status é obrigatório.")
        Boolean status
) {}
