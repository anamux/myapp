package br.com.ana.myapplication.datamodel;

public class CadastroDataModel {

    //Modelo objeto relacional
    //1 criar atributo nome da tabela
    public static final String TABELA = "cadastro";
    //2 criar atributo para cada um dos nomes dos campos da tabela
    public static final String ID = "id";
    public static final String NOME = "nome";
    public static final String CPF = "cpf";
    public static final String ALTURA = "altura";
    public static final String PESO = "peso";
    //public static final boolean STATUS = "status";

    //3 cruar a query para criar o DB

    public static String queryCriarTabela = "";

    //4 metodo para gerar o Script para criar a tabela
    public static String criarTabela (){

        //Concatenação de String
        queryCriarTabela+= "CREATE TABLE " +TABELA+" (";
        queryCriarTabela+= ID+" integer primary key autoincrement, ";
        queryCriarTabela+= NOME+" text, ";
        queryCriarTabela+= CPF+" text, ";
        queryCriarTabela+= ALTURA+" text, ";
        queryCriarTabela+= PESO+" text";
        queryCriarTabela+= ")";

        return queryCriarTabela;
    }

}
