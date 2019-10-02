package engcomp.smartclassufpa.Banco;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import java.util.ArrayList;

import engcomp.smartclassufpa.Data.Disciplina;
import engcomp.smartclassufpa.Data.Horario;

/**
 * Created by alberto on 19/02/2017.
 */

public class BdHorario {

    private SQLiteDatabase bd;

    public BdHorario (SQLiteDatabase bd) {
        this.bd = bd;

    }


    public void salvar(Horario newHorario,BdDisciplina bdDisciplina) {
        //se ja estiver com o mesmo codigo
        Horario horario = getHorario(newHorario.getN_horario(),newHorario.getDia_semana(),bdDisciplina);

        if (horario!=null) {
            atualizar (newHorario);
        } else {
            inserir (newHorario);
        }
    }



    public void inserir (Horario horario) {

        ContentValues values = new ContentValues();
        values.put(EstrBanco.Horario.COLUNA_N_HORARIO_NOME,horario.getN_horario());
        values.put(EstrBanco.Horario.COLUNA_COD_DISCIPLINA_NOME, horario.getDisciplina().getCodigo());
        values.put(EstrBanco.Horario.COLUNA_HORARIO_NOME,horario.getHorario());
        values.put(EstrBanco.Horario.COLUNA_DIA_SEMANA_NOME,horario.getDia_semana());


        bd.insert(EstrBanco.Horario.NOME_TABELA, "",values);

    }

    public Horario getHorario(int n_horario, int dia_semana,BdDisciplina bdDisciplina) {
        Cursor c = bd.query(true,EstrBanco.Horario.NOME_TABELA,EstrBanco.Horario.COLUNAS,
                EstrBanco.Horario.COLUNA_N_HORARIO_NOME+"="+n_horario + " AND " + EstrBanco.Horario.COLUNA_DIA_SEMANA_NOME
                        + "=" + dia_semana,null,null,null,null,null);
        Log.i("numero da consulta: " + n_horario + dia_semana,""+c.getCount());
        if (c.getCount() > 0) {
            //posiciona no primeiro elemento do cursor
            c.moveToFirst();
            Horario horario = new Horario();
            horario.setN_horario(c.getInt(0));
            horario.setDisciplina(bdDisciplina.getDisciplina(c.getString(1)));
            horario.setHorario(c.getString(2));
            horario.setDia_semana(c.getInt(3));

            return horario;
        }
        return null;
    }


    public void atualizar (Horario horario) {

        ContentValues values = new ContentValues();
        values.put(EstrBanco.Horario.COLUNA_N_HORARIO_NOME,horario.getN_horario());
        values.put(EstrBanco.Horario.COLUNA_COD_DISCIPLINA_NOME, horario.getDisciplina().getCodigo());
        values.put(EstrBanco.Horario.COLUNA_HORARIO_NOME,horario.getHorario());
        values.put(EstrBanco.Horario.COLUNA_DIA_SEMANA_NOME,horario.getDia_semana());

        String[] codigo = new String[] { String.valueOf(horario.getN_horario()), String.valueOf(horario.getDia_semana()) } ;
        String where = EstrBanco.Horario.COLUNA_N_HORARIO_NOME + "=?" + " AND " + EstrBanco.Horario.COLUNA_DIA_SEMANA_NOME + "=?";
        //atualização no banco de dados
        bd.update(EstrBanco.Horario.NOME_TABELA,values,where,codigo);

    }

    public ArrayList<Horario> getHorarios(BdDisciplina bdDisciplina) {
        Cursor c = bd.query(true,EstrBanco.Horario.NOME_TABELA,EstrBanco.Horario.COLUNAS,
                null,null,null,null,null,null);
        ArrayList<Horario> horarios = new ArrayList<>();

        Log.i("numero da consulta",""+c.getCount());

        if (c.moveToFirst()) {
            //recupera os indices das colunas
            int idxn_horario = c.getColumnIndex(EstrBanco.Horario.COLUNA_N_HORARIO_NOME);
            int idxcod_disc = c.getColumnIndex(EstrBanco.Horario.COLUNA_COD_DISCIPLINA_NOME);
            int idxhorario = c.getColumnIndex(EstrBanco.Horario.COLUNA_HORARIO_NOME);
            int idxdia_semana = c.getColumnIndex(EstrBanco.Horario.COLUNA_DIA_SEMANA_NOME);

            //loop até o final
            do {
                Horario newHorario = new Horario();
                newHorario.setN_horario(c.getInt(idxn_horario));
                newHorario.setDisciplina(bdDisciplina.getDisciplina(c.getString(idxcod_disc)));
                newHorario.setHorario(c.getString(idxhorario));
                newHorario.setDia_semana(c.getInt(idxdia_semana));
                horarios.add(newHorario);


            } while (c.moveToNext());
        }

        return horarios;
    }


    public ArrayList<Horario> getHorario(String coluna, int condicao,BdDisciplina bdDisciplina) {
        Cursor c = bd.query(true, EstrBanco.Horario.NOME_TABELA, EstrBanco.Horario.COLUNAS,
                coluna + "=" + condicao, null, null, null, null, null);
        ArrayList<Horario> horarios = new ArrayList<>();

        Log.i("numero da consulta", "" + c.getCount());

        if (c.moveToFirst()) {
            //recupera os indices das colunas
            int idxn_horario = c.getColumnIndex(EstrBanco.Horario.COLUNA_N_HORARIO_NOME);
            int idxcod_disc = c.getColumnIndex(EstrBanco.Horario.COLUNA_COD_DISCIPLINA_NOME);
            int idxhorario = c.getColumnIndex(EstrBanco.Horario.COLUNA_HORARIO_NOME);
            int idxdia_semana = c.getColumnIndex(EstrBanco.Horario.COLUNA_DIA_SEMANA_NOME);

            //loop até o final
            do {
                Horario newHorario = new Horario();
                newHorario.setN_horario(c.getInt(idxn_horario));
                newHorario.setDisciplina(bdDisciplina.getDisciplina(c.getString(idxcod_disc)));
                newHorario.setHorario(c.getString(idxhorario));
                newHorario.setDia_semana(c.getInt(idxdia_semana));
                horarios.add(newHorario);


            } while (c.moveToNext());
        }

        return horarios;
    }




}
