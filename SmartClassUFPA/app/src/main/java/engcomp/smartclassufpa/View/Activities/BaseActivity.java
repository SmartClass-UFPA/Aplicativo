package engcomp.smartclassufpa.View.Activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;

import engcomp.smartclassufpa.Banco.Banco_SmartClass;
import engcomp.smartclassufpa.Data.Disciplina;
import engcomp.smartclassufpa.View.Activities.EmentaActivity;
import android.widget.Toast;

import java.util.ArrayList;

import engcomp.smartclassufpa.R;

public class BaseActivity extends AppCompatActivity {

    public DrawerLayout drawerLayout; // Variável para armazenar o drawer
    protected MenuItem menuItem;
    public NavigationView navigationView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        printConsulta();
        addDados();
    }

    private void printConsulta() {
        Banco_SmartClass banco = new Banco_SmartClass(getApplicationContext());
        ArrayList<Disciplina> disc = banco.getDisciplinas();
        for (Disciplina d : disc) {
            Log.i("Disciplina print", " disciplina: " + d.getCodigo() + " titulo: " + d.getTitulo() +
                    " professor: " + d.getProfessor() + " semestre: " + d.getsemestre() );

        }
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

        Disciplina sinaisSistemas = new Disciplina("EC01020","Sinais e Sistemas","ROSANA","2016.4");
        sinaisSistemas.setTurma("02A");
        sinaisSistemas.setSala("Sala 02 Itec");
        banco.adicionar(sinaisSistemas);


    }

    /**
     * @Override protected void onCreate(Bundle savedInstanceState) {
     * super.onCreate(savedInstanceState);
     * setContentView(R.layout.drawer_layout);
     * setupNavDrawer(); //Configurar drawer
     * <p>
     * }
     **/

    protected void setupNavDrawer(int indices) {
        //Drawer Layout
        final int indice = indices;
        final ActionBar actionBar = getSupportActionBar();
        navigationView = (NavigationView) findViewById(R.id.nav_view);


        actionBar.setHomeAsUpIndicator(R.drawable.ic_menu); //Icone do menu na action bar
        actionBar.setDisplayHomeAsUpEnabled(true); //Exibir botão na ActionBar

        drawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout); //Armazena o layout do drawer na variavel



        //Listener que ouve o estado da drawer para poder mudar o icone


        drawerLayout.addDrawerListener(new DrawerLayout.DrawerListener() {
            @Override
            public void onDrawerSlide(View view, float v) {

            }

            @Override
            public void onDrawerOpened(View view) {
                actionBar.setHomeAsUpIndicator(R.drawable.ic_arrow_back_white_24dp);

            }

            @Override
            public void onDrawerClosed(View view) {
                actionBar.setHomeAsUpIndicator(R.drawable.ic_menu);
            }

            @Override
            public void onDrawerStateChanged(int i) {
                setChecked(indice);




            }
        });


        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                item.setChecked(true);
                 menuItem = item;

                if (drawerLayout != null) {
                    drawerLayout.closeDrawers();
                }

                onNavDrawerItemSelected(item);

                return true;
            }
        });
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home && drawerLayout != null) {

            if (drawerLayout.isDrawerOpen(GravityCompat.START)) {
                drawerLayout.closeDrawer(GravityCompat.START);
                return true;
            } else {
                drawerLayout.openDrawer(GravityCompat.START);
                return true;
            }


        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onBackPressed() {
        if(drawerLayout != null)
        {
            if (drawerLayout.isDrawerOpen(GravityCompat.START)) {
                drawerLayout.closeDrawer(GravityCompat.START);
            }

            else {

                Intent intent = new Intent(this, InicioActivity.class);
                startActivity(intent);
                overridePendingTransition(0, 0);
                /**
                if (mBackPressed + TIME_INTERVAL > System.currentTimeMillis()){
                    super.onBackPressed();
                   // overridePendingTransition(0, 0);
                    return;
                }

                else {
                 Toast.makeText(getBaseContext(), "Pressione voltar novamente para sair", Toast.LENGTH_SHORT).show();
                 }

                mBackPressed = System.currentTimeMillis();
               // super.onBackPressed();
                //overridePendingTransition(0, 0); **/

            }
        }

        else {

            Intent intent = new Intent(this, InicioActivity.class);
            startActivity(intent);
            overridePendingTransition(0, 0);

            /**if (mBackPressed + TIME_INTERVAL > System.currentTimeMillis())
            {
                //super.onBackPressed();
                //return;
                finish();
            }
            else { Toast.makeText(getBaseContext(), "Pressione voltar novamente para sair", Toast.LENGTH_SHORT).show(); }

            mBackPressed = System.currentTimeMillis(); **/
        }
    }

    private void onNavDrawerItemSelected(MenuItem menuItem) {

        if (menuItem.getItemId() == R.id.nav_fotos) {
            Intent intent = new Intent(this, FotosActivity.class);
            drawerLayout.closeDrawer(GravityCompat.START);
            startActivity(intent);
            overridePendingTransition(0, 0);

        }

        if (menuItem.getItemId() == R.id.nav_ementa) {
            Intent intent = new Intent(this, EmentaActivity.class);
            drawerLayout.closeDrawer(GravityCompat.START);
            startActivity(intent);
            overridePendingTransition(0, 0);

        }

        if (menuItem.getItemId() == R.id.nav_home) {
            Intent intent = new Intent(this, InicioActivity.class);
            drawerLayout.closeDrawer(GravityCompat.START);
            startActivity(intent);
            overridePendingTransition(0, 0);

        }

        if (menuItem.getItemId() == R.id.nav_provasetrab) {
            Intent intent = new Intent(this, TrabProvActivity.class);
            drawerLayout.closeDrawer(GravityCompat.START);
            startActivity(intent);
            overridePendingTransition(0, 0);

        }

        if (menuItem.getItemId() == R.id.nav_horarios) {
            Intent intent = new Intent(this, HorariosActivity.class);
            drawerLayout.closeDrawer(GravityCompat.START);
            startActivity(intent);
            overridePendingTransition(0, 0);

        }

        if (menuItem.getItemId() == R.id.nav_settings) {
            Intent intent = new Intent(this, ConfigActivity.class);
            drawerLayout.closeDrawer(GravityCompat.START);
            startActivity(intent);
            overridePendingTransition(0, 0);

        }

        if (menuItem.getItemId() == R.id.nav_sobre) {
            Intent intent = new Intent(this, SobreActivity.class);
            drawerLayout.closeDrawer(GravityCompat.START);
            startActivity(intent);
            overridePendingTransition(0, 0);

        }

        menuItem.setChecked(true);

    }

    public void setChecked(int indice) {

        final int count = indice;
        switch (count) {
            case 1:
                navigationView.getMenu().findItem(R.id.nav_home).setChecked(true);
                break;
            case 2:
                navigationView.getMenu().findItem(R.id.nav_fotos).setChecked(true);
                break;
            case 3:
                navigationView.getMenu().findItem(R.id.nav_horarios).setChecked(true);
                break;
            case 4:
                navigationView.getMenu().findItem(R.id.nav_provasetrab).setChecked(true);
                break;
            case 5:
                navigationView.getMenu().findItem(R.id.nav_settings).setChecked(true);
                break;
            case 6:
                navigationView.getMenu().findItem(R.id.nav_sobre).setChecked(true);
                break;
            case 7:
                navigationView.getMenu().findItem(R.id.nav_ementa).setChecked(true);
                break;
            default:
                navigationView.getMenu().findItem(R.id.nav_home).setChecked(true);
                break;
        }

    }




}
