package testes;

import ex2.Calculadora;
import org.junit.Test;

import static org.junit.Assert.*;

public class CalculadoraTeste {

    Calculadora c1;

    @Test
    public void calculaSalarioFuncionandoDesenvolvedorTeste() {
        this.c1 = new Calculadora();
        assertTrue(c1.calculaSalario("8191919101", "ana carolina", "ana@ccc.ufcg.edu", "40078.5", "desenvolvedor"));
        assertEquals(1, c1.getSizeFuncionarios());
        assertEquals(1, c1.getSizeSalarios());
    }

    @Test
    public void calculaSalarioFuncionandoTestadorTeste() {
        this.c1 = new Calculadora();
        assertTrue(c1.calculaSalario("8191919101", "ana carolina", "ana@ccc.ufcg.edu", "40078.5", "testador"));
        assertEquals(1, c1.getSizeFuncionarios());
        assertEquals(1, c1.getSizeSalarios());
    }

    @Test
    public void calculaSalarioFuncionandoDBATeste() {
        this.c1 = new Calculadora();
        assertTrue(c1.calculaSalario("8191919101", "ana carolina", "ana@ccc.ufcg.edu", "40078.5", "DBA"));
        assertEquals(1, c1.getSizeFuncionarios());
        assertEquals(1, c1.getSizeSalarios());
    }

    @Test
    public void calculaSalarioFuncionandoGerenteTeste() {
        this.c1 = new Calculadora();
        assertTrue(c1.calculaSalario("8191919101", "ana carolina", "ana@ccc.ufcg.edu", "40078.5", "Gerente"));
        assertEquals(1, c1.getSizeFuncionarios());
        assertEquals(1, c1.getSizeSalarios());
    }

    @Test
    public void calculaSalarioSemCargoDisponivelTeste() {
        this.c1 = new Calculadora();
        assertFalse(c1.calculaSalario("8191919101", "ana carolina", "ana@ccc.ufcg.edu", "40078.5", "devops"));
        assertNotEquals(1, c1.getSizeFuncionarios());
        assertEquals(0, c1.getSizeSalarios());

    }

    @Test
    public void retornaSalarioFuncionarioRetornandoCertoTeste(){
        this.c1 = new Calculadora();
        c1.calculaSalario("8191919101", "ana carolina", "ana@ccc.ufcg.edu", "40078.5", "desenvolvedor");
        assertEquals("32062.8", c1.retornaSalarioFuncionario("8191919101"));
        assertNotEquals("32062.8000000", c1.retornaSalarioFuncionario("8191919101"));

    }

    @Test
    public void retornaSalarioFuncionarioNaoCadastradoTeste(){
        this.c1 = new Calculadora();
        c1.calculaSalario("8191919101", "ana carolina", "ana@ccc.ufcg.edu", "40078.5", "desenvolvedor");
        try {
            c1.retornaSalarioFuncionario("828289292");
            fail();
        } catch (NullPointerException erro) {
            assertEquals("Erro no retorno do salario: funcionario nao existe.", erro.getMessage());
        }
    }
}
