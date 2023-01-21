package br.com.keemy.store.dao.impl;

import br.com.keemy.store.Global;
import br.com.keemy.store.controller.ProdutoController;
import br.com.keemy.store.dao.produtoDao;
import br.com.keemy.store.model.Album;
import br.com.keemy.store.model.Produto;

import java.util.List;

public class AlbumImpl implements produtoDao {

    @Override
    public void cadastrar(Produto p) {
        Album album = new Album(p.getId(), p.getNome(), p.getPreco(), p.getEstoque(), p.isExcluido(), p.getCategoria(),
                ((Album)p).getMusicosBandas(), ((Album)p).getGeneros(), ((Album)p).getSelos());

        Global.listaDeProdutos.add(album);

    }

    @Override
    public List<Produto> listar() {
        return null;
    }

    @Override
    public void atualizar(Produto p) {
        Album album = new Album(p.getId(), p.getNome(), p.getPreco(), p.getEstoque(), p.isExcluido(),p.getCategoria(),
                ((Album)p).getMusicosBandas(), ((Album)p).getGeneros(), ((Album)p).getSelos());
        ProdutoController.alterarProduto(album);
    }

    @Override
    public void deletar(Produto p) {

    }
}
