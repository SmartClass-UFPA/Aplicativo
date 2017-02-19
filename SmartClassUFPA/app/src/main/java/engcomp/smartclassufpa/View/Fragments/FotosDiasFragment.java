package engcomp.smartclassufpa.View.Fragments;

import android.app.Activity;
import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Arrays;

import engcomp.smartclassufpa.R;
import engcomp.smartclassufpa.View.Activities.FotosActivity;
import engcomp.smartclassufpa.View.Adapter.FotosListaAdapter;

public class FotosDiasFragment extends Fragment {


    Activity mActivity;
    public FotosActivity fotosActivity;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragmento_fotos, container, false);


        fotosActivity = (FotosActivity) getActivity();
        getActivity().setTitle(fotosActivity.current);

        ArrayList<String> materias = aList();
        ListView listView = (ListView) view.findViewById(R.id.list);

        final FotosListaAdapter adapter = new FotosListaAdapter(getActivity(), materias);

        //for (int i = 0; i < 100; i++) {
        //materias.add("Matéria de Testes" + i);
        //}

        listView.setAdapter(adapter);
        //adapter.notifyDataSetChanged();

        // Inflate the layout for this fragment
        return view;

        
    }


    public ArrayList<String> aList(){

        String conv = fotosActivity.current;
        ArrayList<String> stringArrayList = fotosActivity.stringArrayList;

        String[] array = {"14/02/2017", "12/02/2017", "10/02/2017", "08/02/2017"};
        String[] array1 = {"14/02/2017", "12/02/2017", "10/02/2017", "08/02/2017"};
        String[] array2 = {"14/02/2017", "12/02/2017", "10/02/2017", "08/02/2017"};
        String[] array3 = {"14/02/2017", "12/02/2017", "10/02/2017", "08/02/2017"};



        ArrayList<String> materias = new ArrayList<>(Arrays.asList(array));
        return materias;

    }












    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        mActivity = activity;
    }




}