package engcomp.smartclassufpa.Banco;

import android.provider.BaseColumns;

/**
 * Created by alberto on 18/02/2017.
 */

public final class EstrututuraBanco {

    private EstrututuraBanco () {}


    public static class Disciplina implements BaseColumns {
        public static final String NOME_TABELA = "disciplina";

        public static final String COLUNA_CODIGO_NOME = "codigo";
        public static final String COLUNA_CODIGO_TIPO = "Char(7)";

        public static final String COLUNA_TITULO_NOME = "titulo";
        public static final String COLUNA_TITULO_TIPO = "Char(25)";

        public static final String COLUNA_PROFESSOR_NOME = "PROFESSOR";
        public static final String COLUNA_PROFESSOR_TIPO = "Char(50)";

        public static final String COLUNA_SALA_NOME = "sala";
        public static final String COLUNA_SALA_TIPO = "Char(6)";

        public static final String COLUNA_TURMA_NOME = "turma";
        public static final String COLUNA_TURMA_TIPO = "Char(6)";

        public static final String COLUNA_SEMESTRE_NOME = "semestre";
        public static final String COLUNA_SEMESTRE_TIPO = "Char(6)";




    }

}
