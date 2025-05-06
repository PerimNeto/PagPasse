package br.com.fiap.PagPasse.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.fiap.PagPasse.dto.CartaoTransporteDTO;
import br.com.fiap.PagPasse.service.CartaoTransporteService;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/cartao-transporte")
public class CartaoTransporteController {

    @Autowired
    private CartaoTransporteService cartaoTransporteService;

    @PostMapping("/adicionar")
    public ResponseEntity<CartaoTransporteDTO> adicionar(@Valid @RequestBody CartaoTransporteDTO dto) {
        return ResponseEntity.ok(cartaoTransporteService.adicionar(dto));
    }

    @GetMapping("/{id}")
    public ResponseEntity<CartaoTransporteDTO> buscarPorId(@PathVariable Long id) {
        Optional<CartaoTransporteDTO> cartaoOpt = cartaoTransporteService.buscarPorId(id);
        return cartaoOpt.map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<CartaoTransporteDTO> atualizar(@PathVariable Long id, @Valid @RequestBody CartaoTransporteDTO dto) {
        return ResponseEntity.ok(cartaoTransporteService.atualizar(id, dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> excluir(@PathVariable Long id) {
        cartaoTransporteService.excluir(id);
        return ResponseEntity.noContent().build();
    }
}
