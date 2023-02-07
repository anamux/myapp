package br.com.ana.myapplication.view;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;

import br.com.ana.myapplication.R;
import br.com.ana.myapplication.core.AppUtil;

public class TelaSplash extends AppCompatActivity {

    int tempoDeEspera = 1000 *1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_splash);




        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {


                Log.d(AppUtil.TAG, "trocarTela: Aguardando carregamento de tela");

                ///classe Intent     objeto trocarDeTela
                Intent trocarDeTela = new Intent(TelaSplash.this, MainActivity.class);


                startActivity(trocarDeTela);
                finish();
            }
        }, tempoDeEspera);
    }
}