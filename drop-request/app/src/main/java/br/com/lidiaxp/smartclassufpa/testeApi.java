package br.com.lidiaxp.smartclassufpa;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class testeApi extends AppCompatActivity {
    TextView t;
    private Thread thread;
    String ip;
    String conte;
/*
 * os metodos sendDelete, sendPost e sendGet sao metodos do HttpUrlConnection para os mesmos
 * o metodo localizando ja não é mais necessário pois e uma api específica e não geral
 * getJson também pode ser usado como request get
 * o metodo que ta em comentario e um post mais especifico, acho q nao vai precisar, mas ne...
 * localizando vc passa como parametro o response a flag do valor que quer pegar
 * sendGet voce envia a url e retorna uma string com o valor
 * sendDelete apenas deleta a url do BD
 * sendPost voce envia a url e o novo valor que quer para la
 * cuidado na localizaçao dos '/' se nao pode acabar atualizando coisa errada
 * nao to achando o site que explica as "/" mas se nao me engano é
 * sempre termina url com / e nunca começa value com /
*/

//------------------------------------------------------------------------------------------------------
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_teste_api);
        t = (TextView) findViewById(R.id.textView);
        String url = "http://jsonip.com/";
        getJson(url);

        testeApi http = new testeApi();
        try {
            String resposta = http.sendGet("url");
        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            http.sendPost("url", "value");
        } catch (Exception e) {
            e.printStackTrace();
        }
        http.sendDelete("url");

        /*OkHttp handler = new OkHttp("ola", "senha");
        String result = null;
        try{
            result = handler.execute(url).get();
            Toast.makeText(testeApi.this, "" + result.toString(), Toast.LENGTH_SHORT).show();
        }catch (ExecutionException e){
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        new android.os.Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Toast.makeText(testeApi.this, ""+conte, Toast.LENGTH_SHORT).show();
            }
        }, 5000);*/
    }
    //--------------------------------------------------------------------------------------------------
    public void sendDelete(String site){
        URL url = null;
        try {
            url = new URL(site);
        } catch (MalformedURLException exception) {
            exception.printStackTrace();
        }
        HttpURLConnection httpURLConnection = null;
        try {
            httpURLConnection = (HttpURLConnection) url.openConnection();
            httpURLConnection.setRequestProperty("Content-Type",
                    "application/x-www-form-urlencoded");
            httpURLConnection.setRequestMethod("DELETE");
            System.out.println(httpURLConnection.getResponseCode());
        } catch (IOException exception) {
            exception.printStackTrace();
        } finally {
            if (httpURLConnection != null) {
                httpURLConnection.disconnect();
            }
        }
    }
    //---------------------------------------------------------------------------------------------------
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
    //--------------------------------------------------------------------------------
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
    //---------------------------------------------------------------------------------
    public String sendGet(String site) throws Exception {

        String url = site;

        URL obj = new URL(url);
        HttpURLConnection con = (HttpURLConnection) obj.openConnection();

        // optional default is GET
        con.setRequestMethod("GET");

        int responseCode = con.getResponseCode();
        System.out.println("\nSending 'GET' request to URL : " + url);
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
        return response.toString();

    }
//------------------------------------------------------------------------------------------------------------
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
                        ip = localizando(body.toString(), "ip");
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            t.setText(ip);
                        }
                    });
                }
           }
        }).start();
    }
//---------------------------------------------------------------------------
/*private class OkHttp extends AsyncTask<String, Void, String>{

    OkHttpClient client = new OkHttpClient();
    String userName, pass;
    public OkHttp(String userName, String pass){
        this.userName = userName;
        this.pass = pass;
    }
    @Override
    protected String doInBackground(String... params) {
        RequestBody body = new FormEncodingBuilder()
                .add("name", userName)
                .add("pass", pass).build();
        Request request = new Request.Builder()
                .url("http://jsonip.com/").post(body).build();
        conte = request.toString();
        try{
            Response response = client.newCall(request).execute();
           conte += response.toString();
            if (!response.isSuccessful())
                throw new IOException("Unexpected code" + response.toString());
            return response.body().string();
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }
}*/
}
