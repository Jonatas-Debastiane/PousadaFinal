package modelos;

public class Quartos {
    private int idQuarto;
    private int numero;
    private String tipo;
    private String descricao;
    private double precoDiaria;
    private boolean status;

    public Quartos() {}

    public Quartos(int numero, String tipo, String descricao, double precoDiaria, boolean status) {
        this.numero = numero;
        this.tipo = tipo;
        this.descricao = descricao;
        this.precoDiaria = precoDiaria;
        this.status = status;
    }

    public int getIdQuarto() {
        return idQuarto;
    }

    public void setIdQuarto(int idQuarto) {
        this.idQuarto = idQuarto;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public double getPrecoDiaria() {
        return precoDiaria;
    }

    public void setPrecoDiaria(double precoDiaria) {
        this.precoDiaria = precoDiaria;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Quarto [ID=" + idQuarto + ", Número=" + numero + ", Tipo=" + tipo +
               ", Descrição=" + descricao + ", Preço=" + precoDiaria + ", Disponível=" + status + "]";
    }
}

