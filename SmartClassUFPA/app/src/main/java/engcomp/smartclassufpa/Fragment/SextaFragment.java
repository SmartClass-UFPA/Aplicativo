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
public class SextaFragment extends Fragment {

    private ListView listViewSegunda;
    private ListViewHorarioAdapter adapter;


    public SextaFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_sexta, container, false);
        listViewSegunda = (ListView) rootView.findViewById(R.id.listview_semana_sexta);
        adapter = new ListViewHorarioAdapter(getActivity().getApplicationContext());
        listViewSegunda.setAdapter(adapter);

        //Horario h = new Horario();


        Horario h = new Horario();
        h.setHorario("7:30 as 13:00");
        h.setMateria("Dia de dormir");
        h.setProfessor("Bom Fim de Semana :)");

        adapter.addItem(h);


        //adapter.addItem(h);

        // Inflate the layout for this fragment
        return rootView;
    }

}