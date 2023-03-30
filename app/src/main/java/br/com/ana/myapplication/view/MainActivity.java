package br.com.ana.myapplication.view;

import androidx.appcompat.app.AppCompatActivity;


import android.content.Intent;

import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.TextView;

import br.com.ana.myapplication.controller.CadastroController;
import br.com.ana.myapplication.core.AppUtil;
import br.com.ana.myapplication.databinding.ActivityMainBinding;
import br.com.ana.myapplication.model.CadastroModel;

public class MainActivity extends AppCompatActivity {

    //////////////Criando objetos
    EditText nome, cpf, idade, peso, altura;
    Switch switchStatus;
    CadastroController cadastroController;
    CadastroModel novoCadastro;
    Intent intent;

    private ActivityMainBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);


        Log.d(AppUtil.TAG, "onCreate: App DataBase");

        cadastroController = new CadastroController(getApplicationContext());

////////////Recupera o id do componente
        binding.editNomeCompleto.setText("");
        binding.editCpf.setText("");
        binding.editIdade.setText("");
        binding.editAltura.setText("");
        binding.editPeso.setText("");
        binding.switchStatus.setChecked(true);

        novoCadastro = new CadastroModel();
        cadastroController = new CadastroController(getApplicationContext());
        binding.btCadastar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

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