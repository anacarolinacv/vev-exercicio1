import modelos.Fatura;
import servicos.CriaTipoServico;
import servicos.ServicoNotaFiscal;

import java.util.Scanner;

public class Main {
    static Scanner sc = new Scanner(System.in);
    static ServicoNotaFiscal servicoNotaFiscal = new ServicoNotaFiscal();

    public static void main(String[] args) {
        Fatura fatura = cadastraFatura();
        servicoNotaFiscal.geraNota(fatura);
    }

    public static Fatura cadastraFatura(){
        System.out.println("Nome do cliente: ");
        String cliente = sc.nextLine();
        System.out.println("Endereço do cliente: ");
        String endereco = sc.nextLine();
        System.out.println("Tipo de servico: ");
        String servico = sc.nextLine();
        System.out.println("Valor da fatura: ");
        double valor = sc.nextDouble();

        return new Fatura(cliente, endereco, CriaTipoServico.criar(servico), valor);

    }
}