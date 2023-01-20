package br.com.keemy.store.controller;

import br.com.keemy.store.Global;
import br.com.keemy.store.model.Produto;

import java.util.List;

public final class ProdutoController {

    public static Produto getProdutoById(int id){
        Produto retorno = null;
        List<Produto> produtos = Global.listaDeProdutos.stream()
                .filter(p -> p.getId() == id).toList();

        if (produtos.size() > 0)
            retorno = produtos.get(0);

        return retorno;
    }

    public static int getIndexById(int id){
        int retorno = -1;
        for (int i = 0; i < Global.listaDeProdutos.size(); i++) {
            if(Global.listaDeProdutos.get(i).getId() == id){
                retorno = i;
                continue;
            }
        }
        return retorno;
    }

    public static boolean alterarProduto(Produto produto){
        int indice = getIndexById(produto.getId());
        boolean retorno = false;
        if (indice != -1) {
            Global.listaDeProdutos.set(indice,produto);
            retorno = true;
        }
        return retorno;
    }

}
