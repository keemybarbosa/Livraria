package br.com.keemy.store.model;

import br.com.keemy.store.Global;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class Livro extends Produto{
    private int idProduto;
    private List<String> generos = new ArrayList<String>();
    private String escritor;
    private String editora;

    public Livro(int idProduto, String nome, BigDecimal preco, int estoque, Global.CategoriaProduto categoria,
                 List<String> generos, String escritor, String editora) {
        super(idProduto, nome, preco, estoque, categoria);
        this.generos = generos;
        this.escritor = escritor;
        this.editora = editora;
        this.idProduto = idProduto;
    }

    public Livro(Produto entradasProduto) {
        super(entradasProduto);
        this.generos = ((Livro)entradasProduto).getGeneros();
        this.escritor = ((Livro)entradasProduto).getEscritor();
        this.editora = ((Livro)entradasProduto).getEditora();
        this.idProduto = ((Livro)entradasProduto).getIdProduto();

    }

    public List<String> getGeneros() {
        return generos;
    }

    public void setGeneros(List<String> generos) {
        this.generos = generos;
    }

    public String getEscritor() {
        return escritor;
    }

    public void setEscritor(String escritor) {
        this.escritor = escritor;
    }

    public String getEditora() {
        return editora;
    }

    public void setEditora(String editora) {
        this.editora = editora;
    }

    public int getIdProduto() {
        return idProduto;
    }

    public void setIdProduto(int idProduto) {
        this.idProduto = idProduto;
    }

    @Override
    public String toString() {
        return super.toString() + " - Gêneros: " + this.generos + " - Escritor: " + escritor + " - Editora: " + this.editora;
    }

}
