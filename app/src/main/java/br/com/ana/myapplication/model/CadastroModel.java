package br.com.ana.myapplication.model;

import java.util.List;

import br.com.ana.myapplication.controller.Crud;
import br.com.ana.myapplication.view.Cadastro;

public class CadastroModel implements Crud{

    private int id; ///chave primária do DB
    private String nome;
    private String cpf;
    private String altura;
    private String idade;
    private String peso;
    private boolean status;

    public String getNome() {return nome;}

    public void setNome(String nome) {this.nome = nome;}

    public String getCpf() {return cpf;}

    public void setCpf(String cpf) {this.cpf = cpf;}

    public String getAltura() {return altura;}

    public void setAltura(String altura) {this.altura = altura;}

    public String getIdadea() {return idade;}

    public void setIdade(String idade) {this.idade = altura;}

    public String getPeso() {return peso;}

    public void setPeso(String peso) {this.peso = peso;}

    public boolean isStatus() {return status;}

    public void setStatus(boolean status) {this.status = status;}

    public int getId() {return id;}

    public void setId(int id) {this.id = id;}

   // @Override
  //  public boolean incluir(Object obj) {
   //     return false;
   // }

    @Override
    public boolean alterar(Object obj) {
        return false;
    }

    @Override
    public boolean deletar(Object obj) {
        return false;
    }

    @Override
    public List<CadastroModel> listar() {
        return null;
    }
}
