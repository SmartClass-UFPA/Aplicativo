package engcomp.smartclassufpa;
import android.app.Activity;
import android.os.Bundle;
import android.app.Fragment;
import android.support.constraint.ConstraintLayout;
import android.support.v7.app.ActionBar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Arrays;

public class FotosFragmento extends Fragment {


    Activity mActivity;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragmento_fotos, container, false);



        String[] array = {"Circuitos Elétricos", "Redes de Computadores II", "Sinais e Sistemas", "Probabilidade e Estatística"};

        ArrayList<String> materias = new ArrayList<>(Arrays.asList(array));
        ListView listView = (ListView) view.findViewById(R.id.list);

        final FotosListaAdapter adapter = new FotosListaAdapter(getActivity(), materias, array);
        listView.setAdapter(adapter);
        adapter.notifyDataSetChanged();

        // Inflate the layout for this fragment
        return view;
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        mActivity = activity;
    }


}