package engcomp.smartclassufpa.Banco;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;

import engcomp.smartclassufpa.Data.Disciplina;
import engcomp.smartclassufpa.Data.Horario;

/**
 * Created by alberto on 18/02/2017.
 */

public class Banco_SmartClass {

    private final BdStarter banco;
    private final SQLiteDatabase bd;
    private BdDisciplina bancoDisciplina;
    private BdHorario bancoHorario;



    public Banco_SmartClass (Context  c) {

        banco = new BdStarter(c);
        bd = banco.getWritableDatabase();

        bancoDisciplina = new BdDisciplina(bd);
        bancoHorario = new BdHorario(bd);

    }


    public ArrayList<Disciplina> getDisciplinas (String semestre) {

        return bancoDisciplina.getDisciplinas(EstrBanco.Disciplina.COLUNA_SEMESTRE_NOME,semestre);

    }

    public void adicionar(Disciplina d )  {
        bancoDisciplina.salvar(d);
    }

    public void adicionar(Horario h)  {
        bancoHorario.salvar(h,bancoDisciplina);
    }

    public ArrayList<Disciplina> getDisciplinas() {
        return bancoDisciplina.getDisciplinas();

    }


    public ArrayList<Horario> getHorariosDoDia(int dia) {

        return bancoHorario.getHorario(EstrBanco.Horario.COLUNA_DIA_SEMANA_NOME,dia,bancoDisciplina);
    }




}
