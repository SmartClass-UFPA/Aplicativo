package engcomp.smartclassufpa.Banco;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import engcomp.smartclassufpa.Data.Disciplina;

/**
 * Created by alberto on 18/02/2017.
 */

public class BdStarter  extends SQLiteOpenHelper {


    private static final String SEP = ",";
    private static final String SPACE = " ";
    private static final String SQL_CRIAR_DISCIPLINA_TAB =
            "CREATE TABLE " + EstrBanco.Disciplina.NOME_TABELA + " ("
            + EstrBanco.Disciplina.COLUNA_CODIGO_NOME + SPACE + EstrBanco.Disciplina.COLUNA_CODIGO_TIPO + " PRIMARY KEY "
            + SEP + EstrBanco.Disciplina.COLUNA_TITULO_NOME + SPACE + EstrBanco.Disciplina.COLUNA_TITULO_TIPO + SEP
             + EstrBanco.Disciplina.COLUNA_PROFESSOR_NOME + SPACE + EstrBanco.Disciplina.COLUNA_PROFESSOR_TIPO + SEP
                    + EstrBanco.Disciplina.COLUNA_SALA_NOME + SPACE + EstrBanco.Disciplina.COLUNA_SALA_TIPO + SEP
                    + EstrBanco.Disciplina.COLUNA_TURMA_NOME + SPACE + EstrBanco.Disciplina.COLUNA_TURMA_TIPO + SEP
                    + EstrBanco.Disciplina.COLUNA_SEMESTRE_NOME + SPACE + EstrBanco.Disciplina.COLUNA_SEMESTRE_TIPO + " )" ;
    private static final String SQL_APAGAR_DISCIPLINA_TAB =
            "DROP TABLE IF EXISTS " + EstrBanco.Disciplina.NOME_TABELA;

    private Context c;

    public BdStarter(Context context) {
        super(context, EstrBanco.NOME_BANCO, null, EstrBanco.VERSAO);
        c = context;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        Log.i("Databse", "Criando banco de dados: " + SQL_CRIAR_DISCIPLINA_TAB);
        db.execSQL(SQL_CRIAR_DISCIPLINA_TAB);



    }



    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {

        db.execSQL(SQL_APAGAR_DISCIPLINA_TAB);
        onCreate(db);

    }





}
