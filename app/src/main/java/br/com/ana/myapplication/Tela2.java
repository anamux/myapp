package br.com.ana.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import org.json.JSONArray;
import org.json.JSONObject;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

import br.com.ana.myapplication.adapter.AdapterLista;
import br.com.ana.myapplication.databinding.ActivityTela2Binding;

public class Tela2 extends AppCompatActivity {


    Button bt_envia;
    private ActivityTela2Binding binding;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityTela2Binding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        SharedPreferences preferences = getSharedPreferences("my_prefs_data", MODE_PRIVATE);
        List<Cadastro> cadastros = new ArrayList<Cadastro>();



        Gson gson = new Gson();
        Type type = new TypeToken<List<Cadastro>>(){}.getType();
        String listaaluno = preferences.getString("listaalunos", "[]");

        cadastros = gson.fromJson(listaaluno, type);
/////////incrementar dados na lista array
   ArrayList<String> adapterList = new ArrayList<>();
        for (int i=0; i<cadastros.size(); i++){

          adapterList.add(cadastros.get(i) .toString());





        }






/////////////construção da ViewList

        binding.viewlist.setAdapter(new AdapterLista(this, android.R.layout.simple_list_item_1, adapterList ));

        bt_envia = (Button) findViewById(R.id.bt_envia);

        bt_envia.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Tela2.this, MainActivity.class);
                startActivity(intent);
                finish();
            }
        }

        );
    }
}

