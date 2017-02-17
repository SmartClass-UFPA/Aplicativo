package engcomp.smartclassufpa.Banco;

import java.util.ArrayList;

import engcomp.smartclassufpa.extras.Horario;

/**
 * Created by root on 2/12/17.
 */

public class BdHorarios {

    ArrayList<Horario>Horario;

    public ArrayList<Horario>getHorario(){
        Horario.add(new Horario());
        return Horario;
    }
}
