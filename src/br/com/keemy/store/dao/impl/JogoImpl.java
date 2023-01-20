package br.com.keemy.store.dao.impl;

import br.com.keemy.store.Global;
import br.com.keemy.store.controller.ProdutoController;
import br.com.keemy.store.dao.produtoDao;
import br.com.keemy.store.model.Jogo;
import br.com.keemy.store.model.Produto;

import java.util.List;

public class JogoImpl implements produtoDao {
    @Override
    public void cadastrar(Produto p) {
        Jogo jogo = new Jogo(p.getId(), p.getNome(), p.getPreco(), p.getEstoque(), p.getCategoria(),
                ((Jogo)p).getDistribuidora(), ((Jogo)p).getGêneros(), ((Jogo)p).getEstúdio());

        Global.listaDeProdutos.add(jogo);
        Global.listaDeJogos.add(jogo);
    }

    @Override
    public List<Produto> listar() {
        return null;
    }

    @Override
    public void atualizar(Produto p) {
        Jogo jogo = new Jogo(p.getId(), p.getNome(), p.getPreco(), p.getEstoque(), p.getCategoria(),
                ((Jogo)p).getDistribuidora(), ((Jogo)p).getGêneros(), ((Jogo)p).getEstúdio());
        ProdutoController.alterarProduto(jogo);
    }

    @Override
    public void deletar(Produto p) {

    }
}
