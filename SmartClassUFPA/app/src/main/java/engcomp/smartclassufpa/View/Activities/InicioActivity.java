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

import engcomp.smartclassufpa.Banco.Banco_SmartClass;
import engcomp.smartclassufpa.Banco.BdDisciplina;
import engcomp.smartclassufpa.Banco.BdStarter;
import engcomp.smartclassufpa.Data.Disciplina;
import engcomp.smartclassufpa.Data.Horario;
import engcomp.smartclassufpa.View.Adapter.InicioRecyclerViewAdapter;
import engcomp.smartclassufpa.Data.Notificacao;
import engcomp.smartclassufpa.R;

public class InicioActivity extends BaseActivity {

    private RecyclerView recyclerview2;
    private InicioRecyclerViewAdapter adapter;
    private ArrayList<Notificacao> aviso;
    boolean carregardados = true;



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

        if (carregardados) {

            addDados();
            carregardados = false;

        }

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

    private void addDados() {
        Log.i("","add dados executado");

        Banco_SmartClass banco = new Banco_SmartClass(getApplicationContext());

        Disciplina Eletronica = new Disciplina("EC01018","Eletrônica Analogica","MARCO JOSE DE SOUSA","2016.4");
        Eletronica.setTurma("02A");
        Eletronica.setSala("Sala 02 Itec");
        banco.adicionar(Eletronica);

        Disciplina Probabilidade = new Disciplina("EC01019","Probabilidade e estatistica","WALTER JESUS DA COSTA MARTINS FILHO","2016.4");
        Probabilidade.setTurma("02A");
        Probabilidade.setSala("Sala 02 Itec");
        banco.adicionar(Probabilidade);

        Disciplina sinaisSistemas = new Disciplina("EC01020","Sinais e Sistemas","ROSANA PAULA DE OLIVEIRA SOARES","2016.4");
        sinaisSistemas.setTurma("02A");
        sinaisSistemas.setSala("Sala 02 Itec");
        banco.adicionar(sinaisSistemas);

        Disciplina RedesII = new Disciplina("EC01021","Redes de computadores II","EDUARDO COELHO CERQUEIRA","2016.4");
        RedesII.setTurma("02A");
        RedesII.setSala("Sala 02 Itec");
        banco.adicionar(RedesII);

        Horario segunda1 = new Horario();
        segunda1.setDisciplina(Probabilidade);
        segunda1.setDia_semana(Horario.SEGUNDA);
        segunda1.setN_horario(Horario.PRIMEIRO_HOR);
        segunda1.setHorario(Horario.PRIMEIRO_HOR_STR);
        banco.adicionar(segunda1);

        Horario segunda2 = new Horario();
        segunda2.setDisciplina(Probabilidade);
        segunda2.setDia_semana(Horario.SEGUNDA);
        segunda2.setN_horario(Horario.SEGUNDO_HOR);
        segunda2.setHorario(Horario.SEGUNDO_HOR_STR);
        banco.adicionar(segunda2);

        Horario segunda3 = new Horario();
        segunda3.setDisciplina(Eletronica);
        segunda3.setDia_semana(Horario.SEGUNDA);
        segunda3.setN_horario(Horario.TERCEIRO_HOR);
        segunda3.setHorario(Horario.TERCEIRO_HOR_STR);
        banco.adicionar(segunda3);

        Horario segunda4 = new Horario();
        segunda4.setDisciplina(Eletronica);
        segunda4.setDia_semana(Horario.SEGUNDA);
        segunda4.setN_horario(Horario.QUARTO_HOR);
        segunda4.setHorario(Horario.QUARTO_HOR_STR);
        banco.adicionar(segunda4);

        Horario segunda5 = new Horario();
        segunda5.setDisciplina(sinaisSistemas);
        segunda5.setDia_semana(Horario.SEGUNDA);
        segunda5.setN_horario(Horario.QUINTO_HOR);
        segunda5.setHorario(Horario.QUINTO_HOR_STR);
        banco.adicionar(segunda5);

        Horario segunda6 = new Horario();
        segunda6.setDisciplina(sinaisSistemas);
        segunda6.setDia_semana(Horario.SEGUNDA);
        segunda6.setN_horario(Horario.SEXTO_HOR);
        segunda6.setHorario(Horario.SEXTO_HOR_STR);
        banco.adicionar(segunda6);




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







