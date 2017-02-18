package engcomp.smartclassufpa.View.Adapter;


import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import engcomp.smartclassufpa.View.Fragments.QuartaFragment;
import engcomp.smartclassufpa.View.Fragments.QuintaFragment;
import engcomp.smartclassufpa.View.Fragments.SegundaFragment;
import engcomp.smartclassufpa.View.Fragments.SextaFragment;
import engcomp.smartclassufpa.View.Fragments.TercaFragment;

/**
 * A simple {@link Fragment} subclass.
 */
public class TabAdapter extends FragmentPagerAdapter {
    private Context mContext;
    private String[] titles;

    public TabAdapter(FragmentManager fm, Context c, String[] titles) {
        super(fm);

        this.titles = titles;
        mContext = c;

    }
    @Override
    public Fragment getItem(int position) {
        Fragment frag = null;

        switch (position) {
            case 0: //Dia da semana: Segunda-feira
                frag = new SegundaFragment();
                break;
            case 1: //Dia da semana: Terça-feira
                frag = new TercaFragment();
                break;
            case 2: //Dia da semana: Quarta-feira
                frag = new QuartaFragment();
                break;
            case 3: //Dia da semana: Quinta-feira
                frag = new QuintaFragment();
                break;
            case 4: //Dia da semana: Sexta-feira
                frag = new SextaFragment();
                break;
            default:

        }

        Bundle b = new Bundle();
        b.putInt("position", position);

        frag.setArguments(b);

        return frag;
    }

    @Override
    public int getCount() {

        return titles.length;
    }


    @Override
    public CharSequence getPageTitle(int position){

        return (titles[position]);
    }

}
