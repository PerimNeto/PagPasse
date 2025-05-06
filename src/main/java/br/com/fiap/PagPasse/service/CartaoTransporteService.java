package br.com.fiap.PagPasse.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.fiap.PagPasse.dao.cartaoTransporteDao;
import br.com.fiap.PagPasse.dto.CartaoTransporteDTO;
import br.com.fiap.PagPasse.model.CartaoTransporte;
import br.com.fiap.PagPasse.repository.CartaoTransporteRepository;

@Service
public class CartaoTransporteService {

    @Autowired
    private CartaoTransporteRepository CartaoTransporteRepository;

    private final cartaoTransporteDao cartaoTransporteDAO = new cartaoTransporteDao();

    public CartaoTransporteDTO adicionar(CartaoTransporteDTO dto) {
        CartaoTransporte cartao = new CartaoTransporte();
        cartao.setNumeroCartao(dto.numeroCartao());
        cartao.setTipoCartao(dto.tipoCartao());
        cartao.setSaldoCartao(dto.saldoCartao());
        cartao.setDataEmissao(dto.dataEmissao());
        cartaoTransporteDAO.inserir(cartao);
        //CartaoTransporte salvo = cartaoTransporteRepository.save(cartao);
        return new CartaoTransporteDTO(cartao.getId(), cartao.getNumeroCartao(), cartao.getTipoCartao(), cartao.getSaldoCartao(), cartao.getDataEmissao());
    }

    public Optional<CartaoTransporteDTO> buscarPorId(Long id) {
        return cartaoTransporteDAO.buscarPorId(id)
            .map(c -> new CartaoTransporteDTO(c.getId(), c.getNumeroCartao(), c.getTipoCartao(), c.getSaldoCartao(), c.getDataEmissao()));
    }

    public CartaoTransporteDTO atualizar(Long id, CartaoTransporteDTO dto) {
        CartaoTransporte cartao = CartaoTransporteRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Cartão não encontrado!"));
        cartao.setNumeroCartao(dto.numeroCartao());
        cartao.setTipoCartao(dto.tipoCartao());
        cartao.setSaldoCartao(dto.saldoCartao());
        cartao.setDataEmissao(dto.dataEmissao());
        CartaoTransporte atualizado = CartaoTransporteRepository.save(cartao);
        return new CartaoTransporteDTO(atualizado.getId(), atualizado.getNumeroCartao(), atualizado.getTipoCartao(), atualizado.getSaldoCartao(), atualizado.getDataEmissao());
    }

    public void excluir(Long id) {
        CartaoTransporteRepository.deleteById(id);
    }
}
