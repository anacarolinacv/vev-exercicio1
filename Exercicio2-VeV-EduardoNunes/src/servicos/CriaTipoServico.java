package servicos;

import modelos.TipoServico;

public class CriaTipoServico {

    public static TipoServico criar(String tipo){
        if("CONSULTORIA".equalsIgnoreCase(tipo)){
            return new TipoServico("Consultoria", 0.25);
        }
        else if("TREINAMENTO".equalsIgnoreCase(tipo)){
            return new TipoServico("Treinamento", 0.15);
        }
        return new TipoServico(tipo, 0.06);

    }
}
