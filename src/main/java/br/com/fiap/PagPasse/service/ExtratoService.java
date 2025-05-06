package br.com.fiap.PagPasse.service;

import br.com.fiap.PagPasse.dto.ExtratoDTO;
import br.com.fiap.PagPasse.model.Extrato;
import br.com.fiap.PagPasse.repository.ExtratoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ExtratoService {

    @Autowired
    private ExtratoRepository extratoRepository;

    public ExtratoDTO adicionar(ExtratoDTO dto) {
        Extrato extrato = new Extrato();
        extrato.setValorTarifa(dto.valorTarifa());
        extrato.setDataPagamento(dto.dataPagamento());
        Extrato salvo = extratoRepository.save(extrato);
        return new ExtratoDTO(salvo.getId(), salvo.getValorTarifa(), salvo.getDataPagamento());
    }

    public Optional<ExtratoDTO> buscarPorId(Long id) {
        return extratoRepository.findById(id)
                .map(extrato -> new ExtratoDTO(extrato.getId(), extrato.getValorTarifa(), extrato.getDataPagamento()));
    }

    public ExtratoDTO atualizar(Long id, ExtratoDTO dto) {
        Extrato extrato = extratoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Extrato não encontrado!"));
        extrato.setValorTarifa(dto.valorTarifa());
        extrato.setDataPagamento(dto.dataPagamento());
        Extrato atualizado = extratoRepository.save(extrato);
        return new ExtratoDTO(atualizado.getId(), atualizado.getValorTarifa(), atualizado.getDataPagamento());
    }

    public void excluir(Long id) {
        extratoRepository.deleteById(id);
    }
}
