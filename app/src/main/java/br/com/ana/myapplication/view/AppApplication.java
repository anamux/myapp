package br.com.ana.myapplication.view;

import static br.com.ana.myapplication.core.AppUtil.TAG;

import android.app.Application;
import android.util.Log;

import io.realm.Realm;
import io.realm.RealmConfiguration;

public class AppApplication extends Application {

    private static final String DB_NAME = "AppSistemaDeAcademia.realm";
    private static final int DB_VERSION = 1;

    @Override
    public void onCreate() {
        super.onCreate();

        Realm.init(this);

        RealmConfiguration config = new RealmConfiguration.Builder()
                .name(DB_NAME)
                .schemaVersion(DB_VERSION)
                .allowWritesOnUiThread(true)
                .build();
        
        Realm realm = Realm.getInstance(config);

        Log.d(TAG, "onCreate: Realm criado com sucesso: "+DB_NAME+" versão: "+DB_VERSION);
    }
}
