package servicos;

import modelos.NotaFiscal;
import modelos.TipoProtocolo;

public class ServicoMensagem {
    public void envia(NotaFiscal nf, TipoProtocolo tipo){
        ProtocoloMensagem protocolo = this.cria(tipo);
        protocolo.envia(nf);
    }
    private ProtocoloMensagem cria(TipoProtocolo tipo){
        if(tipo.equals(TipoProtocolo.SAP)){
            return new SAP();
        }
        return new SMTP();
    }
}
