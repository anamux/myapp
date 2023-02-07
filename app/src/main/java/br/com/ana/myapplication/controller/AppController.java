package br.com.ana.myapplication.controller;

import android.util.Log;

import br.com.ana.myapplication.core.AppUtil;

public class AppController {

    String versaoApp;
    public AppController(){

    this.versaoApp = AppUtil.versaoDoAplicativo();

        Log.i(AppUtil.TAG, "AppController: Versão App: "+versaoApp);





    }
}
