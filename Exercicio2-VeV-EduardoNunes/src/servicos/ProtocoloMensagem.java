package servicos;

import modelos.NotaFiscal;

public interface ProtocoloMensagem {

    void envia(NotaFiscal nf);
}
