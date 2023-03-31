package br.com.ana.myapplication.datasource;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;

import br.com.ana.myapplication.core.AppUtil;
import br.com.ana.myapplication.datamodel.CadastroDataModel;
import br.com.ana.myapplication.model.CadastroModel;

public class AppDataBase extends SQLiteOpenHelper {

    private static final String DB_NAME = "AppSistemaDeAcademia.sqlite";
    private static final int DB_VERSION = 1;

    SQLiteDatabase db;

    public AppDataBase(@Nullable Context context) {
        super(context, DB_NAME, null, DB_VERSION);

        Log.d(AppUtil.TAG, "AppDataBase: Criando Banco de Dados...");
        db = getWritableDatabase();
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

//efetivamente criando a tabela no banco de dados
        db.execSQL(CadastroDataModel.criarTabela());

        Log.d(AppUtil.TAG, "onCreate: tabela cadastro criada" + CadastroDataModel.criarTabela());

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
    }

    public void salvarObjeto(String tabela, ContentValues dadoDoObjeto) {
        db.insert(tabela, null, dadoDoObjeto);
    }

    public boolean insert(String tabela, CadastroModel dados) {

        ContentValues values = new ContentValues();

        values.put("nome", dados.getNome());
        values.put("cpf", dados.getCpf());
        values.put("altura", dados.getAltura());
        values.put("idade", dados.getIdade());
        values.put("peso", dados.getPeso());
        values.put("status", dados.isStatus());

        return db.insert(tabela, null, values) > 0;
    }
    public boolean update (String tabela, CadastroModel dados){
        int id = dados.getId();

        ContentValues values = new ContentValues();
        values.put("nome", dados.getNome());
        values.put("cpf", dados.getCpf());
        values.put("altura", dados.getAltura());
        values.put("idade", dados.getIdade());
        values.put("peso", dados.getPeso());
        values.put("status", dados.isStatus());

        return db.update(tabela, values, "id=?",
                new String[]{Integer.toString(id)}) >0;

    }
    public boolean delete (String tabela, int id){

        return db.delete(tabela, "id=?", new String[]{Integer.toString(id)}) >0;
    }

    public List<CadastroModel> select(String tabela){

        List<CadastroModel> retorno = new ArrayList<>();
        Cursor cursor;
        CadastroModel cadastroModel;
        String sqlDeConsulta = "SELECT * FROM" + tabela;
        cursor = db.rawQuery(sqlDeConsulta, null);

        if (cursor.moveToFirst()){

            do {
                cadastroModel = new CadastroModel();

                cadastroModel.setId(cursor.getInt(cursor.getColumnIndex("id")));
                cadastroModel.setNome(cursor.getString(cursor.getColumnIndex("nome")));
                cadastroModel.setCpf(cursor.getString(cursor.getColumnIndex("cpf")));
                cadastroModel.setAltura(cursor.getString(cursor.getColumnIndex("altura")));
                cadastroModel.setPeso(cursor.getString(cursor.getColumnIndex("peso")));

                int status = cursor.getInt(cursor.getColumnIndex("status"));

                if (status == 0){
                    cadastroModel.setStatus(false);
                }else {
                    cadastroModel.setStatus(true);
                }
                retorno.add(cadastroModel);

            }while (cursor.moveToNext());

        }
        cursor.close();
        return retorno;
    }

}
