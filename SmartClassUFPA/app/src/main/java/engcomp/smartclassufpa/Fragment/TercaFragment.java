package engcomp.smartclassufpa.Fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import engcomp.smartclassufpa.Adapter.ListViewHorarioAdapter;
import engcomp.smartclassufpa.R;
import engcomp.smartclassufpa.extras.Horario;

/**
 * A simple {@link Fragment} subclass.
 */
public class TercaFragment extends Fragment {

    private ListView listViewSegunda;
    private ListViewHorarioAdapter adapter;


    public TercaFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_terca, container, false);
        listViewSegunda = (ListView) rootView.findViewById(R.id.listview_semana_terça);
        adapter = new ListViewHorarioAdapter(getActivity().getApplicationContext());
        listViewSegunda.setAdapter(adapter);

        //Horario h = new Horario();

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
            adapter.addItem(h);

        }
        //adapter.addItem(h);

        // Inflate the layout for this fragment
        return rootView;
    }

}