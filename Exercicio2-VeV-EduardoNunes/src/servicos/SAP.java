package servicos;

import modelos.NotaFiscal;

public class SAP implements ProtocoloMensagem {
    public void envia(NotaFiscal nf) {
        System.out.println("enviando pro sap");
    }
}
