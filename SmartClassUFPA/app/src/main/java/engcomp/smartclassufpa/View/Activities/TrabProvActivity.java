package engcomp.smartclassufpa.View.Activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.widget.FrameLayout;

import engcomp.smartclassufpa.View.Adapter.ProvasTrabalhosTabAdapter;
import engcomp.smartclassufpa.R;
public class TrabProvActivity extends BaseActivity {

    private ViewPager mViewPager;
    private ProvasTrabalhosTabAdapter tabAdapter;



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


        getSupportActionBar().setElevation(0);

        String[] titles = {"PROVAS","TRABALHOS"};
        tabAdapter = new ProvasTrabalhosTabAdapter(getSupportFragmentManager(),getApplicationContext(),titles);
        mViewPager = (ViewPager) findViewById(R.id.vp);
        mViewPager.setAdapter(tabAdapter);

        TabLayout tabLayout = (TabLayout) findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(mViewPager);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });


        //mSlidingTabLayout.setViewPager(mviewPager);

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

    public void onBackPressed(){

        // ISSO AQUI É IMPORTANTE PARA QUE QUANDO O USARIO APERTE O BOTAO
        //VOLTAR O APP VOLTE SEMPRE PARA A TELA INICIAL

        super.onBackPressed();

    }




}
