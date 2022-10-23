package servicos;

import dao.NotaFiscalDao;
import modelos.Fatura;
import modelos.NotaFiscal;
import modelos.TipoServico;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ServicoNotaFiscalTests {

    private ServicoNotaFiscal servicoNotaFiscal;
    private Fatura faturaConsultoria;

    private Fatura faturaTreinamento;

    private Fatura faturaOutroServico;

    TipoServico consultoria;
    TipoServico treinamento;
    TipoServico outra;

    @BeforeEach
    void setUp() {
        servicoNotaFiscal = new ServicoNotaFiscal();
        consultoria = CriaTipoServico.criar("CONSULTORIA");
        treinamento = CriaTipoServico.criar("TREINAMENTO");
        outra = CriaTipoServico.criar("Mentoria");

        faturaConsultoria = new Fatura("Cliente", "Endereco", consultoria, 25.0);
        faturaTreinamento = new Fatura("Cliente 1", "Endereço 1", treinamento, 20.0);
        faturaOutroServico = new Fatura("Cliente 2", "Endereço 2", outra, 25.0);
    }

    @Test
    void dadoTipoServicoConsultoriaEntaoOImpostoEhCalculado(){
        NotaFiscal nf = servicoNotaFiscal.geraNota(faturaConsultoria);
        Assertions.assertEquals(nf.getValorImposto(), consultoria.getImposto(nf.getValor()));
    }

    @Test
    void dadoTipoServicoTreinamentoEntaoOImpostoEhCalculado(){
        NotaFiscal nf = servicoNotaFiscal.geraNota(faturaTreinamento);
        Assertions.assertEquals(nf.getValorImposto(), treinamento.getImposto(nf.getValor()));
    }

    @Test
    void dadoOutroTipoServicoEntaoOImpostoEhCalculado(){
        NotaFiscal nf = servicoNotaFiscal.geraNota(faturaOutroServico);
        Assertions.assertEquals(nf.getValorImposto(), outra.getImposto(nf.getValor()));
    }

    @Test
    void dadoQueAFaturaEhValidaEntaoDeveCriarNotaFiscal(){
        NotaFiscal nf = servicoNotaFiscal.geraNota(faturaConsultoria);
        Assertions.assertEquals(nf.getCliente(), "Cliente");
        Assertions.assertEquals(nf.getValor(), faturaConsultoria.getValor());
        Assertions.assertEquals(nf.getValorImposto(), consultoria.getImposto(nf.getValor()));

    }
}
