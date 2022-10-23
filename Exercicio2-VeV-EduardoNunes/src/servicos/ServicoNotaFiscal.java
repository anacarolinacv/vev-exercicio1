package servicos;

import dao.NotaFiscalDao;
import modelos.Fatura;
import modelos.NotaFiscal;
import modelos.TipoProtocolo;
import modelos.TipoServico;

public class ServicoNotaFiscal {

    private NotaFiscalDao notaFiscalDao = new NotaFiscalDao();

    private ServicoMensagem servicoMensagem = new ServicoMensagem();

    public void geraNotaFiscal(Fatura fatura){
        NotaFiscal nf = new NotaFiscal(fatura, fatura.getTipoServico());
        servicoMensagem.envia(nf, TipoProtocolo.SAP);
        servicoMensagem.envia(nf, TipoProtocolo.SMTP);
        notaFiscalDao.salva(nf);
    }
}
