package br.com.lidiaxp.smartclassufpa;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.AlertDialog;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.WindowManager;
import android.view.inputmethod.InputMethodManager;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class gallery extends ActionBarActivity {
    private WebView wv1;
    EditText ed1;
    private AlertDialog alerta;
    public  String cont;
    private AlertDialog alerta2;
    private SharedPreferences save;
    private SharedPreferences.Editor editor;
    private static int vez;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gallery);

        save = getSharedPreferences("save", Context.MODE_PRIVATE);
        cont = save.getString("cont", cont);
        vez = save.getInt("vez", vez);

        TextView tx = (TextView) findViewById(R.id.textView2);
        TextView tx1 = (TextView) findViewById(R.id.textView4);

        if(vez == 0){
            tx.setVisibility(View.VISIBLE);
            tx1.setVisibility(View.VISIBLE);
        }else{
            tx.setVisibility(View.GONE);
            tx1.setVisibility(View.GONE);
        }

        ed1=(EditText)findViewById(R.id.editText2);

        wv1=(WebView)findViewById(R.id.webView2);
        wv1.setWebViewClient(new MyBrowser());

        esconderTeclado();
    }

    @TargetApi(Build.VERSION_CODES.JELLY_BEAN)
    public void carregar(View view){
        String complemento = ed1.getText().toString();
        if(complemento.equals("")){
            complemento = "#";
        }
        String url = "https://www.dropbox.com/home/" + complemento;

        wv1.getSettings().setLoadsImagesAutomatically(true);
        wv1.getSettings().setJavaScriptEnabled(true);
        wv1.setScrollBarStyle(View.SCROLLBARS_INSIDE_OVERLAY);
        wv1.findAllAsync("Nome");
        wv1.setHttpAuthUsernamePassword(url, "", "toyuxuwuv@go2usa.info", "senhasupersecreta");

        wv1.loadUrl(url);
        vez = 1;
        Toast.makeText(gallery.this, "Aguarde enquanto carrega a tela", Toast.LENGTH_LONG).show();
        esconderTeclado();

    }

    private class MyBrowser extends WebViewClient {
        @Override
        public boolean shouldOverrideUrlLoading(WebView view, String url) {
            view.loadUrl(url);
            return true;
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_gallery, menu);

        MenuItem b1 = menu.findItem(R.id.search);

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.search) {
            dias();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    public void dias(){
        ArrayList<String> itens = new ArrayList<String>();
        itens.add("13-02-2017");
        itens.add("14-02-2017");
        itens.add("15-02-2017");
        itens.add("16-02-2017");
        itens.add("20-02-2017");
        itens.add("21-02-2017");
        itens.add("22-02-2017");
        itens.add("23-02-2017");

        ArrayAdapter adapter = new ArrayAdapter(this, R.layout.item_alerta, itens);

        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Em que dia você quer adicionar uma foto?");
        builder.setSingleChoiceItems(adapter, 0, new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface arg0, int arg1) {
                if (arg1 == 0) {
                    cont = "13-02-2017";
                } else if (arg1 == 1) {
                    cont = "14-02-2017";
                } else if (arg1 == 2) {
                    cont = "15-02-2017";
                } else if (arg1 == 3) {
                    cont = "16-02-2017";
                } else if (arg1 == 4) {
                    cont = "20-02-2017";
                } else if (arg1 == 5) {
                    cont = "21-02-2017";
                } else if (arg1 == 6) {
                    cont = "22-02-2017";
                } else if (arg1 == 7) {
                    cont = "23-02-2017";
                }
                materia();
            alerta.dismiss();
            }

        });

        alerta = builder.create();
        alerta.show();
    }

    public void materia(){
        ArrayList<String> itens = new ArrayList<String>();
        itens.add("Eletrônica analógica");
        itens.add("Sinais e sistemas");
        itens.add("Probabilidade e estátistica");
        itens.add("Redes de computadores 2");
        ArrayAdapter adapter = new ArrayAdapter(this, R.layout.item_alerta, itens);

        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Para qual matéria?");
        builder.setSingleChoiceItems(adapter, 0, new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface arg0, int arg2) {
                if(arg2 == 0){
                        cont += "/eletronica";
                }else if(arg2 == 1){
                        cont += "/sinais";
                } else if(arg2 == 2){
                        cont += "/probabilidade";
                }else if(arg2 == 3){
                        cont += "/redes";
                }
                Intent it = new Intent(gallery.this, Drop.class);
                Bundle bundle = new Bundle();
                bundle.putString("txt", cont);
                it.putExtras(bundle);
                startActivity(it);
                alerta2.dismiss();
            }
        });

        alerta2 = builder.create();
        alerta2.show();
    }

    public void esconderTeclado(){
        InputMethodManager imm = (InputMethodManager) getSystemService(INPUT_METHOD_SERVICE);
        imm.hideSoftInputFromWindow(ed1.getWindowToken(), 0);
        getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN);
    }

    @Override
    protected void onStop() {
        super.onStop();
        editor = save.edit();
        editor.putString("cont", cont);
        editor.putInt("vez", vez);
        editor.commit();
    }
}
