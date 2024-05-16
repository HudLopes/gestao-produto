import model.Produto;
import service.MenuService;
import service.ProdutoService;
import java.util.List;

public class GestaoEstoqueWorkflow {

    private static final MenuService menuService = new MenuService();
    private static final ProdutoService produtoService = new ProdutoService();

    public static void run() {

        List<Produto> listaProdutos = produtoService.mockListaProdutos();

        try {
            renderizarMenuPrincipal(listaProdutos);
        } catch (Exception exception) {
            System.out.println(exception.getMessage());
            renderizarMenuPrincipal(listaProdutos);
        }

    }

    private static void renderizarMenuPrincipal(List<Produto> listaProdutos) {
        var opcaoDigitada = menuService.criarMenu();
        realizarAcao(opcaoDigitada, listaProdutos);
    }

    private static void realizarAcao(Integer numeroOpcao, List<Produto> listaProdutos) {
        switch (numeroOpcao) {
            case 1:
                var produto = menuService.criarMenuAdicionarProduto();
                produtoService.criarProduto(listaProdutos, produto);
                menuService.exibirOpcaoVoltar();
                renderizarMenuPrincipal(listaProdutos);
                break;
            case 2:
                var codigoProduto = menuService.criarMenuRemoverProduto();
                produtoService.removerProduto(listaProdutos, codigoProduto);
                menuService.exibirOpcaoVoltar();
                renderizarMenuPrincipal(listaProdutos);
                break;
            case 3:
                System.out.println("\nUpdate produto \n");
                break;
            case 4:
                produtoService.listarProdutos(listaProdutos);
                menuService.exibirOpcaoVoltar();
                renderizarMenuPrincipal(listaProdutos);
                break;
            case 5:
                System.out.println("\nFinalizando aplicação\n");
                System.exit(0);
                break;
        }
    }

}
