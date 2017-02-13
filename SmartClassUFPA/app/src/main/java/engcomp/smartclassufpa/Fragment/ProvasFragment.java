package engcomp.smartclassufpa.Fragment;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

import engcomp.smartclassufpa.Prova;
import engcomp.smartclassufpa.ProvasReciclerViewAdapter;
import engcomp.smartclassufpa.R;


public class ProvasFragment extends Fragment {


    private RecyclerView recyclerview;
    private ProvasReciclerViewAdapter adapter;
    private ArrayList<Prova> listaDeProva;



    public ProvasFragment() {
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




        return v;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        //recupera a reciclerview
        recyclerview = (RecyclerView) getActivity().findViewById(R.id.recycler_view);
        recyclerview.setLayoutManager(new LinearLayoutManager(getActivity()));
        listaDeProva = new ArrayList<>();
        carregarLista();
        adapter = new ProvasReciclerViewAdapter(getActivity().getApplicationContext(),listaDeProva);
        recyclerview.setAdapter(adapter);
        recyclerview.getAdapter().notifyDataSetChanged();


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
            prova.setTitulo("Prova 2ª Avaliação");
            prova.setDisciplina("Rede de Computadores II");
            ArrayList<String> assuntos = new ArrayList<>();
            assuntos.add("Camada de Aplicação");
            assuntos.add("Camada de Transporte");
            prova.setAssuntos(assuntos);

            listaDeProva.add(prova);
        }

    }

}
