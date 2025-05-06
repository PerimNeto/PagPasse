package br.com.fiap.PagPasse.controller;

import br.com.fiap.PagPasse.dto.NotificacaoDTO;
import br.com.fiap.PagPasse.service.NotificacaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/notificacao")
public class NotificacaoController {

    @Autowired
    private NotificacaoService notificacaoService;

    @PostMapping("/adicionar")
    public ResponseEntity<NotificacaoDTO> adicionar(@Validated @RequestBody NotificacaoDTO dto) {
        return ResponseEntity.ok(notificacaoService.adicionar(dto));
    }

    @GetMapping("/{id}")
    public ResponseEntity<NotificacaoDTO> buscarPorId(@PathVariable Long id) {
        Optional<NotificacaoDTO> notificacaoOpt = notificacaoService.buscarPorId(id);
        return notificacaoOpt.map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<NotificacaoDTO> atualizar(@PathVariable Long id, @Validated @RequestBody NotificacaoDTO dto) {
        return ResponseEntity.ok(notificacaoService.atualizar(id, dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> excluir(@PathVariable Long id) {
        notificacaoService.excluir(id);
        return ResponseEntity.noContent().build();
    }
}
