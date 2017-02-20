package br.com.lidiaxp.smartclassufpa;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

/**
 * Created by Lidiaxp on 28/01/2017.
 */
public class BroadCastTest extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        context.startService(new Intent(context, ServiceTest.class));
    }
}
