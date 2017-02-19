package engcomp.smartclassufpa.Data;

/**
 * Created by alberto on 18/02/2017.
 */

public class Disciplina {
    private String codigo;
    private String titulo;
    private String professor;
    private String sala;
    private String Turma;
    private String semestre;

    public Disciplina (String codigo, String titulo, String professor, String semestre) {
        this.codigo = codigo;
        this.titulo = titulo;
        this.professor = professor;
        this.semestre = semestre;

    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getProfessor() {
        return professor;
    }

    public void setProfessor(String professor) {
        this.professor = professor;
    }

    public String getSala() {
        return sala;
    }

    public void setSala(String sala) {
        this.sala = sala;
    }

    public String getTurma() {
        return Turma;
    }

    public void setTurma(String turma) {
        Turma = turma;
    }

    public String getsemestre() {
        return semestre;
    }

    public void setSemestre(String semestre) {
        semestre = semestre;
    }





}
