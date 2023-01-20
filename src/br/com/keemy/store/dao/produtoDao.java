package br.com.keemy.store.dao;

import br.com.keemy.store.model.Produto;

import java.util.List;

public interface produtoDao {
    public void cadastrar(Produto p);
    public List<Produto> listar();
    public void atualizar(Produto p);
    public void deletar(Produto p);
}
