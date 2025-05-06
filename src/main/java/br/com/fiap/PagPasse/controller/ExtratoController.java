package br.com.fiap.PagPasse.controller;

import br.com.fiap.PagPasse.dto.ExtratoDTO;
import br.com.fiap.PagPasse.service.ExtratoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/extrato")
public class ExtratoController {

    @Autowired
    private ExtratoService extratoService;

    @PostMapping("/adicionar")
    public ResponseEntity<ExtratoDTO> adicionar(@Valid @RequestBody ExtratoDTO dto) {
        return ResponseEntity.ok(extratoService.adicionar(dto));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ExtratoDTO> buscarPorId(@PathVariable Long id) {
        Optional<ExtratoDTO> extratoOpt = extratoService.buscarPorId(id);
        return extratoOpt.map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<ExtratoDTO> atualizar(@PathVariable Long id, @Valid @RequestBody ExtratoDTO dto) {
        return ResponseEntity.ok(extratoService.atualizar(id, dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> excluir(@PathVariable Long id) {
        extratoService.excluir(id);
        return ResponseEntity.noContent().build();
    }
}
