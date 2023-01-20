package br.com.keemy.store;

import br.com.keemy.store.model.*;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class Global {

    public static int lastProductId = 0;

    public static BigDecimal caixaInicial = new BigDecimal(10000);
    public static List<Produto> listaDeProdutos = new ArrayList<Produto>();
    public static List<Album> listaDeAlbuns = new ArrayList<Album>();
    public static List<Brinquedo> listaDeBrinquedos = new ArrayList<Brinquedo>();
    public static List<Filme> listaDeFilmes = new ArrayList<Filme>();
    public static List<Jogo> listaDeJogos = new ArrayList<Jogo>();
    public static List<Livro> listaDeLivros = new ArrayList<Livro>();

    public enum OperacoesCRUD{
        CREATE,
        READ,
        UPDATE,
        DELETE
    }

    public enum CategoriaProduto {
        PRODUTO_ALBUM(1){
            @Override
            public String toString() {
                return "Álbum";
            }
        },
        PRODUTO_BRINQUEDO(2){
            @Override
            public String toString() {
                return "Brinquedo";
            }
        },
        PRODUTO_FILME(3){
            @Override
            public String toString() {
                return "Filme";
            }
        },
        PRODUTO_JOGO(4){
            @Override
            public String toString() {
                return "Jogo";
            }
        },
        PRODUTO_LIVRO(5){
            @Override
            public String toString() {
                return "Livro";
            }
        };

        private final int valor;
        CategoriaProduto(int valor) {
            this.valor = valor;
        }

        public static CategoriaProduto getById(int id) {

            for (CategoriaProduto item: CategoriaProduto.values()) {
                if(((CategoriaProduto)item).getValor() == id ){
                    return item;
                }
            }
            return null;
        }

        public int getValor() {
            return this.valor;
        }

        public static boolean existeItemById(int id){
            boolean retorno = false;
            for (CategoriaProduto item: CategoriaProduto.values()) {
                if(((CategoriaProduto)item).getValor() == id ){
                    return true;
                }
            }
            return retorno;
        }

    }

}
