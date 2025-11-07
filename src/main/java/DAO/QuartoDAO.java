package DAO;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import modelos.Quartos;
import utils.Conexao;

public class QuartoDAO {

    public void inserir(Quartos q) {
        String sql = "INSERT INTO quartos (numero, tipo, descricao, preco_diaria, status) VALUES (?, ?, ?, ?, ?)";
        try (Connection conn = Conexao.getConexao();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, q.getNumero());
            stmt.setString(2, q.getTipo());
            stmt.setString(3, q.getDescricao());
            stmt.setDouble(4, q.getPrecoDiaria());
            stmt.setBoolean(5, q.isStatus());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Quartos> listarTodos() {
        List<Quartos> lista = new ArrayList<>();
        String sql = "SELECT * FROM quartos";
        try (Connection conn = Conexao.getConexao();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                Quartos q = new Quartos();
                q.setIdQuarto(rs.getInt("id_quarto"));
                q.setNumero(rs.getInt("numero"));
                q.setTipo(rs.getString("tipo"));
                q.setDescricao(rs.getString("descricao"));
                q.setPrecoDiaria(rs.getDouble("preco_diaria"));
                q.setStatus(rs.getBoolean("status"));
                lista.add(q);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return lista;
    }

    public Quartos buscarporId(int id) {
    	Quartos quarto = null;
        String sql = "SELECT * FROM quartos WHERE id_quarto = ?";
        try (Connection conn = Conexao.getConexao();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                Quartos q = new Quartos();
                q.setIdQuarto(rs.getInt("id_quarto"));
                q.setNumero(rs.getInt("numero"));
                q.setTipo(rs.getString("tipo"));
                q.setDescricao(rs.getString("descricao"));
                q.setPrecoDiaria(rs.getDouble("preco_diaria"));
                q.setStatus(rs.getBoolean("status"));
                return q;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return quarto;
    }

    public void atualizar(Quartos q) {
        String sql = "UPDATE quartos SET numero = ?, tipo = ?, descricao = ?, preco_diaria = ?, status = ? WHERE id_quarto = ?";
        try (Connection conn = Conexao.getConexao();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, q.getNumero());
            stmt.setString(2, q.getTipo());
            stmt.setString(3, q.getDescricao());
            stmt.setDouble(4, q.getPrecoDiaria());
            stmt.setBoolean(5, q.isStatus());
            stmt.setInt(6, q.getIdQuarto());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deletar(int id) {
        String sql = "DELETE FROM quartos WHERE id_quarto = ?";
        try (Connection conn = Conexao.getConexao();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, id);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

