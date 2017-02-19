package engcomp.smartclassufpa.View.Activities;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.widget.FrameLayout;

import engcomp.smartclassufpa.View.Adapter.TabAdapter;
import engcomp.smartclassufpa.R;

public class HorariosActivity extends BaseActivity {
    private ViewPager mviewPager;
    private TabAdapter tabAdapter;
    //private ListView listViewSegunda;
    //private ListViewHorarioAdapter lAdapter;
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Define o layout como a do drawer
        setContentView(R.layout.drawer_layout);
        setupNavDrawer(3); // *Ao chamar o método setupNavDrawer uma flag em int deve
                           // * ser enviada junto:
                           // * 1 - Início, 2 - Fotos, 3 - Horários, 4 - Trabalhos/Provas
                           // * 5 - Configurações, 6 - Sobre
                           // Por padrão, telas de configuração não exibem o Navigation Drawer
                           // Então a flag 5 não será usada por quem fizer a tela de configurações

        // Insere o layout da atividade no container do layout do drawer
        FrameLayout contentFrameLayout = (FrameLayout) findViewById(R.id.container);
        //Em sua activity, substituir o "activity_inicio" pelo nome do seu layout XML
        getLayoutInflater().inflate(R.layout.activity_horarios, contentFrameLayout);


        // --> CÓDIGO DA TUA ATIVIDADE A PARTIR DAQUI <-- //

        //TOOLBAR
        getSupportActionBar().setElevation(0);
        String[] titles = {"SEGUNDA", "TERÇA", "QUARTA","QUINTA", "SEXTA"};
        tabAdapter = new TabAdapter(getSupportFragmentManager(), this,titles);


        // Get the ViewPager and set it's PagerAdapter so that is can display items
        mviewPager = (ViewPager) findViewById(R.id.vp);
        mviewPager.setAdapter(tabAdapter);

        TabLayout tabLayout = (TabLayout) findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(mviewPager);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });





    }


    public void onBackPressed(){

        // ISSO AQUI É IMPORTANTE PARA QUE QUANDO O USARIO APERTE O BOTAO
        //VOLTAR O APP VOLTE SEMPRE PARA A TELA INICIAL

        super.onBackPressed();

    }
}

