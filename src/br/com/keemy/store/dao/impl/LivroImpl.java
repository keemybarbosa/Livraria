package br.com.keemy.store.dao.impl;

import br.com.keemy.store.Global;
import br.com.keemy.store.controller.ProdutoController;
import br.com.keemy.store.dao.produtoDao;
import br.com.keemy.store.model.Livro;
import br.com.keemy.store.model.Produto;

import java.util.List;

public class LivroImpl implements produtoDao {
    @Override
    public void cadastrar(Produto p) {
        Livro livro = new Livro(p.getId(), p.getNome(), p.getPreco(), p.getEstoque(), p.isExcluido(), p.getCategoria(),
                ((Livro)p).getGeneros(), ((Livro)p).getEscritor(), ((Livro)p).getEditora());

        Global.listaDeProdutos.add(livro);
    }

    @Override
    public List<Produto> listar() {
        return null;
    }

    @Override
    public void atualizar(Produto p) {
        Livro livro = new Livro(p.getId(), p.getNome(), p.getPreco(), p.getEstoque(), p.isExcluido(), p.getCategoria(),
                ((Livro)p).getGeneros(), ((Livro)p).getEscritor(), ((Livro)p).getEditora());
        ProdutoController.alterarProduto(livro);
    }

    @Override
    public void deletar(Produto p) {

    }
}
