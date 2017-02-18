package engcomp.smartclassufpa.View.Adapter;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;

import engcomp.smartclassufpa.View.Fragments.ProvasFragment;
import engcomp.smartclassufpa.View.Fragments.TrabalhosFragment;

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
            case 0:
                frag = new ProvasFragment();
                break;
            case 1:
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
