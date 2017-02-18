package engcomp.smartclassufpa.Data;

import java.util.ArrayList;
import java.util.Calendar;

/**
 * Created by alberto on 29/01/2017.
 */

public class Atividade {

    private Calendar data;
    private String titulo;
    private String disciplina;
    private ArrayList<String> assuntos;

    public ArrayList<Boolean> getCheckAssuntos() {
        return checkAssuntos;
    }

    public void setCheckAssuntos(ArrayList<Boolean> checkAssuntos) {
        this.checkAssuntos = checkAssuntos;
    }

    private ArrayList<Boolean> checkAssuntos;
    public Calendar getData() {
        return data;
    }
    public void setData(Calendar data) {
        this.data = data;
    }
    public String getTitulo() {
        return titulo;
    }
    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }
    public String getDisciplina() {
        return disciplina;
    }
    public void setDisciplina(String disciplina) {
        this.disciplina = disciplina;
    }
    public ArrayList<String> getAssuntos() {
        return assuntos;
    }
    public void setAssuntos(ArrayList<String> assuntos) {
        this.assuntos = assuntos;
    }
}
