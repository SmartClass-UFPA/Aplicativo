package engcomp.smartclassufpa.View.Adapter;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;

import engcomp.smartclassufpa.View.Fragments.ProvFragment;
import engcomp.smartclassufpa.View.Fragments.TrabFragment;


/**
 * Created by alberto on 10/02/2017.
 */

public class TrabProvTabAdapter extends TabAdapter {
    private Context mContext;

    public TrabProvTabAdapter(FragmentManager fm, Context c, String[] title) {
        super(fm,c,title);

    }


    @Override
    public Fragment getItem(int position) {
        Fragment frag = null;

        switch (position) {
            case 0: //Dia da semana: Segunda-feira
                frag = new TrabFragment();
                break;
            case 1: //Dia da semana: Terça-feira
                frag = new ProvFragment();
                break;
            default:

        }

        Bundle b = new Bundle();
        b.putInt("position", position);

        frag.setArguments(b);

        return frag;
    }


}