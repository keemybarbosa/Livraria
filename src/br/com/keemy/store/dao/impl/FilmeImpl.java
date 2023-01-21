package br.com.keemy.store.dao.impl;

import br.com.keemy.store.Global;
import br.com.keemy.store.controller.ProdutoController;
import br.com.keemy.store.dao.produtoDao;
import br.com.keemy.store.model.Filme;
import br.com.keemy.store.model.Produto;

import java.util.List;

public class FilmeImpl implements produtoDao {
    @Override
    public void cadastrar(Produto p) {
        Filme filme = new Filme(p.getId(), p.getNome(), p.getPreco(), p.getEstoque(), p.isExcluido(), p.getCategoria(),
                ((Filme)p).getEstudio(), ((Filme)p).getDiretores(), ((Filme)p).getGeneros(), ((Filme)p).getProdutores());

        Global.listaDeProdutos.add(filme);
        Global.listaDeFilmes.add(filme);
    }

    @Override
    public List<Produto> listar() {
        return null;
    }

    @Override
    public void atualizar(Produto p) {
        Filme filme = new Filme(p.getId(), p.getNome(), p.getPreco(), p.getEstoque(), p.isExcluido(), p.getCategoria(),
                ((Filme)p).getEstudio(), ((Filme)p).getDiretores(), ((Filme)p).getGeneros(), ((Filme)p).getProdutores());
        ProdutoController.alterarProduto(filme);
    }

    @Override
    public void deletar(Produto p) {

    }
}
