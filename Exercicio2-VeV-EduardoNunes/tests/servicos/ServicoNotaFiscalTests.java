package servicos;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ServicoNotaFiscalTests {

    ServicoNotaFiscal servicoNotaFiscal = new ServicoNotaFiscal();

    private Fatura faturaConsultoria;

    private Fatura faturaTreinamento;

    private Fatura faturaOutroServico;


    @BeforeEach
    void setUp() {
        TipoServico consultoria = CriaTipoServico.criar("CONSULTORIA");
        TipoServico treinamento = CriaTipoServico.criar("TREINAMENTO");
        TipoServico outra = CriaTipoServico.criar("Mentoria");

        faturaConsultoria = new Fatura("Cliente", "Endereco", consultoria, 25.0);
        faturaTreinamento = new Fatura("Cliente 1", "Endereço 1", treinamento, 20.0);
        faturaOutroServico = new Fatura("Cliente 2", "Endereço 2", outra, 25.0);
    }

    @Test
    void dadoTipoServicoConsultoriaEntaoOImpostoEhCalculado(){
        NotaFiscal nf = servicoNotaFiscalTests.criaNotaFiscal(faturaConsultoria);
        Assertions.assertEquals(nf.getValorImposto(), nf.getValor() * 0.35);
    }

    @Test
    void dadoTipoServicoTreinamentoEntaoOImpostoEhCalculado(){
        NotaFiscal nf = servicoNotaFiscalTests.criaNotaFiscal(faturaTreinamento);
        Assertions.assertEquals(nf.getValorImposto(), nf.getValor() * 0.15);
    }

    @Test
    void dadoOutroTipoServicoEntaoOImpostoEhCalculado(){
        NotaFiscal nf = servicoNotaFiscalTests.criaNotaFiscal(faturaTreinamento);
        Assertions.assertEquals(nf.getValorImposto(), nf.getValor().getValor() * 0.06);
    }
}
