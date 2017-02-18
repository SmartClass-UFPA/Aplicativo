package engcomp.smartclassufpa.Data;

import java.security.PublicKey;
import java.util.ArrayList;

/**
 * Created by makane on 09/02/17.
 */

public class Notificacao
{   private String Assunto;
    private String Estado;
    private String titulo;
    private String horario;
    private String materia;
    private ArrayList<String> conteudo;

    public ArrayList<Boolean> getCheckConteudo() { return checkConteudo;}

    public void setCheckConteudo(ArrayList<Boolean> checkConteudo) {this.checkConteudo = checkConteudo;}
    private ArrayList<Boolean> checkConteudo;
    public String getAssunto(){return Assunto;}
    public void setAssunto(String Assunto){this.Assunto = Assunto;}
    public String getTitulo() { return titulo; }
    public void setTitulo(String titulo) {this.titulo = titulo;}
    public String getHorario()   {
        return horario;
    }
    public void setHorario(String horario)   {
        this.horario=horario;
    }
    public String getMateria() {
        return materia;
    }
    public void setMateria(String materia)   {
        this.materia=materia;
    }
    public void setEstado(String estado){this.Estado = estado;}
    public String getEstado(){return Estado;}
    public ArrayList<String> getConteudo() {return conteudo;    }
    public void setConteudo(ArrayList<String> conteudo) {
        this.conteudo = conteudo;
    }
}
