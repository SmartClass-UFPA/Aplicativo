package engcomp.smartclassufpa.Data;

/**
 * Created by root on 2/11/17.
 */

public class Horario {
    private String horario;
    private String materia;
    private String professor;

    public Horario (String horario, String materia, String professor){
        this.horario = horario;
        this.materia = materia;
        this.professor = professor;
    }

    public Horario (){

    }

    public String getHorario() {
        return horario;
    }

    public void setHorario(String horario) {

        this.horario = horario;
    }

    public String getMateria() {

        return materia;
    }

    public void setMateria(String materia) {

        this.materia = materia;
    }

    public String getProfessor() {

        return professor;
    }

    public void setProfessor(String professor) {

        this.professor = professor;
    }
}
