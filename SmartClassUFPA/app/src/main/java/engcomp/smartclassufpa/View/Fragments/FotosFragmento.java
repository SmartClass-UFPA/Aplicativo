package engcomp.smartclassufpa.View.Fragments;
import android.app.Activity;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;

import engcomp.smartclassufpa.FotosDiasFragmento;
import engcomp.smartclassufpa.R;
import engcomp.smartclassufpa.View.Adapter.FotosListaAdapter;
import engcomp.smartclassufpa.View.Activities.FotosActivity;


public class FotosFragmento extends Fragment {


    Activity mActivity;
    ArrayList<String> materias;
    public FotosActivity fotosActivity;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        final View view = inflater.inflate(R.layout.fragmento_fotos, container, false);
        fotosActivity = (FotosActivity) getActivity();
        materias = aList();
        final ListView listView = (ListView) view.findViewById(R.id.list);

        final FotosListaAdapter adapter = new FotosListaAdapter(getActivity(), materias);

        //for (int i = 0; i < 100; i++) {
        //materias.add("Matéria de Testes" + i);
        //}


        listView.setAdapter(adapter);
        //adapter.notifyDataSetChanged();

        // Inflate the layout for this fragment



        listView.setOnItemClickListener(new AdapterView.OnItemClickListener()
        {
            @Override public void onItemClick(AdapterView<?> arg0, View arg1,int position, long arg3)
            {
                getActivity().setTitle("Fotos");
                String s = materias.get(position);
                fotosActivity.current = s;
                fotosActivity.stringArrayList = materias;

                final FragmentTransaction ft = getFragmentManager().beginTransaction();
                ft.addToBackStack(null);
                ft.replace(R.id.containerFotos, new FotosDiasFragmento());
                ft.commit();


            }
        });

        return view;

    }


    public ArrayList<String> aList(){
        String[] array = {"Circuitos Elétricos", "Redes de Computadores II",
                "Sinais e Sistemas", "Probabilidade e Estatística"};

        ArrayList<String> materias = new ArrayList<>(Arrays.asList(array));
        return materias;

    }

















    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        mActivity = activity;
    }


}