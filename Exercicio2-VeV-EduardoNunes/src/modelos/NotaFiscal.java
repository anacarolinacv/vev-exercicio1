package modelos;

public class NotaFiscal {

    private String cliente;

    private double valor;

    private double valorImposto;

    public NotaFiscal() {
    }
    public NotaFiscal(String cliente, double valor, double valorImposto) {
        this.cliente = cliente;
        this.valor = valor;
        this.valorImposto = valorImposto;
    }

    public NotaFiscal(Fatura fatura, TipoServico servico){
        cliente = fatura.getCliente();
        valor = fatura.getValor();
        valorImposto = servico.getImposto(fatura.getValor());
    }

    public String getCliente() {
        return cliente;
    }

    public void setCliente(String cliente) {
        this.cliente = cliente;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public double getValorImposto() {
        return valorImposto;
    }

    public void setValorImposto(double valorImposto) {
        this.valorImposto = valorImposto;
    }

    @Override
    public String toString() {
        StringBuffer sb = new StringBuffer();
        sb.append("-------------------\nNome do cliente: " + cliente + "\n");
        sb.append("Valor da nota fiscal: " + valor + "\n");
        sb.append("Valor do imposto: " + valorImposto + "\n-------------------\n");

        return  sb.toString();
    }
}
