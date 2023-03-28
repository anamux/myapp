package br.com.ana.myapplication.core;

import android.widget.Toast;

import java.util.Calendar;

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

        String dia, mes, ano;
        String dataAtual = "28/03/2023";

        try {
            Calendar calendar = Calendar.getInstance();
            dia = String.valueOf(calendar.get(Calendar.DAY_OF_MONTH));
            mes = String.valueOf(calendar.get(Calendar.MONTH) + 1);
            ano = String.valueOf(calendar.get(Calendar.YEAR));

            dia = (Calendar.DAY_OF_MONTH < 10) ? "0"+ dia : dia;
            int mesAtual = (Calendar.MONTH) + 1;
            mes = (mesAtual < 10) ? "0" + mes : mes;

        } catch (Exception e) {

        }

        return dataAtual;
    }

    /**
     *
     * @return devolve a hora atual
     */
    public static String getHoraAtual(){

        String horaAtual = "00:00:00";
        String hora, minuto, segundo;

        try {
            Calendar calendar= Calendar.getInstance();
            int iHora= calendar.get(Calendar.HOUR_OF_DAY);
            int iMinuto=calendar.get(Calendar.MINUTE);
            int iSegundo=calendar.get(Calendar.SECOND);

            hora = (iHora<= 9) ? "0"+iHora : Integer.toString(iHora);
            minuto = (iMinuto<= 9) ? "0"+iMinuto : Integer.toString(iMinuto);
            segundo = (iSegundo<= 9) ? "0"+iSegundo : Integer.toString(iSegundo);

            horaAtual = hora+":"+minuto+":"+segundo;

        } catch (Exception e) {

        }

        return horaAtual;
    }

}


