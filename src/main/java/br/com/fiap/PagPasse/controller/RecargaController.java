package br.com.fiap.PagPasse.controller;

import br.com.fiap.PagPasse.dto.RecargaDTO;
import br.com.fiap.PagPasse.service.RecargaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/recarga")
public class RecargaController {

    @Autowired
    private RecargaService recargaService;

    @PostMapping("/adicionar")
    public ResponseEntity<RecargaDTO> adicionar(@Validated @RequestBody RecargaDTO dto) {
        return ResponseEntity.ok(recargaService.adicionar(dto));
    }

    @GetMapping("/{id}")
    public ResponseEntity<RecargaDTO> buscarPorId(@PathVariable Long id) {
        Optional<RecargaDTO> recargaOpt = recargaService.buscarPorId(id);
        return recargaOpt.map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<RecargaDTO> atualizar(@PathVariable Long id, @Validated @RequestBody RecargaDTO dto) {
        return ResponseEntity.ok(recargaService.atualizar(id, dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> excluir(@PathVariable Long id) {
        recargaService.excluir(id);
        return ResponseEntity.noContent().build();
    }
}
