package engcomp.smartclassufpa.View.Fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import engcomp.smartclassufpa.View.Adapter.ListViewHorarioAdapter;
import engcomp.smartclassufpa.Banco.BdHorarios;
import engcomp.smartclassufpa.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class QuintaFragment extends Fragment {

    private ListView listViewSegunda;
    private ListViewHorarioAdapter adapter;
    private BdHorarios bdHorarios;


    public QuintaFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_quinta, container, false);
        listViewSegunda = (ListView) rootView.findViewById(R.id.listview_semana_quinta);
        adapter = new ListViewHorarioAdapter(getActivity().getApplicationContext());
        listViewSegunda.setAdapter(adapter);

        bdHorarios = new BdHorarios(getActivity().getApplicationContext());
        adapter.addHorarios(bdHorarios.getHorariosQuinta());

        // Inflate the layout for this fragment
        return rootView;
    }

}