package modelos;

public class TipoServico {
    String tipo;
    double porcentagem;

    public TipoServico() {
    }

    public TipoServico(String tipo, double porcentagem) {
        this.tipo = tipo;
        this.porcentagem = porcentagem;
    }

    public double getImposto(double valor){
        return valor * porcentagem;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public double getPorcentagem() {
        return porcentagem;
    }

    public void setPorcentagem(double porcentagem) {
        this.porcentagem = porcentagem;
    }
}
