package br.com.fiap.PagPasse.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import java.util.Date;

public record LinhaDTO(
        Long id,

        @NotBlank(message = "O nome da linha é obrigatório.")
        String nomeLinha,

        @NotBlank(message = "A rota é obrigatória.")
        String rota,

        @NotNull(message = "O tempo estimado é obrigatório.")
        @Positive(message = "O tempo estimado deve ser positivo.")
        Date tempoEstimado,

        @NotBlank(message = "A localização atual é obrigatória.")
        String localizacaoAtual,

        @NotNull(message = "A data da última atualização é obrigatória.")
        Date dataUltimaAtualizacao,

        @NotBlank(message = "O horário de início é obrigatório.")
        Date horarioInicio,

        @NotBlank(message = "O horário de fim é obrigatório.")
        Date horarioFim
) {}
