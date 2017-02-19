package engcomp.smartclassufpa.Banco;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.renderscript.Long2;

import java.util.ArrayList;

import engcomp.smartclassufpa.Data.Disciplina;

/**
 * Created by alberto on 18/02/2017.
 */

public class BdDisciplina {

    /**
     * classe de atualização e acesso a disciplinas no banco de dados
     */
    private BdStarter banco;
    private SQLiteDatabase bd;

    public BdDisciplina (Context c) {
        banco = new BdStarter(c);
        bd = banco.getWritableDatabase();

    }

    public long inserir (Disciplina disc) {

        ContentValues values = new ContentValues();
        values.put(EstrBanco.Disciplina.COLUNA_CODIGO_NOME, "'"+ disc.getCodigo()+"'");
        values.put(EstrBanco.Disciplina.COLUNA_TITULO_NOME,"'"+  disc.getTitulo()+"'");
        values.put(EstrBanco.Disciplina.COLUNA_PROFESSOR_NOME,"'"+  disc.getProfessor()+"'");
        values.put(EstrBanco.Disciplina.COLUNA_SALA_NOME,"'"+  disc.getSala()+"'");
        values.put(EstrBanco.Disciplina.COLUNA_TURMA_NOME,"'"+  disc.getTurma()+"'");
        values.put(EstrBanco.Disciplina.COLUNA_SEMESTRE_NOME,"'"+  disc.getsemestre()+"'");

        Long cod = bd.insert(EstrBanco.Disciplina.NOME_TABELA,null,values);

        return cod;

    }

    public Disciplina getDisciplina(String codigo) {
        Cursor c = bd.query(true,EstrBanco.Disciplina.NOME_TABELA,EstrBanco.Disciplina.COLUNAS,
                EstrBanco.Disciplina.COLUNA_CODIGO_NOME+"='"+codigo+"'",null,null,null,null,null);
        if (c.getCount() > 0) {
            //posiciona no primeiro elemento do cursor
            c.moveToFirst();
            Disciplina disciplina = new Disciplina(c.getString(0),c.getString(1),c.getString(2),c.getString(5));
            disciplina.setSala(c.getString(3));
            disciplina.setTurma(c.getString(4));

            return disciplina;
        }
        return null;
    }

    public ArrayList<Disciplina> getDisciplinas(String coluna, String condicao) {
        Cursor c = bd.query(true,EstrBanco.Disciplina.NOME_TABELA,EstrBanco.Disciplina.COLUNAS,
                coluna+"='"+condicao+"'",null,null,null,null,null);
        ArrayList<Disciplina> disciplinas = new ArrayList<>();

        return disciplinas;
    }





}
