package engcomp.smartclassufpa.View.Activities;

import android.content.Intent;
import android.os.Bundle;

import engcomp.smartclassufpa.R;

public class SobreActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sobre);

        // CONFIGURAÇÕES E SOBRE NÃO POSSUEM NAVIGATION DRAWER




    }

    // SEMPRE SOBRESCREVER ESSE MÉTODO EM SOBRE E CONFIG
    @Override
    public void onBackPressed(){

        // ISSO AQUI É IMPORTANTE PARA QUE QUANDO O USARIO APERTE O BOTAO
        //VOLTAR O APP VOLTE SEMPRE PARA A TELA INICIAL

        super.onBackPressed();

    }


}
