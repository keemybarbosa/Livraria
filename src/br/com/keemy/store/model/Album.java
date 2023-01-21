package br.com.keemy.store.model;

import br.com.keemy.store.Global;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class Album extends Produto{

    private int idProduto;
    private List<String> musicosBandas = new ArrayList<String>();
    private List<String> generos = new ArrayList<String>();
    private List<String> selos = new ArrayList<String>();

    public Album(int idProduto, String nome, BigDecimal preco, int estoque, boolean excluido, Global.CategoriaProduto categoria,
                 List<String> musicosBandas, List<String> generos, List<String> selos) {
        super(idProduto, nome, preco, estoque, excluido, categoria);
        this.musicosBandas = musicosBandas;
        this.generos = generos;
        this.selos = selos;
        this.idProduto = idProduto;
    }

    public Album(String nome, BigDecimal preco, int estoque, boolean excluido, Global.CategoriaProduto categoria) {
        super(nome, preco, estoque, excluido, categoria);
    }

    public Album(Produto entradasProduto) {
        super(entradasProduto);
        //this.musicosBandas = ((Album)entradasProduto).getMusicosBandas();
        //this.generos = ((Album)entradasProduto).getGeneros();;
        //this.selos = ((Album)entradasProduto).getSelos();;
        //this.idProduto = ((Album)entradasProduto).getIdProduto();
    }

    public List<String> getMusicosBandas() {
        return musicosBandas;
    }

    public void setMusicosBandas(List<String> musicosBandas) {
        this.musicosBandas = musicosBandas;
    }

    public List<String> getGeneros() {
        return generos;
    }

    public void setGeneros(List<String> generos) {
        this.generos = generos;
    }

    public List<String> getSelos() {
        return selos;
    }

    public void setSelos(List<String> selos) {
        this.selos = selos;
    }

    public int getIdProduto() {
        return idProduto;
    }

    public void setIdProduto(int idProduto) {
        this.idProduto = idProduto;
    }

    @Override
    public String toString() {
        return super.toString() + " -  Músicos Bandas: " + this.musicosBandas + " - Gêneros: " + this.generos + " - " + this.selos;
    }
}
