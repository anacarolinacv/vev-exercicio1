package servicos;

import dao.NotaFiscalDao;
import modelos.Fatura;
import modelos.NotaFiscal;
import modelos.TipoProtocolo;
import modelos.TipoServico;

public class ServicoNotaFiscal {

    private NotaFiscalDao notaFiscalDao;

    private ServicoMensagem servicoMensagem;

    public ServicoNotaFiscal() {
        this.notaFiscalDao = new NotaFiscalDao();
        this.servicoMensagem = new ServicoMensagem();
    }

    public ServicoNotaFiscal(NotaFiscalDao notaFiscalDao, ServicoMensagem servicoMensagem) {
        this.notaFiscalDao = notaFiscalDao;
        this.servicoMensagem = servicoMensagem;
    }

    public NotaFiscal geraNota(Fatura fatura){
        NotaFiscal nf = new NotaFiscal(fatura, fatura.getTipoServico());
        servicoMensagem.envia(nf, TipoProtocolo.SAP);
        servicoMensagem.envia(nf, TipoProtocolo.SMTP);
        notaFiscalDao.salva(nf);

        return nf;
    }
}
