package br.com.keemy.store.model;

import br.com.keemy.store.Global;

import java.math.BigDecimal;

public class Brinquedo extends Produto {
    private int idProduto;
    private int tipoBrinquedo;

    public Brinquedo(int idProduto, String nome, BigDecimal preco, int estoque, Global.CategoriaProduto categoria, int tipoBrinquedo) {
        super(idProduto, nome, preco, estoque, categoria);
        this.tipoBrinquedo = tipoBrinquedo;
        this.idProduto = idProduto;
    }


    public Brinquedo(Produto entradasProduto) {
        super(entradasProduto);
        this.tipoBrinquedo = ((Brinquedo)entradasProduto).getTipoBrinquedo();
        this.idProduto = ((Brinquedo)entradasProduto).getIdProduto();
    }

    public int getTipoBrinquedo() {
        return tipoBrinquedo;
    }

    public void setTipoBrinquedo(int tipoBrinquedo) {
        this.tipoBrinquedo = tipoBrinquedo;
    }

    public int getIdProduto() {
        return idProduto;
    }

    public void setIdProduto(int idProduto) {
        this.idProduto = idProduto;
    }

    @Override
    public String toString() {
        return super.toString() + " - Tipo Brinquedo: " + this.tipoBrinquedo;
    }
}
