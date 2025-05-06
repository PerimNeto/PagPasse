package br.com.fiap.PagPasse.repository;

import br.com.fiap.PagPasse.model.Extrato;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

public interface ExtratoRepository extends JpaRepository<Extrato, Long> {

    public Optional<Extrato> findById(Long id);

    public Optional<Extrato> findByValorTarifa(Float valorTarifa);

    public List<Extrato> findByDataPagamentoBetween(LocalDateTime startDate, LocalDateTime endDate);
}
