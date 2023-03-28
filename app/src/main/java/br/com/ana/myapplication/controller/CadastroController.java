package br.com.ana.myapplication.controller;

import android.content.ContentValues;
import android.content.Context;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

import br.com.ana.myapplication.core.AppUtil;
import br.com.ana.myapplication.datamodel.CadastroDataModel;
import br.com.ana.myapplication.datasource.AppDataBase;
import br.com.ana.myapplication.model.CadastroModel;

public class CadastroController extends AppDataBase implements Crud<CadastroModel>{

    ContentValues dadoDoObj;
    public CadastroController(Context context) {
        super(context);

        Log.d(AppUtil.TAG, "CadastroController: Conectado");
    }

    public void incluir(CadastroModel obj) {

        dadoDoObj = new ContentValues();
        dadoDoObj.put(CadastroDataModel.NOME,obj.getNome());
        dadoDoObj.put(CadastroDataModel.ALTURA,obj.getAltura());
        dadoDoObj.put(CadastroDataModel.CPF,obj.getCpf());
        dadoDoObj.put(CadastroDataModel.PESO,obj.getPeso());
        dadoDoObj.put(String.valueOf(CadastroDataModel.STATUS),obj.isStatus());

        salvarObjeto("cadastro", dadoDoObj);



        //return insert(CadastroDataModel.TABELA, dadoDoObj);
    }
    @Override
    public boolean alterar(CadastroModel obj) {
        dadoDoObj = new ContentValues();
        dadoDoObj.put(CadastroDataModel.ID,obj.getId());
        dadoDoObj.put(CadastroDataModel.NOME,obj.getNome());
        dadoDoObj.put(CadastroDataModel.ALTURA,obj.getAltura());
        dadoDoObj.put(CadastroDataModel.CPF,obj.getCpf());
        dadoDoObj.put(CadastroDataModel.PESO,obj.getPeso());
        // dadoDoObj.put(CadastroDataModel.STATUS,obj.getStatus());

        return false;
    }

    @Override
    public boolean deletar(CadastroModel obj) {

        dadoDoObj = new ContentValues();
        dadoDoObj.put(CadastroDataModel.ID,obj.getId());
              return false;
    }

    @Override
    public List<CadastroModel> listar() {
        List<CadastroModel> lista = new ArrayList<>();
        return lista;
    }
}
