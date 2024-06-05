import enums.TipoOperacao;
import model.Cliente;
import model.Fornecedor;
import model.Produto;
import service.MenuService;
import service.ProdutoServiceImpl;
import java.util.List;
import java.util.Scanner;

public class GestaoEstoqueWorkflow {

    private static final MenuService menuService = new MenuService();
    private static final ProdutoServiceImpl produtoService = new ProdutoServiceImpl();

    public static void run() {

        List<Produto> listaProdutos = produtoService.mockListaProdutos();
        List<Fornecedor> listaFornecdores = null;
        List<Cliente> listaClientes = null;

        init(listaProdutos, listaFornecdores, listaClientes);
    }

    private static void init(List<Produto> listaProdutos, List<Fornecedor> listaFornecedores, List<Cliente> listaClientes) {
        try {
            renderizarMenuPrincipal(listaProdutos, listaFornecedores, listaClientes);
        } catch (Exception exception) {
            System.out.println("Ocorreu um problema: " + exception.getMessage());
            init(listaProdutos, listaFornecedores, listaClientes);
        }
    }

    private static void renderizarMenuPrincipal(List<Produto> listaProdutos, List<Fornecedor> listaFornecedores, List<Cliente> listaClientes) {
        var opcaoDigitada = menuService.criarMenu();

        int opcaoSubMenuDigitada = 0;
        TipoOperacao tipoOperacao = null;

        if(opcaoDigitada.equals(1)) {
            tipoOperacao = TipoOperacao.CLIENTE;
        } else if (opcaoDigitada.equals(2)) {
            tipoOperacao = TipoOperacao.PRODUTO;
        } else if(opcaoDigitada.equals(3)) {
            tipoOperacao = TipoOperacao.FORNECEDOR;
        } else if(opcaoDigitada.equals(4)) {
           System.exit(0);
        }

        opcaoSubMenuDigitada = menuService.criarSubMenu(tipoOperacao);

        realizarAcao(opcaoSubMenuDigitada, listaProdutos, listaFornecedores, listaClientes);
        init(listaProdutos, listaFornecedores, listaClientes);
    }

    private static void realizarAcao(Integer numeroOpcao, List<Produto> listaProdutos, List<Fornecedor> listaFornecedores,  List<Cliente> listaClientes) {

        switch (numeroOpcao) {
            case 1:
                var produto = menuService.criarMenuAdicionarProduto();
                produtoService.criar(listaProdutos, produto);
                renderizarMenuPrincipal(listaProdutos, listaFornecedores, listaClientes);
                break;
            case 2:
                var codigoProdutoRemover = menuService.criarMenuCapturarCodigoProduto();
                var produtoExisteRemover = produtoService.existe(listaProdutos, codigoProdutoRemover);
                if(produtoExisteRemover) {
                    produtoService.remover(listaProdutos, codigoProdutoRemover);
                } else {
                    System.out.println("\nCodigo de produto não encontrado na base.\n");
                }
                renderizarMenuPrincipal(listaProdutos, listaFornecedores, listaClientes);
                break;
            case 3:
                var codigoProdutoAlterar = menuService.criarMenuCapturarCodigoProduto();
                var produtoExiste = produtoService.existe(listaProdutos, codigoProdutoAlterar);
                if (produtoExiste) {
                   var opcao = menuService.criarMenuAlterarProduto();
                   var produtoAlterar = receberCampoAlterado(opcao, listaProdutos, codigoProdutoAlterar);
                   produtoService.editar(listaProdutos, produtoAlterar);
                   System.out.println("Produto alterado com sucesso!");
                } else {
                    System.out.println("\nCodigo de produto não encontrado na base.\n");
                }
                renderizarMenuPrincipal(listaProdutos, listaFornecedores, listaClientes);
                break;
            case 4:
                produtoService.listar(listaProdutos);
                menuService.exibirOpcaoVoltar();
                renderizarMenuPrincipal(listaProdutos, listaFornecedores, listaClientes);
                break;
            case 5:
                init(listaProdutos, listaFornecedores, listaClientes);
                break;
        }
    }


    private static Produto receberCampoAlterado(int opcao, List<Produto> listaProdutos, String codigoProdutoAlterado) {
        Scanner sc = new Scanner(System.in);

        var produto = produtoService.buscar(listaProdutos, codigoProdutoAlterado);

        switch (opcao) {
            case 1:
                System.out.print("\n\nEntre com o novo nome do produto: ");
                var nomeProdutoDigitado = sc.nextLine();
                produto.setNome(nomeProdutoDigitado);
                break;
            case 2:
                System.out.print("\n\nEntre com a nova quantidade do produto: ");
                var quantidadeProduto = sc.nextInt();
                produto.setQuantidade(quantidadeProduto);
                break;
            case 3:
                System.out.print("\n\nEntre com o novo valor do produto: ");
                var valorProduto = sc.nextBigDecimal();
                produto.setValor(valorProduto);
                break;
            case 4:
                System.out.print("\n\nEntre com o novo tipo do produto: ");
                var tipoProduto = sc.nextLine();
                produto.setTipo(tipoProduto);
                break;
            case 5:
                //renderizarMenuPrincipal(listaProdutos);
                break;
        }

        return produto;
    }
}
