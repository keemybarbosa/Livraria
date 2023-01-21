package br.com.keemy.store.dao.impl;

import br.com.keemy.store.Global;
import br.com.keemy.store.controller.ProdutoController;
import br.com.keemy.store.dao.produtoDao;
import br.com.keemy.store.model.Brinquedo;
import br.com.keemy.store.model.Produto;

import java.util.List;

public class BrinquedoImpl implements produtoDao {
    @Override
    public void cadastrar(Produto p) {
        Brinquedo brinquedo = new Brinquedo(p.getId(), p.getNome(), p.getPreco(), p.getEstoque(), p.isExcluido(), p.getCategoria(),
                ((Brinquedo)p).getTipoBrinquedo());

        Global.listaDeProdutos.add(brinquedo);
        Global.listaDeBrinquedos.add(brinquedo);
    }

    @Override
    public List<Produto> listar() {
        return null;
    }

    @Override
    public void atualizar(Produto p) {
        Brinquedo brinquedo = new Brinquedo(p.getId(), p.getNome(), p.getPreco(), p.getEstoque(), p.isExcluido(), p.getCategoria(),
                ((Brinquedo)p).getTipoBrinquedo());
        ProdutoController.alterarProduto(brinquedo);
    }

    @Override
    public void deletar(Produto p) {

    }
}
