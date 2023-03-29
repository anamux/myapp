package br.com.ana.myapplication.datasource;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import androidx.annotation.Nullable;

import br.com.ana.myapplication.core.AppUtil;
import br.com.ana.myapplication.datamodel.CadastroDataModel;

public class AppDataBase extends SQLiteOpenHelper {

    private static final String DB_NAME = "AppSistemaDeAcademia.sqlite";
    private static final int DB_VERSION = 1;

    SQLiteDatabase db;

    public AppDataBase(@Nullable Context context) {
        super(context, DB_NAME, null, DB_VERSION);

        Log.d(AppUtil.TAG, "AppDataBase: Criando Banco de Dados...");
        db=getWritableDatabase();
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

//efetivamente criando a tabela no banco de dados
        db.execSQL(CadastroDataModel.criarTabela());

        Log.d(AppUtil.TAG, "onCreate: tabela cadastro criada"+CadastroDataModel.criarTabela());

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) { }
        public void salvarObjeto (String tabela, ContentValues dadoDoObjeto){
            db.insert(tabela, null, dadoDoObjeto);
        }



}
