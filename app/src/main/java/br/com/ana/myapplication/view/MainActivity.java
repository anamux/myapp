package br.com.ana.myapplication.view;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.snackbar.Snackbar;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

import br.com.ana.myapplication.R;
import br.com.ana.myapplication.controller.CadastroController;
import br.com.ana.myapplication.core.AppUtil;
import br.com.ana.myapplication.model.CadastroModel;

public class MainActivity extends AppCompatActivity {

    //////////////Criando objetos
    TextView textView3;
    private EditText nome, cpf, idade, altura, peso;
    Switch switchStatus;
    Button botaoCadastrar;

    CadastroController cadastroController;
    CadastroModel novoCadastro;
    Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Log.d(AppUtil.TAG, "onCreate: App DataBase");

        cadastroController = new CadastroController(getApplicationContext());

////////////Recupera o id do componente
        nome = findViewById(R.id.editNomeCompleto);
        cpf = findViewById(R.id.editCpf);
        idade = findViewById(R.id.editIdade);
        altura = findViewById(R.id.editAltura);
        peso = findViewById(R.id.editPeso);
        switchStatus = findViewById(R.id.switchStatus);

        botaoCadastrar = findViewById(R.id.bt_Cadastar);
        novoCadastro = new CadastroModel();
        cadastroController = new CadastroController(getApplicationContext());

//////////Metodo que definine evento de click
        botaoCadastrar.setOnClickListener(new View.OnClickListener() {
                                              @Override
                                              public void onClick(View v) {

                                                  boolean isDadosOk = true;

                                                  if (TextUtils.isEmpty(nome.getText())) {
                                                      isDadosOk = false;
                                                      nome.setError("Digite o Nome Completo");
                                                      nome.requestFocus();
                                                  }
                                                  if (TextUtils.isEmpty(cpf.getText())) {
                                                      isDadosOk = false;
                                                      cpf.setError("Digite o CPF");
                                                      cpf.requestFocus();
                                                  }
                                                  if (TextUtils.isEmpty(idade.getText())) {
                                                      isDadosOk = false;
                                                      idade.setError("Digite a idade");
                                                  }
                                                  if (TextUtils.isEmpty(altura.getText())) {
                                                      isDadosOk = false;
                                                      altura.setError("Digite a altura");
                                                      altura.requestFocus();
                                                  }
                                                  if (TextUtils.isEmpty(peso.getText())) {
                                                      isDadosOk = false;
                                                      peso.setError("Digite o peso");
                                                      peso.requestFocus();
                                                  }


                                                  if (isDadosOk) {
//popular os dados no obj Cadastro
                                                      novoCadastro.setNome(nome.getText().toString());
                                                      novoCadastro.setCpf(cpf.getText().toString());
                                                      novoCadastro.setIdade(idade.getText().toString());
                                                      novoCadastro.setPeso(peso.getText().toString());
                                                      novoCadastro.setAltura(altura.getText().toString());

                                                      novoCadastro.setStatus(switchStatus.isChecked());


                                                     cadastroController.incluir(novoCadastro);
                                                  } else {

                                                  }


                                              }
                                          }
        );


    }

    public void goToTela2(View view) {

        Intent intent = new Intent(MainActivity.this, Tela2.class);
        startActivity(intent);
        finish();

    }
}