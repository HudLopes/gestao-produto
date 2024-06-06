import enums.TipoOperacao;
import exception.ErroInternoException;
import model.Cliente;
import model.Fornecedor;
import model.Produto;
import service.ClienteServiceImpl;
import service.FornecedoresServiceImpl;
import service.MenuService;
import service.ProdutoServiceImpl;

import java.util.List;
import java.util.Scanner;

public class GestaoEstoqueWorkflow {

    private static final MenuService menuService = new MenuService();
    private static final ProdutoServiceImpl produtoService = new ProdutoServiceImpl();
    private static final ClienteServiceImpl clienteService = new ClienteServiceImpl();
    private static final FornecedoresServiceImpl fornecedoresService = new FornecedoresServiceImpl();

    public static void run() {

        List<Produto> listaProdutos = produtoService.mockListaProdutos();
        List<Fornecedor> listaFornecdores = fornecedoresService.mockListaFornecedores();
        List<Cliente> listaClientes = clienteService.mockListaClientes();

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

    private static void renderizarMenuPrincipal(List<Produto> listaProdutos, List<Fornecedor> listaFornecedores, List<Cliente> listaClientes) throws ErroInternoException {
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

        realizarAcao(opcaoSubMenuDigitada, listaProdutos, listaFornecedores, listaClientes, tipoOperacao);
        init(listaProdutos, listaFornecedores, listaClientes);
    }

    private static void realizarAcao(Integer numeroOpcao, List<Produto> listaProdutos, List<Fornecedor> listaFornecedores,  List<Cliente> listaClientes, TipoOperacao tipoOperacao) throws ErroInternoException {

        if(tipoOperacao.name().equals("CLIENTE")) {
            realizarAcaoCliente(numeroOpcao, listaProdutos, listaFornecedores, listaClientes);
        } else if(tipoOperacao.name().equals("PRODUTO")) {
            realizarAcaoProduto(numeroOpcao, listaProdutos, listaFornecedores, listaClientes);
        } else if(tipoOperacao.name().equals("FORNECEDOR")) {
            realizarAcaoFornecedores(numeroOpcao, listaProdutos, listaFornecedores, listaClientes);
        }

    }

    private static void realizarAcaoFornecedores(Integer numeroOpcao, List<Produto> listaProdutos, List<Fornecedor> listaFornecedores, List<Cliente> listaClientes) throws ErroInternoException {
        switch (numeroOpcao) {
            case 1:
                var produto = menuService.criarMenuAdicionarProduto();
                produtoService.criar(listaProdutos, produto);
                renderizarMenuPrincipal(listaProdutos, listaFornecedores, listaClientes);
                break;
            case 2:
                var codigoRemover = menuService.criarMenuCapturarCodigo();
                var fornecedorRemover = fornecedoresService.existe(listaFornecedores, codigoRemover);
                if(fornecedorRemover) {
                    fornecedoresService.remover(listaFornecedores, codigoRemover);
                } else {
                    System.out.println("\nCodigo de fornecedor não encontrado na base.\n");
                }
                renderizarMenuPrincipal(listaProdutos, listaFornecedores, listaClientes);
                break;
            case 3:
                var codigoAlterar = menuService.criarMenuCapturarCodigo();
                var produtoExiste = fornecedoresService.existe(listaFornecedores, codigoAlterar);
                if (produtoExiste) {
                    var opcao = menuService.criarMenuAlterarFornecedor();
                    var fornecedorAlterar = receberCampoAlteradoFornecedor(opcao, listaFornecedores, codigoAlterar);
                    fornecedoresService.editar(listaFornecedores, fornecedorAlterar);
                    System.out.println("Fornecedor alterado com sucesso!");
                } else {
                    System.out.println("\nCodigo do fornecedor não encontrado na base.\n");
                }
                renderizarMenuPrincipal(listaProdutos, listaFornecedores, listaClientes);
                break;
            case 4:
                fornecedoresService.listar(listaFornecedores);
                menuService.exibirOpcaoVoltar();
                renderizarMenuPrincipal(listaProdutos, listaFornecedores, listaClientes);
                break;
            case 5:
                init(listaProdutos, listaFornecedores, listaClientes);
                break;
        }
    }

    private static void realizarAcaoCliente(Integer numeroOpcao, List<Produto> listaProdutos, List<Fornecedor> listaFornecedores, List<Cliente> listaClientes) throws ErroInternoException {
        switch (numeroOpcao) {
            case 1:
                var cliente = menuService.criarMenuAdicionarCliente();
                clienteService.criar(listaClientes, cliente);
                renderizarMenuPrincipal(listaProdutos, listaFornecedores, listaClientes);
                break;
            case 2:
                var codigoRemover = menuService.criarMenuCapturarCodigo();
                var clienteRemover = clienteService.existe(listaClientes, codigoRemover);
                if(clienteRemover) {
                    clienteService.remover(listaClientes, codigoRemover);
                } else {
                    System.out.println("\nCliente não encontrado na base.\n");
                }
                renderizarMenuPrincipal(listaProdutos, listaFornecedores, listaClientes);
                break;
            case 3:
                var codigoAlterar = menuService.criarMenuCapturarCodigo();
                var clienteExiste = clienteService.existe(listaClientes, codigoAlterar);
                if (clienteExiste) {
                    var opcao = menuService. criarMenuAlterarCliente();
                    var clienteAlterado = receberCampoAlteradoCliente(opcao, listaClientes, codigoAlterar);
                    clienteService.editar(listaClientes, clienteAlterado);
                    System.out.println("Cliente alterado com sucesso!");
                } else {
                    System.out.println("\nCodigo de cliente não encontrado na base.\n");
                }
                renderizarMenuPrincipal(listaProdutos, listaFornecedores, listaClientes);
                break;
            case 4:
                clienteService.listar(listaClientes);
                menuService.exibirOpcaoVoltar();
                renderizarMenuPrincipal(listaProdutos, listaFornecedores, listaClientes);
                break;
            case 5:
                init(listaProdutos, listaFornecedores, listaClientes);
                break;
        }
    }

    private static void realizarAcaoProduto(Integer numeroOpcao, List<Produto> listaProdutos, List<Fornecedor> listaFornecedores, List<Cliente> listaClientes) throws ErroInternoException {
        switch (numeroOpcao) {
            case 1:
                var produto = menuService.criarMenuAdicionarProduto();
                produtoService.criar(listaProdutos, produto);
                renderizarMenuPrincipal(listaProdutos, listaFornecedores, listaClientes);
                break;
            case 2:
                var codigoProdutoRemover = menuService.criarMenuCapturarCodigo();
                var produtoExisteRemover = produtoService.existe(listaProdutos, codigoProdutoRemover);
                if(produtoExisteRemover) {
                    produtoService.remover(listaProdutos, codigoProdutoRemover);
                } else {
                    System.out.println("\nCodigo de produto não encontrado na base.\n");
                }
                renderizarMenuPrincipal(listaProdutos, listaFornecedores, listaClientes);
                break;
            case 3:
                var codigoProdutoAlterar = menuService.criarMenuCapturarCodigo();
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


    private static Produto receberCampoAlterado(int opcao, List<Produto> listaProdutos, String codigoProdutoAlterado) throws ErroInternoException {
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

    private static Cliente receberCampoAlteradoCliente(int opcao, List<Cliente> lista, String codigoCliente) throws ErroInternoException {
        Scanner sc = new Scanner(System.in);

        var cliente = clienteService.buscar(lista, codigoCliente);

        switch (opcao) {
            case 1:
                System.out.print("\n\nEntre com o novo nome do cliente: ");
                var nome = sc.nextLine();
                cliente.setNome(nome);
                break;
            case 2:
                System.out.print("\n\nEntre com o novo email do cliente: ");
                var email = sc.nextLine();
                cliente.setEmail(email);
                break;
            case 3:
                System.out.print("\n\nEntre com o novo valor do produto: ");
                var idade = sc.nextInt();
                cliente.setIdade(idade);
                break;
            case 5:
                //renderizarMenuPrincipal(listaProdutos);
                break;
        }

        return cliente;
    }

    private static Fornecedor receberCampoAlteradoFornecedor(int opcao, List<Fornecedor> lista, String codigoFornecedor) throws ErroInternoException {
        Scanner sc = new Scanner(System.in);

        var fornecedor = fornecedoresService.buscar(lista, codigoFornecedor);

        switch (opcao) {
            case 1:
                System.out.print("\n\nEntre com o novo nome do fornecedor: ");
                var nome = sc.nextLine();
                fornecedor.setNome(nome);
                break;
            case 2:
                System.out.print("\n\nEntre com o novo telefone do fornecedor: ");
                var telefone = sc.nextLine();
                fornecedor.setTelefone(telefone);
                break;
            case 3:
                //renderizarMenuPrincipal(listaProdutos);
                break;
        }

        return fornecedor;
    }
}
