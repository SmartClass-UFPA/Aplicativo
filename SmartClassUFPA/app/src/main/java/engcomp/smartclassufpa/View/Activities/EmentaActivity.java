package engcomp.smartclassufpa.View.Activities;


import android.content.Intent;
import android.content.res.Configuration;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ListView;
import android.widget.TabHost;
import android.widget.TextView;
import android.view.Menu;

import engcomp.smartclassufpa.R;
import engcomp.smartclassufpa.View.Activities.BaseActivity;
import engcomp.smartclassufpa.View.Activities.InicioActivity;
import engcomp.smartclassufpa.View.Fragments.Ementa1Fragment;
import engcomp.smartclassufpa.View.Fragments.Ementa2Fragment;
import engcomp.smartclassufpa.View.Fragments.Ementa3Fragment;
import engcomp.smartclassufpa.View.Fragments.Ementa4Fragment;
import engcomp.smartclassufpa.View.Fragments.Ementa5Fragment;
import engcomp.smartclassufpa.View.Fragments.Ementa6Fragment;
import engcomp.smartclassufpa.View.Fragments.Ementa7Fragment;
import engcomp.smartclassufpa.View.Fragments.Ementa8Fragment;

public class EmentaActivity extends BaseActivity {
    FragmentManager fm = getSupportFragmentManager();

    @Override
    public void onCreate(Bundle savedInstanceState) {
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
        getLayoutInflater().inflate(R.layout.activity_ementa, contentFrameLayout);

        if(savedInstanceState == null){

            Ementa1Fragment frag1 = new Ementa1Fragment();
            FragmentTransaction ft = fm.beginTransaction();
            ft.add(R.id.fragmentEmenta, frag1, "abc");
            ft.commit();
        }

        String[] list = new String[]{"1° Semestre","2° Semestre", "3° Semestre","4° Semestre","5° Semestre","6° Semestre",
                "7° Semestre","8° Semestre",};
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, list);

        ListView lv = (ListView) findViewById(R.id.listView1);
        lv.setAdapter(adapter);
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> lv, View view, int position, long id) {
                if (position == 0){
                    Ementa1Fragment frag1 = new Ementa1Fragment();
                    FragmentTransaction ft = fm.beginTransaction();
                    ft.replace(R.id.fragmentEmenta, frag1, "abc");
                    ft.addToBackStack("pilha");
                    ft.commit();
                }
                else if (position == 1) {
                    Ementa2Fragment frag1 = new Ementa2Fragment();
                    FragmentTransaction ft = fm.beginTransaction();
                    ft.replace(R.id.fragmentEmenta, frag1, "abc");
                    ft.addToBackStack("pilha");
                    ft.commit();
                }
                else if (position == 2) {
                    Ementa3Fragment frag3 = new Ementa3Fragment();
                    FragmentTransaction ft = fm.beginTransaction();
                    ft.replace(R.id.fragmentEmenta, frag3, "abc");
                    ft.addToBackStack("pilha");
                    ft.commit();
                }
                else if (position == 3) {
                    Ementa4Fragment frag4 = new Ementa4Fragment();
                    FragmentTransaction ft = fm.beginTransaction();
                    ft.replace(R.id.fragmentEmenta, frag4, "abc");
                    ft.addToBackStack("pilha");
                    ft.commit();
                }
                else if (position == 4) {
                    Ementa5Fragment frag = new Ementa5Fragment();
                    FragmentTransaction ft = fm.beginTransaction();
                    ft.replace(R.id.fragmentEmenta, frag, "abc");
                    ft.addToBackStack("pilha");
                    ft.commit();
                }
                else if (position == 5) {
                    Ementa6Fragment frag = new Ementa6Fragment();
                    FragmentTransaction ft = fm.beginTransaction();
                    ft.replace(R.id.fragmentEmenta, frag, "abc");
                    ft.addToBackStack("pilha");
                    ft.commit();
                }
                else if (position == 6) {
                    Ementa7Fragment frag = new Ementa7Fragment();
                    FragmentTransaction ft = fm.beginTransaction();
                    ft.replace(R.id.fragmentEmenta, frag, "abc");
                    ft.addToBackStack("pilha");
                    ft.commit();
                }
                else if (position == 7) {
                    Ementa8Fragment frag = new Ementa8Fragment();
                    FragmentTransaction ft = fm.beginTransaction();
                    ft.replace(R.id.fragmentEmenta, frag, "abc");
                    ft.addToBackStack("pilha");
                    ft.commit();
                }

            }
        });
    }

    @Override
    public void onBackPressed(){

        super.onBackPressed();
        Intent intent = new Intent(this, InicioActivity.class);
        startActivity(intent);
        overridePendingTransition(0, 0);
    }


}
