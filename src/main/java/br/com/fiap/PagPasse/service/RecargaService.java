package br.com.fiap.PagPasse.service;

import br.com.fiap.PagPasse.dto.RecargaDTO;
import br.com.fiap.PagPasse.model.Recarga;
import br.com.fiap.PagPasse.repository.RecargaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class RecargaService {

    @Autowired
    private RecargaRepository recargaRepository;

    public RecargaDTO adicionar(RecargaDTO dto) {
        Recarga recarga = new Recarga();
        recarga.setValorRecarga(dto.valorRecarga());
        recarga.setMetodoPagamento(dto.metodoPagamento());
        recarga.setDataRecarga(dto.dataRecarga());
        recarga.setStatus(dto.status());
        Recarga salvo = recargaRepository.save(recarga);
        return new RecargaDTO(salvo.getId(), salvo.getValorRecarga(), salvo.getMetodoPagamento(), salvo.getDataRecarga(), salvo.getStatus());
    }

    public Optional<RecargaDTO> buscarPorId(Long id) {
        return recargaRepository.findById(id)
                .map(recarga -> new RecargaDTO(recarga.getId(), recarga.getValorRecarga(), recarga.getMetodoPagamento(), recarga.getDataRecarga(), recarga.getStatus()));
    }

    public RecargaDTO atualizar(Long id, RecargaDTO dto) {
        Recarga recarga = recargaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Recarga não encontrada!"));
        recarga.setValorRecarga(dto.valorRecarga());
        recarga.setMetodoPagamento(dto.metodoPagamento());
        recarga.setDataRecarga(dto.dataRecarga());
        recarga.setStatus(dto.status());
        Recarga atualizado = recargaRepository.save(recarga);
        return new RecargaDTO(atualizado.getId(), atualizado.getValorRecarga(), atualizado.getMetodoPagamento(), atualizado.getDataRecarga(), atualizado.getStatus());
    }

    public void excluir(Long id) {
        recargaRepository.deleteById(id);
    }
}
