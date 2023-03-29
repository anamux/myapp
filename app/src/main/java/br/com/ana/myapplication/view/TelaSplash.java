package br.com.ana.myapplication.view;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import br.com.ana.myapplication.R;
import br.com.ana.myapplication.core.AppUtil;
import br.com.ana.myapplication.databinding.ActivityTelaSplashBinding;

public class TelaSplash extends AppCompatActivity {

    int tempoDeEspera = 5000 * 1;
    TextView txtDataAtual;
    TextView txtHoraAtual;

    private ActivityTelaSplashBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityTelaSplashBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);

        binding.txtDataAtual.setText(AppUtil.getDataAtual());
        binding.txtHoraAtual.setText(AppUtil.getHoraAtual());

        trocarTela();
    }

    private void trocarTela() {
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {


                Log.d(AppUtil.TAG, "trocarTela: Aguardando carregamento de tela");

                ///classe Intent     objeto trocarDeTela
                Intent trocarDeTela = new Intent(TelaSplash.this, Tela2.class);
                startActivity(trocarDeTela);
                finish();
            }
        }, tempoDeEspera);
    }
}