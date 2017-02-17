package engcomp.smartclassufpa.Interfaces;

import android.content.res.Configuration;
import android.os.Build;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.widget.FrameLayout;
import android.widget.ListView;
import android.widget.Toolbar;

import engcomp.smartclassufpa.Adapter.ListViewHorarioAdapter;
import engcomp.smartclassufpa.Adapter.TabAdapter;
import engcomp.smartclassufpa.R;
import engcomp.smartclassufpa.extras.Horario;
import engcomp.smartclassufpa.extras.SlidingTabLayout;

public class HorariosActivity extends BaseActivity {
    private ViewPager mviewPager;
    private SlidingTabLayout mSlidingTabLayout;
    private Toolbar mToolbar;
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

        //
        tabAdapter = new TabAdapter(getSupportFragmentManager(), this);


        // Get the ViewPager and set it's PagerAdapter so that is can display items
        mviewPager = (ViewPager) findViewById(R.id.vp_tabs);
        mviewPager.setAdapter(tabAdapter);

        // Give the SlidingTabLayout the ViewPager
        mSlidingTabLayout = (SlidingTabLayout) findViewById(R.id.stl_tabs);
        mSlidingTabLayout.setViewPager(mviewPager);
        mSlidingTabLayout.setBackground(getResources().getColor(R.color.colorPrimaryDark));
        mSlidingTabLayout.setSelectedIndicatorColors(getResources().getColor(android.R.color.white));
        //mSlidingTabLayout.setCustomFocusedColor(getResources().getColor(R.color.tabTextSelected));
        //mSlidingTabLayout.setCustomUnfocusedColor(getResources().getColor(R.color.tabTextSelected));
        mSlidingTabLayout.setCustomTabView(R.layout.tab_view, R.id.tv_tab);
        mSlidingTabLayout.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {}
            @Override
            public void onPageSelected(int position) {

            }
            @Override
            public void onPageScrollStateChanged(int state) {}
        });


        mSlidingTabLayout.setViewPager(mviewPager);
        //mSlidingTabLayout.setHorizontalFadingEdgeEnabled(true);
        //mSlidingTabLayout.setHorizontalScrollBarEnabled(true);
        //mSlidingTabLayout

        //





    }
}

