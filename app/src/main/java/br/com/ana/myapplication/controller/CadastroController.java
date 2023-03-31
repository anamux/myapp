package br.com.ana.myapplication.controller;

import br.com.ana.myapplication.model.CadastroModel;
import io.realm.Realm;

public class CadastroController {
    public void insert(CadastroModel obj) {
        Realm realm = Realm.getDefaultInstance();
        Number primaryKey = realm.where(CadastroModel.class).max("id");

        final int autoIncrementPrimaryKey = (primaryKey == null) ? 1 : primaryKey.intValue() + 1;

        obj.setId(autoIncrementPrimaryKey);
        realm.beginTransaction();
        realm.copyToRealm(obj);
        realm.commitTransaction();
        realm.close();
    }
}