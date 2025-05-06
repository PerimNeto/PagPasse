package br.com.fiap.PagPasse.repository;

import br.com.fiap.PagPasse.model.Recarga;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public interface RecargaRepository extends JpaRepository<Recarga, Long> {

    public Optional<Recarga> findById(Long id);

    public Optional<Recarga> findByValorRecarga(Float valorRecarga);

    public Optional<Recarga> findByMetodoPagamento(String metodoPagamento);

    public Optional<List<Recarga>> findByDataRecargaBetween(LocalDate startDate, LocalDate endDate);

    public Optional<Recarga> findByStatus(Boolean status);
}