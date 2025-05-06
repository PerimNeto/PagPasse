package br.com.fiap.PagPasse.repository;

import br.com.fiap.PagPasse.model.CartaoTransporte;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public interface CartaoTransporteRepository extends JpaRepository<CartaoTransporte, Long> {

    Optional<CartaoTransporte> findById(Long id);

    Optional<CartaoTransporte> findByNumeroCartao(Long numeroCartao);

    List<CartaoTransporte> findBySaldoCartao(Float saldoCartao);

    Optional<CartaoTransporte> findByTipoCartao(String tipoCartao);

    Optional<List<CartaoTransporte>> findByDataEmissaoBetween(LocalDate startDate, LocalDate endDate);
}