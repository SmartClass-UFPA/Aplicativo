package engcomp.smartclassufpa;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.FrameLayout;

import java.util.ArrayList;


public class TrabProvActivity extends BaseActivity {

    private RecyclerView recyclerview;
    private ProvasReciclerViewAdapter adapter;
    private ArrayList<Prova> listaDeProva;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Define o layout como a do drawer
        setContentView(R.layout.drawer_layout);
        setupNavDrawer(4); // *Ao chamar o método setupNavDrawer uma flag em int deve
        // * ser enviada junto:
        // * 1 - Início, 2 - Fotos, 3 - Horários, 4 - Trabalhos/Provas
        // * 5 - Configurações, 6 - Sobre
        // Por padrão, telas de configuração não exibem o Navigation Drawer
        // Então a flag 5 não será usada por quem fizer a tela de configurações

        // Insere o layout da atividade no container do layout do drawer
        FrameLayout contentFrameLayout = (FrameLayout) findViewById(R.id.container);
        //Em sua activity, substituir o "activity_inicio" pelo nome do seu layout XML
        getLayoutInflater().inflate(R.layout.activity_trabprov, contentFrameLayout);

        //recupera a reciclerview
        recyclerview = (RecyclerView) findViewById(R.id.recycler_view);
        recyclerview.setLayoutManager(new LinearLayoutManager(this));
        listaDeProva = new ArrayList<>();
        carregarLista();
        adapter = new ProvasReciclerViewAdapter(getApplicationContext(),listaDeProva);
        recyclerview.setAdapter(adapter);
        recyclerview.getAdapter().notifyDataSetChanged();



        // --> CÓDIGO DA TUA ATIVIDADE A PARTIR DAQUI <-- //

        /**
         *
         * PROJETO ACTIVITY TRABALHOS E PROVAS
         *
         * - definir Classes trabalho e Prova
         * - definir classe temporária para acesso ao banco de dados
         *
         * - definir interface de lista de trabalhos e provas
         * (lista de cards em ordem de data mais recente)
         * (trabalhos e provas separados por tabs)
         *
         * - definir interface de cadastro de trabalho e provas
         *
         *
         *  # Definição da activity
         * - consulta no banco de dados os trabalhos e provas
         * - faz o carregamento da activity através de consultas e passagem de mensagem
         * - escuta os eventos de click nos cards
         * - arrastar para apagar, clicar para ver mais detalhes
         *
         *
         *
         */



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
