package br.com.keemy.store;

import br.com.keemy.store.controller.ProdutoController;
import br.com.keemy.store.dao.impl.*;
import br.com.keemy.store.model.*;
import br.com.keemy.store.utils.LivrariaUtils;

import java.math.BigDecimal;

import java.util.*;

import static br.com.keemy.store.Global.*;
import static br.com.keemy.store.utils.LivrariaUtils.*;

public class Main {

    static AlbumImpl albumImpl = new AlbumImpl();
    static BrinquedoImpl brinquedoImpl = new BrinquedoImpl();
    static FilmeImpl filmeImpl = new FilmeImpl();
    static LivroImpl livroImpl = new LivroImpl();
    static JogoImpl jogoImpl = new JogoImpl();
    static ProdutoImpl produtoImpl = new ProdutoImpl();


    public static void main(String[] args) {
        inserirProdutosParaTeste();
        do {
            exibirMenuPrincipal();
        }while(true);
    }

    private static void listarProdutos() {
        int i = 0;
        for (Produto produto : Global.listaDeProdutos) {
            System.out.println(produto.toString());

            //Pausa a lista a cada 20 produtos
            if(++i % 20 == 0){
                pausar();
            }

        }

    }

    private static void alterarProdutos(){
        Scanner scanner = new Scanner(System.in);
        Integer id;

        System.out.println("Alteração de produto");
        listarProdutos();
        System.out.println("Informe o id do produto");

        if (scanner.hasNextInt()){
            id = scanner.nextInt();
            Produto produto = ProdutoController.getProdutoById(id);

            if(produto == null){
                System.out.println("Produto não encontrado!");
            } else {
                ExecutarCRUD(produto,produto.getCategoria(), OperacoesCRUD.UPDATE);
                System.out.println("Produto alterado com sucesso!");
            }

        } else {
            System.out.println("Entrada inválida!");
            scanner = new Scanner(System.in);
        }

        listarProdutos();

        pausar();
    }

    private static void excluirProdutos(){
        Scanner scanner = new Scanner(System.in);
        Integer id;

        System.out.println("Alteração de produto");
        listarProdutos();
        System.out.println("Informe o id do produto");

        if (scanner.hasNextInt()){
            id = scanner.nextInt();
            Produto produto = ProdutoController.getProdutoById(id);

            if(produto == null){
                System.out.println("Produto não encontrado!");
                pausar();
            } else {
                ExecutarCRUD(produto,produto.getCategoria(), OperacoesCRUD.DELETE);
                System.out.println("Produto excluído com sucesso!");
            }

        } else {
            System.out.println("Entrada inválida!");
            scanner = new Scanner(System.in);
        }
        System.out.println("################ LISTA ATUALIZADA DE PRODUTOS #####################");
        listarProdutos();

        pausar();

        exibirMenuManutencaoProdutos();
    }
    private static void cadastrarProdutos(){
        Scanner scanner = new Scanner(System.in);
        int opcao;
        CategoriaProduto categoriaProduto;

        String cabecalho =
                "##################################################################################\n" +
                "#                            CADASTRO DE PRODUTOS                                #\n" +
                "##################################################################################";
        System.out.println(cabecalho);

        //ESCOLHENDO A CATEGORIA DO PRODUTO PARA IMPRESSÃO
        System.out.println("Informe a categoria do produto:");
        do {
            System.out.println("[0] - Voltar");
            Arrays.stream((CategoriaProduto.values())).toList().forEach(
                    categoria -> System.out.printf("[%d] - %s%n", categoria.getValor(), categoria.toString()));

            opcao = scanner.nextInt();
            if (opcao == 0) return;

        } while (CategoriaProduto.getById(opcao) == null);

        CategoriaProduto categoria =  CategoriaProduto.getById(opcao);

        Produto produto = new Produto();
        produto.setCategoria(categoria);
        ExecutarCRUD(produto, categoria, OperacoesCRUD.CREATE);

        pausar();
    }

    private static void ExecutarCRUD(Produto produto, CategoriaProduto categoria, OperacoesCRUD operacao) {
        if (operacao == OperacoesCRUD.DELETE) {
            produtoImpl.deletar(produto);
        } else {
            switch (categoria) {
                case PRODUTO_ALBUM:
                    Album a = getEntradaAlbuns(getEntradasProduto(produto));
                    if (operacao == OperacoesCRUD.CREATE) {
                        albumImpl.cadastrar(a);
                    } else if (operacao == OperacoesCRUD.UPDATE) {
                        albumImpl.atualizar(a);
                    }
                    break;
                case PRODUTO_BRINQUEDO:
                    Brinquedo b = getEntradaBrinquedos(getEntradasProduto(produto));
                    if (operacao == OperacoesCRUD.CREATE) {
                        brinquedoImpl.cadastrar(b);
                    } else if (operacao == OperacoesCRUD.UPDATE) {
                        brinquedoImpl.atualizar(b);
                    }
                    break;
                case PRODUTO_FILME:
                    Filme f = getEntradaFilmes(getEntradasProduto(produto));
                    if (operacao == OperacoesCRUD.CREATE) {
                        filmeImpl.cadastrar(f);
                    } else if (operacao == OperacoesCRUD.UPDATE) {
                        filmeImpl.atualizar(f);
                    }

                    break;
                case PRODUTO_JOGO:
                    Jogo j = getEntradaJogos(getEntradasProduto(produto));
                    if (operacao == OperacoesCRUD.CREATE) {
                        jogoImpl.cadastrar(j);
                    } else if (operacao == OperacoesCRUD.UPDATE) {
                        jogoImpl.atualizar(j);
                    }
                    break;
                case PRODUTO_LIVRO:
                    Livro l = getEntradaLivros(getEntradasProduto(produto));
                    if (operacao == OperacoesCRUD.CREATE) {
                        livroImpl.cadastrar(l);
                    } else if (operacao == OperacoesCRUD.UPDATE) {
                        livroImpl.atualizar(l);
                    }
                    break;

            }
        }
    }

    private static Album getEntradaAlbuns(Produto produto) {
        Album p = new Album(produto);
        p.setCategoria(CategoriaProduto.PRODUTO_ALBUM);

        //Album a = (Album) p;
        p.setIdProduto(p.getId());
        p.setMusicosBandas(lerListaGenerica("Digite o nome do músico: ", "músicos"));
        p.setGeneros(lerListaGenerica("Digite o nome do gênero", "gêneros"));
        p.setSelos(lerListaGenerica( "Digite o nome do selo", "selos"));
        return p;
    }

    private static Brinquedo getEntradaBrinquedos(Produto produto) {
        Brinquedo b = new Brinquedo(produto);
        b.setCategoria(CategoriaProduto.PRODUTO_BRINQUEDO);

        b.setIdProduto(b.getId());
        b.setTipoBrinquedo(lerNumero("Informe o tipo do Brinquedo"));
        return b;
    }

    private static Filme getEntradaFilmes(Produto produto) {
        Filme f = new Filme(produto);
        f.setCategoria(CategoriaProduto.PRODUTO_FILME);

        f.setIdProduto(f.getId());
        f.setEstudio(lerString("Digite o nome do estúdio"));
        f.setDiretores(lerListaGenerica("Digite o nome do diretor", "diretores"));
        f.setGeneros(lerListaGenerica("Digite o nome do gênero", "gêneros"));
        f.setProdutores(lerListaGenerica("Digite o nome do produtor", "produtores"));
        return f;
    }

    private static Jogo getEntradaJogos(Produto produto) {
        Jogo j = new Jogo(produto);
        j.setCategoria(CategoriaProduto.PRODUTO_JOGO);

        j.setIdProduto(j.getId());
        j.setDistribuidora(lerString("Digite o nome da distribuidora"));
        j.setGeneros(lerListaGenerica("Digite o nome do gênero","gêneros"));
        j.setEstudio(lerString("Digite o nome do estúdio"));

        return j;
    }

    private static Livro getEntradaLivros(Produto produto) {
        Livro l = new Livro(produto);
        l.setCategoria(CategoriaProduto.PRODUTO_LIVRO);

        l.setIdProduto(l.getId());
        l.setGeneros(lerListaGenerica("Digite o nome do gênero","gêneros"));
        l.setEscritor(lerString("Digite o nome do escritor"));
        l.setEditora(lerString("Digite o nome da editora"));

        return l;
    }

    private static Produto getEntradasProduto(Produto produto) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Digite o nome: ");
        String nome = scanner.nextLine();


        System.out.println("Digite o preço: ");
        BigDecimal preco = scanner.nextBigDecimal();


        System.out.println("Digite o estoque inicial do produto");
        int estoque = scanner.nextInt();

        if (produto != null) {
            produto.setNome(nome);
            produto.setPreco(preco);
            produto.setEstoque(estoque);
        }

        if (produto == null) {
            return new Produto(nome, preco, estoque);
        } else {
            return produto;
        }
    }

    private static String lerString(String prompt){
        Scanner sc = new Scanner(System.in);
        System.out.println(prompt);
        return sc.nextLine();
    }

    private static int lerNumero(String prompt){
        Scanner sc = new Scanner(System.in);
        System.out.println(prompt);
        return sc.nextInt();
    }

    private static List<String> lerListaGenerica(String prompt, String tipo) {
        String op;
        Scanner sc = new Scanner(System.in);
        List<String> listaDeStrings = new ArrayList<>();
        do{
            System.out.println(prompt);
            listaDeStrings.add(sc.nextLine());
            System.out.println("Digite [S] para continuar inserindo " + tipo);
            op = sc.nextLine();
        } while(op.equalsIgnoreCase("S"));
        return listaDeStrings;
    }

    public static void listarProdutosPorCategoria() {
        List<Produto> listaOrdenada = Global.listaDeProdutos.stream()
                .sorted((o1,o2)->o1.getCategoria().compareTo(o2.getCategoria())).toList();

        int i = 0;
        int iCategoriaAtual = listaOrdenada.get(0).getCategoria().getValor();
        for (Produto produto : listaOrdenada) {
            //Se a categoria muda, imprime o cabeçalho da categoria
            if (i==0 || (iCategoriaAtual != produto.getCategoria().getValor())){
                System.out.printf("[%s]%n", produto.getCategoria().toString());
                iCategoriaAtual = produto.getCategoria().getValor();
            }

            switch (CategoriaProduto.getById(iCategoriaAtual)){
                case PRODUTO_ALBUM:
                    System.out.println(((Album)produto).toString());
                    break;
                case PRODUTO_BRINQUEDO:
                    System.out.println(((Brinquedo)produto).toString());
                    break;
                case PRODUTO_FILME:
                    System.out.println(((Filme)produto).toString());
                    break;
                case PRODUTO_JOGO:
                    System.out.println(((Jogo)produto).toString());
                    break;
                case PRODUTO_LIVRO:
                    System.out.println(((Livro)produto).toString());
                    break;

            }


            //A cada 20 produtos realiza uma pausa
            if(++i % 20 == 0){
                pausar();
            }

        }
        pausar();
    }
    private static void inserirProdutosParaTeste() {
        //TODO: remover método


        Produto p = new Brinquedo(++Global.lastProductId,"Bola",new BigDecimal(12.51), 10,CategoriaProduto.PRODUTO_BRINQUEDO,1);
        brinquedoImpl.cadastrar(p);

        p = new Livro(++Global.lastProductId,"O Atheneu",new BigDecimal(4.55), 10,CategoriaProduto.PRODUTO_LIVRO,null,"Stephen King","Saraiva");
        livroImpl.cadastrar(p);

        p = new Filme(++Global.lastProductId,"De Volta para o Futuro", new BigDecimal(12.44), 10,CategoriaProduto.PRODUTO_FILME,"estúdio",null, null, null);
        filmeImpl.cadastrar(p);

        p = new Filme(++Global.lastProductId,"Titanic", new BigDecimal(12.99), 10, CategoriaProduto.PRODUTO_FILME,"estúdio",null, null, null);
        filmeImpl.cadastrar(p);

        p = new Filme(++Global.lastProductId,"Efeito Borboleta", new BigDecimal(12.50), 10, CategoriaProduto.PRODUTO_FILME, "estúdio",null, null, null);
        filmeImpl.cadastrar(p);

        p = new Livro(++Global.lastProductId,"Dom casmurro",new BigDecimal(4.55), 10, CategoriaProduto.PRODUTO_LIVRO,null,"Stephen King","Saraiva");
        livroImpl.cadastrar(p);

        p = new Album(++lastProductId, "album1", new BigDecimal(12.6), 10, CategoriaProduto.PRODUTO_ALBUM,
                new ArrayList<>(Arrays.asList(new String[]{"musico1", "musico2"})),
                new ArrayList<>(Arrays.asList(new String[]{"Gênero1", "gÊnero2"})),
                new ArrayList<>(Arrays.asList(new String[]{"selo1", "selo2"})));
        albumImpl.cadastrar(p);
    }
    private static void exibirMenuPrincipal() {
        String cabecalho =
                "##################################################################################\n" +
                "#                              LIVRARIA AMERICANAS                               #\n" +
                "##################################################################################";

        Scanner scanner = new Scanner(System.in);
        int op = -1;
        String menuOptions[] = {"Manutenção de Produtos", "Relatórios", "Loja"};
        op = menu(cabecalho, scanner, menuOptions, "Sair" );

        switch (op){
                case 0:
                    System.exit(0);
                case 1:
                    exibirMenuManutencaoProdutos();
                    break;
                case 2:
                    exibirMenuRelatorios();
                    break;
                case 3:
                    exibirMenuLoja();
                    break;
            }
    }

    private static void exibirMenuLoja() {
        System.out.println("CAIXA");
        System.out.println("Caixa: " + Loja.getInstance().getCaixa());

        menuLoja();

        pausar();

    }

    private static void menuLoja(){
        Formatter formatter = new Formatter();
        String cabecalho =
                "##################################################################################\n" +
                "#                                    LOJA                                        #\n" +
                "##################################################################################\n" +
                "#" + LivrariaUtils.formatarCaracteresFixos(
                                "Saldo: " + formatter.format("%.2f", Loja.getInstance().getCaixa()),80) + "#\n" +
                "##################################################################################";
        Scanner scanner = new Scanner(System.in);
        int op = -1;
        String menuOptions[] = {"Vender"};
        op = menu(cabecalho, scanner, menuOptions, "Voltar" );

        switch (op){
            case 0:
                break;
            case 1:
                venderProduto();
                menuLoja();
                break;

        }
    }

    private static void venderProduto() {
        Scanner scanner = new Scanner(System.in);
        Integer id;

        System.out.println("Venda de produto");
        listarProdutos();
        System.out.println("Informe o id do produto");

        if (scanner.hasNextInt()){
            id = scanner.nextInt();
            Produto produto = ProdutoController.getProdutoById(id);

            if(produto == null){
                System.out.println("Produto não encontrado!");
            } else {

                System.out.printf("Produto: %s Preço: %.2f Estoque: %d%n", produto.getNome(), produto.getPreco(), produto.getEstoque());
                Integer quantidade = lerNumero("Digite a quantidade:");

                BigDecimal valorCompra = (produto.getPreco().multiply(new BigDecimal(quantidade)));

                Loja.getInstance().setCaixa(Loja.getInstance().getCaixa().add(valorCompra));

                System.out.printf("Total: %.2f%n", valorCompra);




                listaDeProdutos.stream().filter(item -> item.getId() == produto.getId()).findAny()
                        .map(item -> {
                            item.setEstoque(item.getEstoque() - quantidade);
                            return item;
                        });

                System.out.println("Produto Vendido!");
            }

        } else {
            System.out.println("Entrada inválida!");
            scanner = new Scanner(System.in);
        }
    }

    private static void exibirMenuRelatorios() {
        String cabecalho =
                "##################################################################################\n" +
                "#                                  RELATÓRIOS                                    #\n" +
                "##################################################################################";

        Scanner scanner = new Scanner(System.in);
        int op = -1;
        String menuOptions[] = {"Listar Produtos", "Listar Produtos Por Categoria"};
        op = menu(cabecalho, scanner, menuOptions, "Voltar" );

        switch (op){
            case 0:
                break; //volta pro menu principal
            case 1:
                listarProdutos();
                pausar();
                exibirMenuRelatorios();
                break;
            case 2:
                System.out.println("Lista de Produtos por Categoria");
                listarProdutosPorCategoria();
                break;
            case 3:
                break;
        }
    }
    private static void exibirMenuManutencaoProdutos() {
        String cabecalho =
                "##################################################################################\n" +
                "#                           MANUTENÇÃO DE PRODUTOS                               #\n" +
                "##################################################################################";

        Scanner scanner = new Scanner(System.in);
        int op = -1;
        String menuOptions[] = {"Cadastrar", "Exibir", "Alterar", "Excluir"};
        op = menu(cabecalho, scanner, menuOptions, "Voltar" );

        switch (op){
            case 0:
                break; //volta pro menu principal
            case 1:
                cadastrarProdutos();
                break;
            case 2:
                listarProdutos();
                pausar();
                break;
            case 3:
                alterarProdutos();
                break;
            case 4:
                excluirProdutos();
                break;
        }
    }

}