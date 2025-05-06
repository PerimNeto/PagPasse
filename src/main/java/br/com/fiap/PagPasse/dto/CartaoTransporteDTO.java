package br.com.fiap.PagPasse.dto;

import java.util.Date;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

public record CartaoTransporteDTO(
        Long id,

        @NotBlank(message = "O número do cartão é obrigatório.")
        //@Size(min = 4, max = 20, message = "O número do cartão deve ter entre 4 e 20 caracteres.")
        Long numeroCartao,

        @NotBlank(message = "O tipo de cartão é obrigatório.")
        String tipoCartao,

        @NotNull(message = "O saldo do cartão é obrigatório.")
        @Positive(message = "O saldo deve ser um valor positivo.")
        Float saldoCartao,

        @NotNull(message = "A data de emissão é obrigatória.")
        Date dataEmissao
) {}
