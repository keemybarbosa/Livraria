package br.com.keemy.store.model;

import br.com.keemy.store.Global;
import br.com.keemy.store.utils.LivrariaUtils;

import java.math.BigDecimal;

public class Produto {

    private int id;
    private String nome;
    private BigDecimal preco;
    private Global.CategoriaProduto categoria; //TODO: transformar em um ENUM

    private int estoque;

    public Produto(){
        this.id = ++Global.lastProductId;
    }

    public Produto(int id, String nome, BigDecimal preco, int estoque, Global.CategoriaProduto categoria) {
        this.id = id;
        this.nome = nome;
        this.preco = preco;
        this.estoque = estoque;
        this.categoria = categoria;
    }

    public Produto(String nome, BigDecimal preco, int estoque, Global.CategoriaProduto categoria) {
        this.id = ++Global.lastProductId;
        this.nome = nome;
        this.preco = preco;
        this.estoque = estoque;
        this.categoria = categoria;
    }

    public Produto(String nome, BigDecimal preco, int estoque) {
        this.id = ++Global.lastProductId;
        this.nome = nome;
        this.preco = preco;
        this.estoque = estoque;
    }

    public Produto(Produto entradasProduto) {
        this.id = entradasProduto.getId();
        this.nome = entradasProduto.getNome();
        this.preco = entradasProduto.getPreco();
        this.estoque = entradasProduto.getEstoque();
        this.categoria = entradasProduto.getCategoria();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public BigDecimal getPreco() {
        return preco;
    }

    public void setPreco(BigDecimal preco) {
        this.preco = preco;
    }

    public Global.CategoriaProduto getCategoria() {
        return categoria;
    }

    public void setCategoria(Global.CategoriaProduto categoria) {
        this.categoria = categoria;
    }

    public int getEstoque() {
        return estoque;
    }

    public void setEstoque(int estoque) {
        this.estoque = estoque;
    }

    @Override
    public String toString() {
        try {

            return this.getId() + " - " +
                    LivrariaUtils.formatarCaracteresFixos(this.getNome(), 30) + " - " +
                    LivrariaUtils.formatarCaracteresFixos("Estoque: " + this.getEstoque(),15) + " - " +
                    this.getCategoria().toString() + "(" + this.getCategoria().getValor() + ")";
        } catch (Exception e){
            return e.toString();
        }

    }

    public Album toAlbum(){
        if (this instanceof Album)
            return (Album) this;
        return new Album(this);
    }

}
