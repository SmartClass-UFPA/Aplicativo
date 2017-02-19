package engcomp.smartclassufpa.View.Activities;

import android.os.Bundle;
import android.support.v4.view.GravityCompat;
import android.support.v7.widget.LinearLayoutManager;
import android.util.Log;
import android.widget.FrameLayout;
import android.support.v7.widget.RecyclerView;
import android.widget.FrameLayout;
import android.widget.Toast;

import java.util.ArrayList;

import engcomp.smartclassufpa.Banco.BdDisciplina;
import engcomp.smartclassufpa.Banco.BdStarter;
import engcomp.smartclassufpa.Data.Disciplina;
import engcomp.smartclassufpa.View.Adapter.InicioRecyclerViewAdapter;
import engcomp.smartclassufpa.Data.Notificacao;
import engcomp.smartclassufpa.R;

public class InicioActivity extends BaseActivity {

    private RecyclerView recyclerview2;
    private InicioRecyclerViewAdapter adapter;
    private ArrayList<Notificacao> aviso;


    //VARIAVEIS PRO COISO DE FECHAR
    private static final int TIME_INTERVAL = 2000; // Tempo entre apertos
    private long mBackPressed;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Define o layout como a do drawer
        setContentView(R.layout.drawer_layout);
        setupNavDrawer(1); // *Ao chamar o método setupNavDrawer uma flag em int deve
                           // * ser enviada junto:
                           // * 1 - Início, 2 - Fotos, 3 - Horários, 4 - Trabalhos/Provas
                           // * 5 - Configurações, 6 - Sobre
                           // Por padrão, telas de configuração não exibem o Navigation Drawer
                           // Então a flag 5 não será usada por quem fizer a tela de configurações

        // Insere o layout da atividade no container do layout do drawer
        FrameLayout contentFrameLayout = (FrameLayout) findViewById(R.id.container);
        //Em sua activity, substituir o "activity_inicio" pelo nome do seu layout XML
        getLayoutInflater().inflate(R.layout.activity_inicio, contentFrameLayout);


        // --> CÓDIGO DA TUA ATIVIDADE A PARTIR DAQUI <-- //


        recyclerview2 = (RecyclerView) findViewById(R.id.recycler_view2);
        recyclerview2.setLayoutManager(new LinearLayoutManager(this));
        aviso = new ArrayList<>();
        abrirLista();
        adapter = new InicioRecyclerViewAdapter(getApplicationContext(),aviso);
        recyclerview2.setAdapter(adapter);
        recyclerview2.getAdapter().notifyDataSetChanged();}

        void abrirLista()
        {
                Notificacao notificacao = new Notificacao();
                notificacao.setTitulo("Professor em sala");
                notificacao.setHorario("7:30~9:10");
                notificacao.setEstado("sim, corre.");
                notificacao.setMateria("Matéria: Redes");
                notificacao.setAssunto("ele parece estar brabo pelo ar condicionado ter quebrado.");
                aviso.add(notificacao);

                Notificacao notificacao1 = new Notificacao();
                notificacao1.setTitulo("Temperatura:");
                notificacao1.setHorario("7:30~9:10");
                notificacao1.setEstado("Rio de janeiro 40º");
                notificacao1.setAssunto("Nossa, vai todo mundo morrer");
                aviso.add(notificacao1);

                Notificacao notificacao2 = new Notificacao();
                notificacao2.setTitulo("Chuva");
                notificacao2.setHorario("7:38");
                notificacao2.setEstado("Está chovendo");
                notificacao2.setAssunto("Traz um barco pra gente");
                aviso.add(notificacao2);

                Notificacao notificacao3 = new Notificacao();
                notificacao3.setTitulo(" receber do banco de dados");
                notificacao3.setHorario("receber do banco de dados");
                notificacao3.setEstado("receber do banco de dados");
                notificacao3.setAssunto("CADÊ O BANCO DE DADOS? ;-;");
                aviso.add(notificacao3);
        }

    @Override
    public void onBackPressed() {
        if(drawerLayout != null)
        {
            if (drawerLayout.isDrawerOpen(GravityCompat.START)) {
                drawerLayout.closeDrawer(GravityCompat.START);
            }

            else {
                if (mBackPressed + TIME_INTERVAL > System.currentTimeMillis()){
                    finish();
                }

                else {
                    Toast.makeText(getBaseContext(), "Pressione voltar novamente para sair", Toast.LENGTH_SHORT).show();
                }

                mBackPressed = System.currentTimeMillis();
            }

        }
    }
}







