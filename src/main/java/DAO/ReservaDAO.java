package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import modelos.Reserva;
import utils.Conexao;


public class ReservaDAO {
    private Connection con = Conexao.getConexao();

    public void salvar(Reserva reserva) {
        String sql = "INSERT INTO reservas (id_hospede, id_quarto, data_entrada, data_saida, qtd_hospedes) VALUES (?, ?, ?, ?, ?)";

        try (PreparedStatement stm = con.prepareStatement(sql)) {
            stm.setInt(1, reserva.getIdHospede());
            stm.setInt(2, reserva.getIdQuarto());
            stm.setDate(3, java.sql.Date.valueOf(reserva.getDataEntrada()));
            stm.setDate(4, java.sql.Date.valueOf(reserva.getDataSaida()));
            stm.setInt(5, reserva.getQtdHospedes());
            stm.execute();
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao salvar reserva: " + e.getMessage());
        }
    }
}
