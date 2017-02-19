package br.com.lidiaxp.smartclassufpa;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import java.io.File;

public class Main extends AppCompatActivity {
    private static final int CAPTURAR_IMAGEM = 1;
    private Uri uri;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void startService(View view) {
        startService(new Intent(getBaseContext(), ServiceTest.class));
    }

    public void stopService(View view) {
        stopService(new Intent(getBaseContext(), ServiceTest.class));
    }

    public void capturarImagem(View v){
        boolean temCamera = getPackageManager().hasSystemFeature(PackageManager.FEATURE_CAMERA);

        if(temCamera){
            File diretorio = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES);

            String nomeImagem = diretorio.getPath() + "/" + System.currentTimeMillis() + ".jpg";

            uri = Uri.fromFile(new File(nomeImagem));
            Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
            intent.putExtra(MediaStore.EXTRA_OUTPUT, uri);

            startActivityForResult(intent, CAPTURAR_IMAGEM);
        }
    }

    public void testeAPI(View view){
        startActivity(new Intent(this, testeApi.class));
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == CAPTURAR_IMAGEM) {
            if (resultCode == RESULT_OK) {
                //adicionarNaGaleria();
            }
        }
    }

    public void dropbox(View view){
        Intent i = new Intent(this, gallery.class);
        startActivity(i);

    }
}
