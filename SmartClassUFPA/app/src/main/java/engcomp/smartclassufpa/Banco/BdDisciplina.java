package engcomp.smartclassufpa.Banco;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.renderscript.Long2;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

import engcomp.smartclassufpa.Data.Disciplina;

/**
 * Created by alberto on 18/02/2017.
 */

public class BdDisciplina {

    /**
     * classe de atualização e acesso a disciplinas no banco de dados
     */
     SQLiteDatabase bd;

    public BdDisciplina ( SQLiteDatabase bd) {

        this.bd = bd;

    }


    public void salvar(Disciplina newdisc) {
        //se ja estiver com o mesmo codigo
        Disciplina disc = getDisciplina(newdisc.getCodigo());



        if (disc!=null) {
            atualizar (newdisc);
        } else {
            inserir (newdisc);
        }
    }


    public void atualizar (Disciplina newdisc) {

        ContentValues values = new ContentValues();
        values.put(EstrBanco.Disciplina.COLUNA_TITULO_NOME, newdisc.getTitulo());
        values.put(EstrBanco.Disciplina.COLUNA_PROFESSOR_NOME,  newdisc.getProfessor());
        values.put(EstrBanco.Disciplina.COLUNA_SALA_NOME,newdisc.getSala());
        values.put(EstrBanco.Disciplina.COLUNA_TURMA_NOME, newdisc.getTurma());
        values.put(EstrBanco.Disciplina.COLUNA_SEMESTRE_NOME,newdisc.getsemestre());

        String[] codigo = new String[] { newdisc.getCodigo() } ;
        String where = EstrBanco.Disciplina.COLUNA_CODIGO_NOME + "=?";
        //atualização no banco de dados
        bd.update(EstrBanco.Disciplina.NOME_TABELA,values,where,codigo);

    }




    public void inserir (Disciplina disc) {

        ContentValues values = new ContentValues();
        values.put(EstrBanco.Disciplina.COLUNA_CODIGO_NOME, disc.getCodigo());
        values.put(EstrBanco.Disciplina.COLUNA_TITULO_NOME,disc.getTitulo());
        values.put(EstrBanco.Disciplina.COLUNA_PROFESSOR_NOME,disc.getProfessor());
        values.put(EstrBanco.Disciplina.COLUNA_SALA_NOME,disc.getSala());
        values.put(EstrBanco.Disciplina.COLUNA_TURMA_NOME,disc.getTurma());
        values.put(EstrBanco.Disciplina.COLUNA_SEMESTRE_NOME,disc.getsemestre());

        bd.insert(EstrBanco.Disciplina.NOME_TABELA, "",values);

    }

    public Disciplina getDisciplina(String codigo) {
        Cursor c = bd.query(true,EstrBanco.Disciplina.NOME_TABELA,EstrBanco.Disciplina.COLUNAS,
                EstrBanco.Disciplina.COLUNA_CODIGO_NOME+"='"+codigo+"'",null,null,null,null,null);
        Log.i("numero da consulta: " + codigo,""+c.getCount());
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


    public ArrayList<Disciplina> getDisciplinas() {
        Cursor c = bd.query(true,EstrBanco.Disciplina.NOME_TABELA,EstrBanco.Disciplina.COLUNAS,
               null,null,null,null,null,null);
        ArrayList<Disciplina> disciplinas = new ArrayList<>();

        Log.i("numero da consulta",""+c.getCount());

        if (c.moveToFirst()) {
            //recupera os indices das colunas
            int idxcod = c.getColumnIndex(EstrBanco.Disciplina.COLUNA_CODIGO_NOME);
            int idxtitulo = c.getColumnIndex(EstrBanco.Disciplina.COLUNA_TITULO_NOME);
            int idxprofessor = c.getColumnIndex(EstrBanco.Disciplina.COLUNA_PROFESSOR_NOME);
            int idxsala = c.getColumnIndex(EstrBanco.Disciplina.COLUNA_SALA_NOME);
            int idxturma = c.getColumnIndex(EstrBanco.Disciplina.COLUNA_TURMA_NOME);
            int idxsemestre = c.getColumnIndex(EstrBanco.Disciplina.COLUNA_SEMESTRE_NOME);

            //loop até o final
            do {
                Disciplina newdisc = new Disciplina(c.getString(idxcod),c.getString(idxtitulo),
                        c.getString(idxprofessor),c.getString(idxsemestre));
                newdisc.setTurma(c.getString(idxturma));
                newdisc.setSala(c.getString(idxsala));
                disciplinas.add(newdisc);

            } while (c.moveToNext());
        }

        return disciplinas;
    }


    public ArrayList<Disciplina> getDisciplinas(String coluna, String condicao) {
        Cursor c = bd.query(true,EstrBanco.Disciplina.NOME_TABELA,EstrBanco.Disciplina.COLUNAS,
                coluna+"='"+condicao+"'",null,null,null,null,null);
        ArrayList<Disciplina> disciplinas = new ArrayList<>();

        Log.i("numero da consulta",""+c.getCount());

        if (c.moveToFirst()) {
            //recupera os indices das colunas
            int idxcod = c.getColumnIndex(EstrBanco.Disciplina.COLUNA_CODIGO_NOME);
            int idxtitulo = c.getColumnIndex(EstrBanco.Disciplina.COLUNA_TITULO_NOME);
            int idxprofessor = c.getColumnIndex(EstrBanco.Disciplina.COLUNA_PROFESSOR_NOME);
            int idxsala = c.getColumnIndex(EstrBanco.Disciplina.COLUNA_SALA_NOME);
            int idxturma = c.getColumnIndex(EstrBanco.Disciplina.COLUNA_TURMA_NOME);
            int idxsemestre = c.getColumnIndex(EstrBanco.Disciplina.COLUNA_SEMESTRE_NOME);

            //loop até o final
            do {
                Disciplina newdisc = new Disciplina(c.getString(idxcod),c.getString(idxtitulo),
                        c.getString(idxprofessor),c.getString(idxsemestre));
                newdisc.setTurma(c.getString(idxturma));
                newdisc.setSala(c.getString(idxsala));
                disciplinas.add(newdisc);

            } while (c.moveToNext());
        }

        return disciplinas;
    }





}
