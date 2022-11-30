package br.com.ana.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.TextView;

import com.google.android.material.snackbar.Snackbar;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.AbstractList;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

//////////////Criando objetos
    TextView textView3;
    private EditText nome,cpf,idade,altura,peso;
    private Switch status;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView3 = (TextView)findViewById(R.id.textView3);
        String valor = getIntent().getStringExtra("chave");
        textView3.setText(valor);


////////////Recupera o id do componente
        nome = findViewById(R.id.editNomeCompleto);
        cpf = findViewById(R.id.editCpf);
        idade = findViewById(R.id.editIdade);
        altura = findViewById(R.id.editAltura);
        peso = findViewById(R.id.editPeso);
        status = findViewById(R.id.switchStatus);

        Button botaoCadastrar = findViewById(R.id.bt_Cadastar);

//////////Metodo que definine evento de click
       botaoCadastrar.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {

////////////transformando objeto em String
               String editNome = nome. getText().toString();
               String editCpf = cpf. getText().toString();
               String editIdade = idade. getText().toString();
               String editAltura = altura. getText().toString();
               String editPeso = peso. getText().toString();
               Boolean editStatus = status.isChecked();


               ///pegar os dados e salvar no shared preferences
               SharedPreferences preferences = getSharedPreferences("my_prefs_data", MODE_PRIVATE);
               List<Cadastro> cadastros = new ArrayList<Cadastro>();



               Gson gson = new Gson();
               Type type = new TypeToken<List<Cadastro>>(){}.getType();
               String listaaluno = preferences.getString("listaalunos", "[]");

               cadastros = gson.fromJson(listaaluno, type);
               Cadastro usuarioObject = new Cadastro(editNome, editCpf, editAltura, editPeso, editStatus);
               cadastros.add(usuarioObject);

               String listaconvertida = gson.toJson(cadastros);
               SharedPreferences.Editor editor = preferences.edit();
               editor.putString("listaalunos", listaconvertida);
               editor.apply();





               if (editNome. isEmpty() || editCpf.isEmpty() || editIdade.isEmpty() ||
                       editAltura.isEmpty() || editPeso.isEmpty() ){
                   Snackbar.make(v, "Preencha os dados solicitados", Snackbar.LENGTH_SHORT). show();
               }else {
                      SwitchStatusSelecionado(v);
               }


           }
       }

       );
    }
    private void SwitchStatusSelecionado(View view){

        if(status.isChecked()){
            Snackbar.make(view, "Cadastro realizado com sucesso", Snackbar.LENGTH_SHORT). show();
        }else {
            Snackbar.make(view, "Status inativo", Snackbar.LENGTH_SHORT). show();
        }

        Cadastro aluno = new Cadastro(nome.getText().toString(), cpf.getText().toString(), altura.getText().toString(), peso.getText().toString(), status.isChecked());


        Intent intent = new Intent(MainActivity.this, Tela2.class);
        intent.putExtra("chave", aluno);
        startActivity(intent);
        finish();




    }



}

