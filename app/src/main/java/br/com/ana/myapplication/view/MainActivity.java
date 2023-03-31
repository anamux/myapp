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

import br.com.ana.myapplication.controller.CadastroController;
import br.com.ana.myapplication.core.AppUtil;
import br.com.ana.myapplication.databinding.ActivityMainBinding;
import br.com.ana.myapplication.model.CadastroModel;

public class MainActivity extends AppCompatActivity {

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

        cadastroController = new CadastroController();

////////////Recupera o id do componente
        binding.editNomeCompleto.setText("");
        binding.editCpf.setText("");
        binding.editIdade.setText("");
        binding.editAltura.setText("");
        binding.editPeso.setText("");
        binding.switchStatus.setChecked(true);

        novoCadastro = new CadastroModel();
        cadastroController = new CadastroController();
        binding.btCadastar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                boolean isDadosOk = true;

                if (TextUtils.isEmpty(binding.editNomeCompleto.getText())) {
                    isDadosOk = false;
                    binding.editNomeCompleto.setError("Digite o Nome Completo");
                    binding.editNomeCompleto.requestFocus();
                }
                if (TextUtils.isEmpty(binding.editCpf.getText())) {
                    isDadosOk = false;
                    binding.editCpf.setError("Digite o CPF");
                    binding.editCpf.requestFocus();
                }
                if (TextUtils.isEmpty(binding.editIdade.getText())) {
                    isDadosOk = false;
                    binding.editIdade.setError("Digite a idade");
                    binding.editIdade.requestFocus();
                }
                if (TextUtils.isEmpty(binding.editAltura.getText())) {
                    isDadosOk = false;
                    binding.editAltura.setError("Digite a altura");
                    binding.editAltura.requestFocus();
                }
                if (TextUtils.isEmpty(binding.editPeso.getText())) {
                    isDadosOk = false;
                    binding.editPeso.setError("Digite o peso");
                    binding.editPeso.requestFocus();
                }


                if (isDadosOk) {
//popular os dados no obj Cadastro
                    novoCadastro.setNome(binding.editNomeCompleto.getText().toString());
                    novoCadastro.setCpf(binding.editCpf.getText().toString());
                    novoCadastro.setIdade(binding.editIdade.getText().toString());
                    novoCadastro.setPeso(binding.editPeso.getText().toString());
                    novoCadastro.setAltura(binding.editAltura.getText().toString());

                    novoCadastro.setStatus(binding.switchStatus.isChecked());


                    cadastroController.insert(novoCadastro);
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