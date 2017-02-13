package engcomp.smartclassufpa.Adapter;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;

import engcomp.smartclassufpa.Fragment.ProvasFragment;
import engcomp.smartclassufpa.Fragment.QuartaFragment;
import engcomp.smartclassufpa.Fragment.QuintaFragment;
import engcomp.smartclassufpa.Fragment.SegundaFragment;
import engcomp.smartclassufpa.Fragment.SextaFragment;
import engcomp.smartclassufpa.Fragment.TercaFragment;
import engcomp.smartclassufpa.Fragment.TrabalhosFragment;

/**
 * Created by TI-02 on 13/02/2017.
 */

public class ProvasTrabalhosTabAdapter extends TabAdapter {



    public ProvasTrabalhosTabAdapter(FragmentManager fm, Context c, String[] titles) {
        super(fm, c, titles);
    }

    @Override
    public Fragment getItem(int position) {

        Fragment frag = null;

        switch (position) {
            case 0: //Dia da semana: Segunda-feira
                frag = new ProvasFragment();
                break;
            case 1: //Dia da semana: Terça-feira
                frag = new TrabalhosFragment();
                break;
            default:

        }

        Bundle b = new Bundle();
        b.putInt("position", position);

        frag.setArguments(b);

        return frag;

    }
}
