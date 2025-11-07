package modelos;

import java.time.LocalDate;


public class Reserva {
    private int idReserva;
    private int idHospede;
    private int idQuarto;
    private LocalDate dataEntrada;
    private LocalDate dataSaida;
    private int qtdHospedes;

    // Getters e Setters
    public int getIdReserva() {
        return idReserva;
    }

    public void setIdReserva(int idReserva) {
        this.idReserva = idReserva;
    }

    public int getIdHospede() {
        return idHospede;
    }

    public void setIdHospede(int idHospede) {
        this.idHospede = idHospede;
    }

    public int getIdQuarto() {
        return idQuarto;
    }

    public void setIdQuarto(int idQuarto) {
        this.idQuarto = idQuarto;
    }

    public LocalDate getDataEntrada() {
        return dataEntrada;
    }

    public void setDataEntrada(LocalDate dataEntrada) {
        this.dataEntrada = dataEntrada;
    }

    public LocalDate getDataSaida() {
        return dataSaida;
    }

    public void setDataSaida(LocalDate dataSaida) {
        this.dataSaida = dataSaida;
    }

    public int getQtdHospedes() {
        return qtdHospedes;
    }

    public void setQtdHospedes(int qtdHospedes) {
        this.qtdHospedes = qtdHospedes;
    }
}
