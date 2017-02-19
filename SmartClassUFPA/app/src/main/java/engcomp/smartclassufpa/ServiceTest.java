package br.com.lidiaxp.smartclassufpa;

import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import android.support.v7.app.NotificationCompat;

import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;

import java.io.IOException;

public class ServiceTest extends Service {
    int mStartMode;
    IBinder mBinder;
    boolean mAllowRebind;

    @Override
    public void onCreate() {
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                for(int x = 0; x < 10; x++){
                    new android.os.Handler().postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            getJson("/localhost/botaoprofessor");
                        }
                    }, 50000);
                    if(x == 8){
                        x = 0;
                    }
                }
            }
        });
        thread.start();
        thread.start();
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                for(int x = 0; x < 10; x++){
                    new android.os.Handler().postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            getJson("/localhost/botaoprofessor");
                        }
                    }, 50000);
                    if(x == 8){
                        x = 0;
                    }
                }
            }
        });
        thread.start();
        return (super.onStartCommand(intent, flags, startId));
    }

    @Override
    public IBinder onBind(Intent intent) {
        return mBinder;
    }

    @Override
    public boolean onUnbind(Intent intent) {
        return mAllowRebind;
    }

    @Override
    public void onRebind(Intent intent) {

    }

    @Override
    public void onDestroy() {
        super.onDestroy();
    }

    public void vibrar(Context context){
        NotificationManager nm = (NotificationManager) context.getSystemService(context.NOTIFICATION_SERVICE);
        PendingIntent p = PendingIntent.getActivity(context, 0, new Intent(context, Main.class) ,0);

        NotificationCompat.Builder builder = new NotificationCompat.Builder(context);
        builder.setTicker("");
        builder.setContentTitle("SmartClass");
        builder.setContentIntent(p);
        builder.setContentText("Professor está em sala");
        builder.setSmallIcon(R.drawable.prof);

        android.app.Notification n = builder.build();
        n.vibrate = new long[]{150,1500,100,2000};
        n.flags = android.app.Notification.FLAG_AUTO_CANCEL;
        nm.notify(R.drawable.prof, n);
    }

    private void getJson(final String url) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                OkHttpClient client = new OkHttpClient();
                Request request = new Request.Builder()
                        .url(url)
                        .build();
                Response response = null;

                try {
                    response = client.newCall(request).execute();
                } catch (IOException e) {
                    e.printStackTrace();
                }

                if (response.code() != 200) {
                } else {
                    try {
                        String body = response.body().string();
                        //String teacher = localizando(body.toString(), "professor");

                        if(/*teacher*/body.equals("True")){
                            vibrar(getBaseContext());
                        }
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        }).start();
    }

    public String localizando(String body, String achar){
        int num = 0;
        String agora1 = body.replace(",",":");
        String agora = agora1.replace("}",":");
        String palavras[] = agora.split(":");
        for(int a = 0; a < palavras.length; a++){
            String teste = palavras[a].substring(1, palavras[a].length()-1);
            if(teste.equals(achar)){
                num = a;
            }
        }
        String resposta = palavras[num + 1].substring(1, palavras[num + 1].length() - 1);
        return resposta;
    }

    class Worker extends Thread{
        private int count = 0;
        private int startId;
        private boolean ativo = true;

        public Worker(int startId){
            this.startId = startId;
        }

        public void run() {
            while (ativo && count < 10){
                try {
                    Thread.sleep(1000);
                }catch(InterruptedException e){
                    e.printStackTrace();
                }
                count++;
            }
            stopSelf(startId);
        }
    }
}
