package engcomp.smartclassufpa.Banco;

import android.provider.BaseColumns;

/**
 * Created by alberto on 18/02/2017.
 */

public final class EstrBanco {

    public static final String NOME_BANCO = "Banco_SmartClass";
    public static final int VERSAO = 1;

    private EstrBanco() {}

    /**
     * TABELA DISCIPLINA
     *
     * +=====================================================================================================================+
     * | codigo [char (6)] |titulo [Char(25)] | professor [Char(50)] | sala [Char(6)] | turma [Char(6)] | semestre [Char(6)] |
     * +=====================================================================================================================+
     * | EC01018           | Eletrônica Analog| Marco Jorje de Souza | A2             | 1               | 2016.4             |
     * +---------------------------------------------------------------------------------------------------------------------+
     * | EC01018           | Eletrônica Analog| Marco Jorje de Souza | A2             | 1               | 2016.4             |
     * +---------------------------------------------------------------------------------------------------------------------+
     * | EC01018           | Eletrônica Analog| Marco Jorje de Souza | A2             | 1               | 2016.4             |
     * +---------------------------------------------------------------------------------------------------------------------+
     */

    public static class Disciplina implements BaseColumns {
        public static final String NOME_TABELA = "disciplina";

        public static final String COLUNA_CODIGO_NOME = "codigo";
        public static final String COLUNA_CODIGO_TIPO = " Char(7) ";

        public static final String COLUNA_TITULO_NOME = "titulo";
        public static final String COLUNA_TITULO_TIPO = "Char(50) NOT NULL";

        public static final String COLUNA_PROFESSOR_NOME = "professor";
        public static final String COLUNA_PROFESSOR_TIPO = "Char(50) NOT NULL";

        public static final String COLUNA_SALA_NOME = "sala";
        public static final String COLUNA_SALA_TIPO = "Char(6)";

        public static final String COLUNA_TURMA_NOME = "turma";
        public static final String COLUNA_TURMA_TIPO = "Char(6)";

        public static final String COLUNA_SEMESTRE_NOME = "semestre";
        public static final String COLUNA_SEMESTRE_TIPO = "Char(6) NOT NULL";

        public static final String[] COLUNAS = {EstrBanco.Disciplina.COLUNA_CODIGO_NOME,
        Disciplina.COLUNA_TITULO_NOME, Disciplina.COLUNA_PROFESSOR_NOME, Disciplina.COLUNA_SALA_NOME,
        Disciplina.COLUNA_TURMA_NOME, Disciplina.COLUNA_SEMESTRE_NOME};

    }

    public static class Horario implements BaseColumns {
        public static final String NOME_TABELA = "horario";

        public static final String COLUNA_N_HORARIO_NOME = "n_horario";
        public static final String COLUNA_N_HORARIO_TIPO = "int NOT NULL";

        public static final String COLUNA_COD_DISCIPLINA_NOME = "cod_disciplina";
        public static final String COLUNA_COD_DISCIPLINA_TIPO = "Char(7) NOT NULL";

        public static final String COLUNA_HORARIO_NOME = "horario";
        public static final String COLUNA_HORARIO_TIPO = "Char(25) NOT NULL";

        public static final String COLUNA_DIA_SEMANA_NOME = "dia_semana";
        public static final String COLUNA_DIA_SEMANA_TIPO = "int NOT NULL";

        public static final String[] COLUNAS = {Horario.COLUNA_N_HORARIO_NOME,
                Horario.COLUNA_COD_DISCIPLINA_NOME, Horario.COLUNA_HORARIO_NOME, Horario.COLUNA_DIA_SEMANA_NOME};



    }

}
