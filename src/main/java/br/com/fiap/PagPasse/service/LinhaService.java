package br.com.fiap.PagPasse.service;

import br.com.fiap.PagPasse.dto.LinhaDTO;
import br.com.fiap.PagPasse.model.Linha;
import br.com.fiap.PagPasse.repository.LinhaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class LinhaService {

    @Autowired
    private LinhaRepository linhaRepository;

    public LinhaDTO adicionar(LinhaDTO dto) {
        Linha linha = new Linha();
        linha.setNomeLinha(dto.nomeLinha());
        linha.setRota(dto.rota());
        linha.setTempoEstimado(dto.tempoEstimado());
        linha.setLocalizacaoAtual(dto.localizacaoAtual());
        linha.setDataUltimaAtualizacao(dto.dataUltimaAtualizacao());
        linha.setHorarioInicio(dto.horarioInicio());
        linha.setHorarioFim(dto.horarioFim());
        Linha salvo = linhaRepository.save(linha);
        return new LinhaDTO(salvo.getId(), salvo.getNomeLinha(), salvo.getRota(), salvo.getTempoEstimado(), salvo.getLocalizacaoAtual(), salvo.getDataUltimaAtualizacao(), salvo.getHorarioInicio(), salvo.getHorarioFim());
    }

    public Optional<LinhaDTO> buscarPorId(Long id) {
        return linhaRepository.findById(id)
                .map(linha -> new LinhaDTO(linha.getId(), linha.getNomeLinha(), linha.getRota(), linha.getTempoEstimado(), linha.getLocalizacaoAtual(), linha.getDataUltimaAtualizacao(), linha.getHorarioInicio(), linha.getHorarioFim()));
    }

    public LinhaDTO atualizar(Long id, LinhaDTO dto) {
        Linha linha = linhaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Linha não encontrada!"));
        linha.setNomeLinha(dto.nomeLinha());
        linha.setRota(dto.rota());
        linha.setTempoEstimado(dto.tempoEstimado());
        linha.setLocalizacaoAtual(dto.localizacaoAtual());
        linha.setDataUltimaAtualizacao(dto.dataUltimaAtualizacao());
        linha.setHorarioInicio(dto.horarioInicio());
        linha.setHorarioFim(dto.horarioFim());
        Linha atualizado = linhaRepository.save(linha);
        return new LinhaDTO(atualizado.getId(), atualizado.getNomeLinha(), atualizado.getRota(), atualizado.getTempoEstimado(), atualizado.getLocalizacaoAtual(), atualizado.getDataUltimaAtualizacao(), atualizado.getHorarioInicio(), atualizado.getHorarioFim());
    }

    public void excluir(Long id) {
        linhaRepository.deleteById(id);
    }
}
