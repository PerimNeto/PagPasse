package br.com.fiap.PagPasse.service;

import br.com.fiap.PagPasse.dto.NotificacaoDTO;
import br.com.fiap.PagPasse.model.Notificacao;
import br.com.fiap.PagPasse.repository.NotificacaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class NotificacaoService {

    @Autowired
    private NotificacaoRepository notificacaoRepository;

    public NotificacaoDTO adicionar(NotificacaoDTO dto) {
        Notificacao notificacao = new Notificacao();
        notificacao.setTipoNotificacao(dto.tipoNotificacao());
        notificacao.setMensagem(dto.mensagem());
        notificacao.setDataEnvio(dto.dataEnvio());
        notificacao.setEmail(dto.email());
        Notificacao salvo = notificacaoRepository.save(notificacao);
        return new NotificacaoDTO(salvo.getId(), salvo.getTipoNotificacao(), salvo.getMensagem(), salvo.getDataEnvio(), salvo.getEmail());
    }

    public Optional<NotificacaoDTO> buscarPorId(Long id) {
        return notificacaoRepository.findById(id)
                .map(notificacao -> new NotificacaoDTO(notificacao.getId(), notificacao.getTipoNotificacao(), notificacao.getMensagem(), notificacao.getDataEnvio(), notificacao.getEmail()));
    }

    public NotificacaoDTO atualizar(Long id, NotificacaoDTO dto) {
        Notificacao notificacao = notificacaoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Notificação não encontrada!"));
        notificacao.setTipoNotificacao(dto.tipoNotificacao());
        notificacao.setMensagem(dto.mensagem());
        notificacao.setDataEnvio(dto.dataEnvio());
        notificacao.setEmail(dto.email());
        Notificacao atualizado = notificacaoRepository.save(notificacao);
        return new NotificacaoDTO(atualizado.getId(), atualizado.getTipoNotificacao(), atualizado.getMensagem(), atualizado.getDataEnvio(), atualizado.getEmail());
    }

    public void excluir(Long id) {
        notificacaoRepository.deleteById(id);
    }
}
