package engcomp.smartclassufpa.View.Activities;


import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.widget.FrameLayout;


import java.util.ArrayList;

import engcomp.smartclassufpa.View.Fragments.FotosFragment;
import engcomp.smartclassufpa.R;

public class FotosActivity extends BaseActivity {

    public String current;
    public ArrayList<String> stringArrayList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Define o layout como a do drawer
        setContentView(R.layout.drawer_layout);
        setupNavDrawer(2); // *Ao chamar o método setupNavDrawer uma flag em int deve
                           // * ser enviada junto:
                           // * 1 - Início, 2 - Fotos, 3 - Horários, 4 - Trabalhos/Provas
                           // * 5 - Configurações, 6 - Sobre
                           // Por padrão, telas de configuração não exibem o Navigation Drawer
                           // Então a flag 5 não será usada por quem fizer a tela de configurações

        // Insere o layout da atividade no container do layout do drawer
        FrameLayout contentFrameLayout = (FrameLayout) findViewById(R.id.container);
        //Em sua activity, substituir o "activity_inicio" pelo nome do seu layout XML
        getLayoutInflater().inflate(R.layout.activity_fotos, contentFrameLayout);


        // --> CÓDIGO DA TUA ATIVIDADE A PARTIR DAQUI <-- //


        /**
        ListView listaFotos = (ListView) findViewById(R.id.ListViewFotos);
        String[] materias = {"Circuitos Elétricos", "Redes de Computadores II",
                "Probabilidade e Estatística", "Sinais e Sistemas"};
        ArrayList<String> lista = new ArrayList<String>(Arrays.asList(materias));
        for (int i = 0; i<12; i++){

            lista.add("Matéria de Teste" + i);
        }

        final ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, R.layout.activity_fotos_list_sample, lista);
        listaFotos.setAdapter(adapter); **/




        FragmentManager fragmentManager = getFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

        FotosFragment fragment = new FotosFragment();
        fragmentTransaction.add(R.id.containerFotos, fragment, "oi");
        fragmentTransaction.commit();




    }

    public void onBackPressed(){

        //super.onBackPressed();

        int count = getFragmentManager().getBackStackEntryCount();

        if (count == 0) {
            super.onBackPressed();
            //additional code
        } else {
            getFragmentManager().popBackStack();
            this.setTitle("Fotos");
        }

    }



}
