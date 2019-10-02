package engcomp.smartclassufpa.Data;

import engcomp.smartclassufpa.Banco.EstrBanco;

/**
 * Created by root on 2/11/17.
 */

public class Horario {
    private String horario;
    private int n_horario;
    private long id;
    private int dia_semana;
    private Disciplina disciplina;


    public static final int SEGUNDA = 1;
    public static final int TERÇA = 2;
    public static final int QUARTA = 3;
    public static final int QUINTA = 4;
    public static final int SEXTA = 5;
    public static final int SABADO = 6;
    public static final int DOMINGO = 7;

    public static final int PRIMEIRO_HOR = 1;
    public static final int SEGUNDO_HOR = 2;
    public static final int TERCEIRO_HOR = 3;
    public static final int QUARTO_HOR = 4;
    public static final int QUINTO_HOR = 5;
    public static final int SEXTO_HOR = 6;

    public static  final String PRIMEIRO_HOR_STR = "7:30 as 08:20";
    public static final String SEGUNDO_HOR_STR = "8:20 as 9:10";
    public static final String TERCEIRO_HOR_STR = "09:20 as 10:10";
    public static final String QUARTO_HOR_STR = "10:10 as 11:00";
    public static final String QUINTO_HOR_STR = "11:10 as 12:00";
    public static final String SEXTO_HOR_STR = "12:00 as 12:50";

    public int getN_horario() {
        return n_horario;
    }

    public void setN_horario(int n_horario) {
        this.n_horario = n_horario;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public int getDia_semana() {
        return dia_semana;
    }

    public void setDia_semana(int dia_semana) {
        this.dia_semana = dia_semana;
    }

    public Disciplina getDisciplina() {
        return disciplina;
    }

    public void setDisciplina(Disciplina disciplina) {
        this.disciplina = disciplina;
    }

    public String getHorario() {
        return horario;
    }

    public void setHorario(String horario) {

        this.horario = horario;
    }

    public String getMateria() {

        return disciplina.getTitulo();
    }


    public String getProfessor() {

        return disciplina.getProfessor();
    }


}
