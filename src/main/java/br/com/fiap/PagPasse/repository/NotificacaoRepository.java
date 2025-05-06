package br.com.fiap.PagPasse.repository;

import br.com.fiap.PagPasse.model.Notificacao;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public interface NotificacaoRepository extends JpaRepository<Notificacao, Long> {

    public Optional<Notificacao> findById(Long id);

    public Optional<Notificacao> findByTipoNotificacao(String tipoNotificacao);

    public Optional<Notificacao> findByMensagem(String mensagem);

    public List<Notificacao> findByDataEnvioBetween(LocalDate startDate, LocalDate endDate);

    public Optional<Notificacao> findByEmail(String email);
}
