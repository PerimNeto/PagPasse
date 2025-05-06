package br.com.fiap.PagPasse.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import java.util.Date;

public record NotificacaoDTO(
        Long id,


        @NotBlank(message = "O tipo de notificação é obrigatório.")
        String tipoNotificacao,

        @NotBlank(message = "A mensagem é obrigatória.")
        String mensagem,

        @NotNull(message = "A data de envio é obrigatória.")
        Date dataEnvio,

        @NotBlank(message = "O email é obrigatório.")
        @Email(message = "Formato de email inválido.")
        String email
) {}
