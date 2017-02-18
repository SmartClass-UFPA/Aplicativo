package engcomp.smartclassufpa.View.Activities;

import android.os.Bundle;
import android.widget.FrameLayout;

import engcomp.smartclassufpa.R;

public class EmentaActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Define o layout como a do drawer
        setContentView(R.layout.drawer_layout);
        setupNavDrawer(7); // *Ao chamar o método setupNavDrawer uma flag em int deve
                           // * ser enviada junto:
                           // * 1 - Início, 2 - Fotos, 3 - Horários, 4 - Trabalhos/Provas
                           // * 5 - Configurações, 6 - Sobre, 7 - Ementa
                           // Por padrão, telas de configuração não exibem o Navigation Drawer
                           // Então a flag 5 não será usada por quem fizer a tela de configurações

        // Insere o layout da atividade no container do layout do drawer
        FrameLayout contentFrameLayout = (FrameLayout) findViewById(R.id.container);
        //Em sua activity, substituir o "activity_inicio" pelo nome do seu layout XML
        getLayoutInflater().inflate(R.layout.activity_ementa, contentFrameLayout);


        // --> CÓDIGO DA TUA ATIVIDADE A PARTIR DAQUI <-- //



    }


}
