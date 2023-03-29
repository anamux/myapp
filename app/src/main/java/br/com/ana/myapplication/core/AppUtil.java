package br.com.ana.myapplication.core;

import android.widget.Toast;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class AppUtil {

    ///buscador de versão

    public final static String TAG = "Sistema de Academia";

    public static String versaoDoAplicativo(){

        return "Versão 1.1";
    }

    /**
     *
     * @return devolve a data atual.
     */
    public static String getDataAtual(){
        String dataAtual= "00/00/00";

        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        Date data = new Date();

        dataAtual = dateFormat.format(data);

        return dataAtual;
    }

    /**
     *
     * @return devolve a hora atual
     */
    public static String getHoraAtual(){
        String horaAtual= "00/00/00";

        DateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");
        Date data = new Date();

        horaAtual = dateFormat.format(data);


        return horaAtual;
    }

}


