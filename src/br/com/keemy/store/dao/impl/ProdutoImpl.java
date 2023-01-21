package br.com.keemy.store.dao.impl;

import br.com.keemy.store.Global;
import br.com.keemy.store.dao.produtoDao;
import br.com.keemy.store.model.Produto;

import java.util.List;

import static br.com.keemy.store.Global.listaDeProdutos;

public class ProdutoImpl implements produtoDao {

    @Override
    public void cadastrar(Produto p) {
        System.out.println("Não implementado!");
    }

    @Override
    public List<Produto> listar() {
        return Global.listaDeProdutos;
    }

    @Override
    public void atualizar(Produto p) {
        System.out.println("Não implementado!");
    }

    @Override
    public void deletar(Produto p) {
        Global.listaDeProdutos.stream().filter(item -> item.getId() == p.getId()).findAny()
                .map(item -> {
                    item.setEstoque(0);
                    item.setExcluido(true);
                    return item;
                });
    }
}
