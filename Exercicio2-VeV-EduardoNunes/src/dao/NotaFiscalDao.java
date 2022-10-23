package dao;

import modelos.NotaFiscal;

public class NotaFiscalDao {
    public void salva(NotaFiscal nf) {
        System.out.println("salvando no banco");
        System.out.println("Informações da nota fiscal: ");
        System.out.println(nf);
    }
}
