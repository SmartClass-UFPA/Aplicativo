package engcomp.smartclassufpa.Banco;

import java.util.ArrayList;

import engcomp.smartclassufpa.Data.Horario;

/**
 * Created by root on 2/12/17.
 */

public class BdHorarios {

    ArrayList<Horario> horarios = new ArrayList<>();

    public ArrayList<Horario> getHorarioSegunda() {
        for (int i = 0; i < 6; i++) {
            Horario h = new Horario();
            switch (i) {
                case 0:
                    h.setHorario("7:30 as 8:20");
                    h.setMateria("Probabilidade e Estatística");
                    h.setProfessor("Professor Walter");
                    break;
                case 1:
                    h.setHorario("8:30 as 9:10");
                    h.setMateria("Probabilidade e Estatística");
                    h.setProfessor("Professor Walter");
                    break;
                case 2:
                    h.setHorario("9:20 as 10:10");
                    h.setMateria("Eletrônica Analógica");
                    h.setProfessor("Professor Marco");
                    break;
                case 3:
                    h.setHorario("10:20 as 11:10");
                    h.setMateria("Eletrônica Analógica");
                    h.setProfessor("Professor Marco");
                    break;
                case 4:
                    h.setHorario("11:20 as 12:00");
                    h.setMateria("Sinais e Sistemas");
                    h.setProfessor("Professora Rosana");
                    break;
                case 5:
                    h.setHorario("12:10 as 13:00");
                    h.setMateria("Sinais e Sistemas");
                    h.setProfessor("Professora Rosana");
                    break;
                default:
            }
            horarios.add(h);
        }
        return horarios;
    }

    public ArrayList<Horario> getHorarioTerca() {
        for (int i = 0; i < 6; i++) {
            Horario h = new Horario();
            switch (i) {
                case 0:
                    h.setHorario("7:30 as 8:20");
                    h.setMateria("Horário Vago");
                    h.setProfessor("Seja feliz como achar que deva");
                    break;
                case 1:
                    h.setHorario("8:30 as 9:10");
                    h.setMateria("Horário Vago");
                    h.setProfessor("Seja feliz como achar que deva");
                    break;
                case 2:
                    h.setHorario("9:20 as 10:10");
                    h.setMateria("Redes de Computadores II");
                    h.setProfessor("Professor Eduardo Cerqueira");
                    break;
                case 3:
                    h.setHorario("10:20 as 11:10");
                    h.setMateria("Redes de Computadores II");
                    h.setProfessor("Professor Eduardo Cerqueira");
                    break;
                case 4:
                    h.setHorario("11:20 as 12:00");
                    h.setMateria("Laboratório de Eletrônica Analógica (Grupo 1)");
                    h.setProfessor("Professor Marco");
                    break;
                case 5:
                    h.setHorario("12:10 as 13:00");
                    h.setMateria("Laboratório de Eletrônica Analógica (Grupo 2)");
                    h.setProfessor("Professor Marco");
                    break;
                default:
            }
            horarios.add(h);
        }
        return horarios;
    }

    public ArrayList<Horario> getHorariosQuarta() {
        for (int i = 0; i < 6; i++) {
            Horario h = new Horario();
            switch (i) {
                case 0:
                    h.setHorario("7:30 as 8:20");
                    h.setMateria("Probabilidade e Estatística");
                    h.setProfessor("Professor Walter");
                    break;
                case 1:
                    h.setHorario("8:30 as 9:10");
                    h.setMateria("Probabilidade e Estatística");
                    h.setProfessor("Professor Walter");
                    break;
                case 2:
                    h.setHorario("9:20 as 10:10");
                    h.setMateria("Eletrônica Analógica");
                    h.setProfessor("Professor Marco");
                    break;
                case 3:
                    h.setHorario("10:20 as 11:10");
                    h.setMateria("Eletrônica Analógica");
                    h.setProfessor("Professor Marco");
                    break;
                case 4:
                    h.setHorario("11:20 as 12:00");
                    h.setMateria("Sinais e Sistemas");
                    h.setProfessor("Professora Rosana");
                    break;
                case 5:
                    h.setHorario("12:10 as 13:00");
                    h.setMateria("Sinais e Sistemas");
                    h.setProfessor("Professora Rosana");
                    break;
                default:
            }
            horarios.add(h);

        }
        return horarios;
    }

    public ArrayList<Horario> getHorariosQuinta() {
        for (int i = 0; i < 6; i++) {
            Horario h = new Horario();
            switch (i) {
                case 0:
                    h.setHorario("7:30 as 8:20");
                    h.setMateria("Laboratório de Eletrônica Analógica (Grupo 2)");
                    h.setProfessor("Professor Marco");
                    break;
                case 1:
                    h.setHorario("8:30 as 9:10");
                    h.setMateria("Laboratório de Eletrônica Analógica (Grupo 2)");
                    h.setProfessor("Professor Marco");
                    break;
                case 2:
                    h.setHorario("9:20 as 10:10");
                    h.setMateria("Redes de Computadores II");
                    h.setProfessor("Professor Eduardo Cerqueira");
                    break;
                case 3:
                    h.setHorario("10:20 as 11:10");
                    h.setMateria("Redes de Computadores II");
                    h.setProfessor("Professor Eduardo Cerqueira");
                    break;
                case 4:
                    h.setHorario("11:20 as 12:00");
                    h.setMateria("Horário vago");
                    h.setProfessor("Seja feliz como você achar que deva");
                    break;
                case 5:
                    h.setHorario("12:10 as 13:00");
                    h.setMateria("Horário vago");
                    h.setProfessor("Seja feliz como achar que deva");
                    break;
                default:
            }
            horarios.add(h);

        }
        return horarios;
    }

    public ArrayList<Horario> getHorariosSexta() {
        Horario h = new Horario();
        h.setHorario("7:30 as 13:00");
        h.setMateria("Dia de dormir");
        h.setProfessor("Bom Fim de Semana :)");
        horarios.add(h);
        return horarios;
    }
}
