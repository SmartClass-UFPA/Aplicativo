package engcomp.smartclassufpa.View.Fragments;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

import engcomp.smartclassufpa.Data.Prova;
import engcomp.smartclassufpa.R;
import engcomp.smartclassufpa.View.Adapter.ProvasReciclerViewAdapter;


public class TrabalhosFragment extends Fragment {

    private RecyclerView recyclerview;
    private ProvasReciclerViewAdapter adapter;
    private ArrayList<Prova> listaDeProva;


    public TrabalhosFragment() {
        // Required empty public constructor
    }



    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v =  inflater.inflate(R.layout.fragment_provas, container, false);
        recyclerview = (RecyclerView) v.findViewById(R.id.recycler_view);
        recyclerview.setLayoutManager(new LinearLayoutManager(v.getContext()));
        listaDeProva = new ArrayList<>();
        carregarLista();
        adapter = new ProvasReciclerViewAdapter(v.getContext(),listaDeProva);
        recyclerview.setAdapter(adapter);
        recyclerview.getAdapter().notifyDataSetChanged();



        return v;
    }



    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

    }

    @Override
    public void onDetach() {
        super.onDetach();

    }


    private void carregarLista() {

        for (int i=0; i<10;i++ ) {
            Prova prova = new Prova();
            prova.setTitulo("Trabalho 3 Avaliação");
            prova.setDisciplina("Rede de Computadores II");
            ArrayList<String> assuntos = new ArrayList<>();

            prova.setAssuntos(assuntos);

            listaDeProva.add(prova);
        }

    }


}
