package engcomp.smartclassufpa.Banco;

import android.content.Context;

import java.util.ArrayList;

import engcomp.smartclassufpa.Data.Disciplina;

/**
 * Created by alberto on 18/02/2017.
 */

public class Banco_SmartClass {

    BdDisciplina bancoDisciplina;



    public Banco_SmartClass (Context  c) {

        bancoDisciplina = new BdDisciplina(c);

    }


    public ArrayList<Disciplina> getDisciplinas (String semestre) {

        return bancoDisciplina.getDisciplinas(EstrBanco.Disciplina.COLUNA_SEMESTRE_NOME,semestre);

    }

    public void adicionar(Disciplina d )  {
        bancoDisciplina.salvar(d);
    }

    public ArrayList getDisciplinas() {
        return bancoDisciplina.getDisciplinas();

    }




}
