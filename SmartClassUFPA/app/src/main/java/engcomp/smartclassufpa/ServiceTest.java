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

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

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
                            getJson("/localhost:3000/sala");
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

    /*
    *sendPost("/localhost:3000/itec/b2/","1");    POST do professor em sala
    * new android.os.Handler().postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            sendPost(("/localhost:3000/itec/b2/","0"); POST de que o professor saiu de sala
                        }
                    }, 600000);
    *
    */

    private void sendPost(String site, String value) throws Exception {

        String url = site;
        URL obj = new URL(url);
        HttpURLConnection con = (HttpURLConnection) obj.openConnection();

        //add reuqest header
        con.setRequestMethod("POST");

        String urlParameters = value;

        // Send post request
        con.setDoOutput(true);
        DataOutputStream wr = new DataOutputStream(con.getOutputStream());
        wr.writeBytes(urlParameters);
        wr.flush();
        wr.close();

        int responseCode = con.getResponseCode();
        System.out.println("\nSending 'POST' request to URL : " + url);
        System.out.println("Post parameters : " + urlParameters);
        System.out.println("Response Code : " + responseCode);

        BufferedReader in = new BufferedReader(
                new InputStreamReader(con.getInputStream()));
        String inputLine;
        StringBuffer response = new StringBuffer();

        while ((inputLine = in.readLine()) != null) {
            response.append(inputLine);
        }
        in.close();

        //print result
        System.out.println(response.toString());
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
                            getJson("/localhost:3000/sala");
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
                        String teacher = localizando(body.toString(), "prof_em_sala");

                        if(teacher.equals("1")){
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
