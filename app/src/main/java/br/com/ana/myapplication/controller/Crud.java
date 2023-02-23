package br.com.ana.myapplication.controller;

import java.util.List;

import br.com.ana.myapplication.model.CadastroModel;

public interface Crud <T>{

    public boolean incluir (T obj);

    public boolean alterar (T obj);

    public boolean deletar (T obj);

    public List<CadastroModel> listar();
}
