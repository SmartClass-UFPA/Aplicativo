package engcomp.smartclassufpa.View.Fragments;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

import engcomp.smartclassufpa.View.Adapter.ProvasReciclerViewAdapter;
import engcomp.smartclassufpa.Data.Prova;
import engcomp.smartclassufpa.R;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link ProvFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link ProvFragment#newInstance} factory method to
 * create an instance of this fragment.
 */

public class ProvFragment extends Fragment {


    private RecyclerView recyclerview;
    private ProvasReciclerViewAdapter adapter;
    private ArrayList<Prova> listaDeProva;




    public ProvFragment() {
        // Required empty public constructor
    }




    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        listaDeProva = new ArrayList<>();
        carregarLista();

        //recupera a reciclerview


    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        return inflater.inflate(R.layout.fragment_prov, container, false);


    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        recyclerview = (RecyclerView) getActivity().findViewById(R.id.recycler_view);
        recyclerview.setLayoutManager(new LinearLayoutManager(getActivity()));
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

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
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
