package engcomp.smartclassufpa.Banco;

import android.content.ContentValues;
import android.content.Context;

import java.util.ArrayList;

import engcomp.smartclassufpa.Data.Horario;

/**
 * Created by root on 2/12/17.
 */

public class BdHorarios {

    private final Context context;
    ArrayList<Horario> horarios = new ArrayList<>();
    Banco_SmartClass banco;

    public BdHorarios(Context c) {
        this.context = c;
        banco = new Banco_SmartClass(context);

    }

    public ArrayList<Horario> getHorarioSegunda() {
        horarios = banco.getHorariosDoDia(Horario.SEGUNDA);
        return horarios;
    }

    public ArrayList<Horario> getHorarioTerca() {
        horarios = banco.getHorariosDoDia(Horario.TERÇA);
        return horarios;
    }

    public ArrayList<Horario> getHorariosQuarta() {
        horarios = banco.getHorariosDoDia(Horario.QUARTA);
        return horarios;
    }

    public ArrayList<Horario> getHorariosQuinta() {
        horarios = banco.getHorariosDoDia(Horario.QUINTA);
        return horarios;
    }

    public ArrayList<Horario> getHorariosSexta() {
        horarios = banco.getHorariosDoDia(Horario.SEXTA);
        return horarios;
    }
}
