package br.com.keemy.store.model;

import br.com.keemy.store.Global;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class Jogo extends Produto{
    private int idProduto;
    private String distribuidora;
    private List<String> generos = new ArrayList<String>();
    private String estudio;

    public Jogo(int idProduto, String nome, BigDecimal preco, int estoque, Global.CategoriaProduto categoria,
                String distribuidora, List<String> generos, String estudio) {
        super(idProduto, nome, preco, estoque, categoria);
        this.distribuidora = distribuidora;
        this.generos = generos;
        this.estudio = estudio;
        this.idProduto = idProduto;
    }

    public Jogo(Produto entradasProduto) {

        super(entradasProduto);
        this.distribuidora = ((Jogo)entradasProduto).getDistribuidora();
        this.generos = ((Jogo)entradasProduto).getGêneros();
        this.estudio = ((Jogo)entradasProduto).getEstúdio();
        this.idProduto = ((Jogo)entradasProduto).getIdProduto();
    }

    public String getDistribuidora() {
        return distribuidora;
    }

    public void setDistribuidora(String distribuidora) {
        this.distribuidora = distribuidora;
    }

    public List<String> getGêneros() {
        return generos;
    }

    public void setGeneros(List<String> generos) {
        this.generos = generos;
    }

    public String getEstúdio() {
        return estudio;
    }

    public void setEstudio(String estudio) {
        this.estudio = estudio;
    }

    public int getIdProduto() {
        return idProduto;
    }

    public void setIdProduto(int idProduto) {
        this.idProduto = idProduto;
    }

    @Override
    public String toString() {
        return super.toString() + " - Distribuidora: " + this.distribuidora + " - Gêneros: " + this.generos + " - Estúdio: " + this.estudio;
    }

}
