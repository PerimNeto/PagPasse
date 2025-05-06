package br.com.fiap.PagPasse.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import br.com.fiap.PagPasse.model.CartaoTransporte;

public class cartaoTransporteDao {

    private final String url = "jdbc:mysql://marcusserverpao.mysql.database.azure.com:3306/test";
    private final String user = "admin1";
    private final String password = "WeRxy6Be";

    public void inserir(CartaoTransporte cartao) {
        String sql = "INSERT INTO tbl_cartaoTransporte (numeroCartao, tipoCartao, saldoCartao, dataEmissao) VALUES (?, ?, ?, ?)";
        try (Connection conn = DriverManager.getConnection(url, user, password);
             PreparedStatement stmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {

            stmt.setLong(1, cartao.getNumeroCartao());
            stmt.setString(2, cartao.getTipoCartao());
            stmt.setFloat(3, cartao.getSaldoCartao());
            stmt.setDate(4, new java.sql.Date(cartao.getDataEmissao().getTime()));
            stmt.executeUpdate();

            try (ResultSet rs = stmt.getGeneratedKeys()) {
                if (rs.next()) {
                    cartao.setId(rs.getLong(1));
                }
            }

        } catch (SQLException e) {
            throw new RuntimeException("Erro ao inserir cartão de transporte", e);
        }
    }

    public Optional<CartaoTransporte> buscarPorId(Long id) {
        String sql = "SELECT * FROM tbl_cartaoTransporte WHERE id = ?";
        try (Connection conn = DriverManager.getConnection(url, user, password);
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setLong(1, id);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    return Optional.of(mapResultSetToCartao(rs));
                }
            }

        } catch (SQLException e) {
            throw new RuntimeException("Erro ao buscar cartão de transporte por ID", e);
        }
        return Optional.empty();
    }

    public List<CartaoTransporte> listarTodos() {
        String sql = "SELECT * FROM tbl_cartaoTransporte";
        List<CartaoTransporte> lista = new ArrayList<>();

        try (Connection conn = DriverManager.getConnection(url, user, password);
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                lista.add(mapResultSetToCartao(rs));
            }

        } catch (SQLException e) {
            throw new RuntimeException("Erro ao listar cartões de transporte", e);
        }

        return lista;
    }

    public void atualizar(CartaoTransporte cartao) {
        String sql = "UPDATE tbl_cartaoTransporte SET numeroCartao = ?, tipoCartao = ?, saldoCartao = ?, dataEmissao = ? WHERE id = ?";
        try (Connection conn = DriverManager.getConnection(url, user, password);
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setLong(1, cartao.getNumeroCartao());
            stmt.setString(2, cartao.getTipoCartao());
            stmt.setFloat(3, cartao.getSaldoCartao());
            stmt.setDate(4, new java.sql.Date(cartao.getDataEmissao().getTime()));
            stmt.setLong(5, cartao.getId());
            stmt.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException("Erro ao atualizar cartão de transporte", e);
        }
    }

    public void excluir(Long id) {
        String sql = "DELETE FROM tbl_cartaoTransporte WHERE id = ?";
        try (Connection conn = DriverManager.getConnection(url, user, password);
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setLong(1, id);
            stmt.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException("Erro ao excluir cartão de transporte", e);
        }
    }

    private CartaoTransporte mapResultSetToCartao(ResultSet rs) throws SQLException {
        CartaoTransporte cartao = new CartaoTransporte();
        cartao.setId(rs.getLong("id"));
        cartao.setNumeroCartao(rs.getLong("numeroCartao"));
        cartao.setTipoCartao(rs.getString("tipoCartao"));
        cartao.setSaldoCartao(rs.getFloat("saldoCartao"));
        cartao.setDataEmissao(new Date(rs.getDate("dataEmissao").getTime()));
        return cartao;
    }
}
