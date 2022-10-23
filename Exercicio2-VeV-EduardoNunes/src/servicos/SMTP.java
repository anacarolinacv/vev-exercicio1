package servicos;

import modelos.NotaFiscal;

public class SMTP implements ProtocoloMensagem {
    public void envia(NotaFiscal nf) {
        System.out.println("enviando por email");
    }
}
