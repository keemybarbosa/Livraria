package br.com.keemy.store.model;

import br.com.keemy.store.Global;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class Filme extends Produto{

    private int idProduto;
    private String estudio;
    private List<String> diretores = new ArrayList<String>();
    private List<String> generos = new ArrayList<String>();
    private List<String> produtores = new ArrayList<String>();

    public Filme(int idProduto, String nome, BigDecimal preco, int estoque, Global.CategoriaProduto categoria,
                 String estudio, List<String> diretores, List<String> generos, List<String> produtores) {
        super(idProduto, nome, preco, estoque, categoria);
        this.estudio = estudio;
        this.diretores = diretores;
        this.generos = generos;
        this.produtores = produtores;
        this.idProduto = idProduto;
    }

    public Filme(Produto entradasProduto) {
        super(entradasProduto);
        this.estudio = ((Filme)entradasProduto).getEstudio();
        this.diretores = ((Filme)entradasProduto).getDiretores();
        this.generos = ((Filme)entradasProduto).getGeneros();
        this.produtores = ((Filme)entradasProduto).getProdutores();
        this.idProduto = ((Filme)entradasProduto).getIdProduto();
    }

    public String getEstudio() {
        return estudio;
    }

    public void setEstudio(String estudio) {
        this.estudio = estudio;
    }

    public List<String> getDiretores() {
        return diretores;
    }

    public void setDiretores(List<String> diretores) {
        this.diretores = diretores;
    }

    public List<String> getGeneros() {
        return generos;
    }

    public void setGeneros(List<String> generos) {
        this.generos = generos;
    }

    public List<String> getProdutores() {
        return produtores;
    }

    public void setProdutores(List<String> produtores) {
        this.produtores = produtores;
    }

    public int getIdProduto() {
        return idProduto;
    }

    public void setIdProduto(int idProduto) {
        this.idProduto = idProduto;
    }

    @Override
    public String toString() {
        return super.toString() + " - Estúdio: " + this.estudio + " - Diretores: " +
                this.diretores + " - Gêneros: " + this.generos + " - Produtores: " + this.produtores;
    }


}
