package br.com.fiap.PagPasse.controller;

import br.com.fiap.PagPasse.dto.LinhaDTO;
import br.com.fiap.PagPasse.service.LinhaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/linha")
public class LinhaController {

    @Autowired
    private LinhaService linhaService;

    @PostMapping("/adicionar")
    public ResponseEntity<LinhaDTO> adicionar(@Validated @RequestBody LinhaDTO dto) {
        return ResponseEntity.ok(linhaService.adicionar(dto));
    }

    @GetMapping("/{id}")
    public ResponseEntity<LinhaDTO> buscarPorId(@PathVariable Long id) {
        Optional<LinhaDTO> linhaOpt = linhaService.buscarPorId(id);
        return linhaOpt.map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<LinhaDTO> atualizar(@PathVariable Long id, @Validated @RequestBody LinhaDTO dto) {
        return ResponseEntity.ok(linhaService.atualizar(id, dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> excluir(@PathVariable Long id) {
        linhaService.excluir(id);
        return ResponseEntity.noContent().build();
    }
}
