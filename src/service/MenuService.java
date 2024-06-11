package service;

import enums.TipoOperacao;
import exception.ErroInternoException;
import model.Cliente;
import model.Fornecedor;
import model.Produto;

import java.util.Scanner;

public class MenuService {

    public Integer criarMenu() {
        Integer numeroDigitado = 0;

        try {
            System.out.print("\n=============================================================================");
            System.out.println("\n\n Gestão de Estoque \n\n" +
                    "1 - Clientes \n" +
                    "2 - Produtos \n" +
                    "3 - Fornecedores \n" +
                    "\n4 - Sair ");

            System.out.print("\nEntre com a opção [number]: ");
            Scanner opcao = new Scanner(System.in);
            numeroDigitado = opcao.nextInt();

            validarNumeroDigitadoMenu(numeroDigitado);

            System.out.print("\n=============================================================================");
        } catch (Exception exception) {
            System.out.println("Entrada inválida, é necessario digitar um numero entre 1 e 5.");
            criarMenu();
        }

        return numeroDigitado;
    }

    public Integer criarSubMenu(TipoOperacao tipoOperacao) {
        Integer numeroDigitado = 0;
        var tipoOperacaoName = tipoOperacao.getNome();

        try {
            System.out.print("\n=============================================================================");
            System.out.println("\n\n Gestão de Estoque \n\n" +
                    "1 - Adicionar " + tipoOperacaoName + "\n" +
                    "2 - Remover " + tipoOperacaoName + "\n" +
                    "3 - Atualizar " + tipoOperacaoName + " \n" +
                    "4 - Visualizar " + tipoOperacaoName + " \n" +
                    "\n5 - Voltar ");

            System.out.print("\nEntre com a opção [number]: ");
            Scanner opcao = new Scanner(System.in);
            numeroDigitado = opcao.nextInt();

            validarNumeroDigitadoSubMenu(numeroDigitado, 1, 5);

            System.out.print("\n=============================================================================");
        } catch (Exception exception) {
            System.out.println("Entrada inválida, é necessario digitar um numero entre 1 e 5.");
            criarMenu();
        }

        return numeroDigitado;
    }

    public Produto criarMenuAdicionarProduto() {
        Produto produto = new Produto();
        Scanner sc = new Scanner(System.in);

        System.out.print("\n\nEntre com o codigo do produto: ");
        var codigoProdutoDigitado = sc.nextLine();
        produto.setCodigo(codigoProdutoDigitado);

        System.out.print("\nEntre com o nome do produto: ");
        var nomeProdutoDigitado = sc.nextLine();
        produto.setNome(nomeProdutoDigitado);

        System.out.print("\nEntre com o tipo do produto: ");
        var tipoProduto = sc.nextLine();
        produto.setTipo(tipoProduto);

        System.out.print("\nEntre com a quantidade do produto: ");
        var qtdProduto = sc.nextInt();
        produto.setQuantidade(qtdProduto);

        System.out.print("\nEntre com o valor do produto: ");
        var valor = sc.nextBigDecimal();
        produto.setValor(valor);

        return produto;
    }

    public Fornecedor criarMenuAdicionarFornecedor() {
        Fornecedor fornecedor = new Fornecedor();
        Scanner sc = new Scanner(System.in);

        System.out.print("\n\nEntre com o codigo do fornecedor: ");
        var codigo = sc.nextLine();
        fornecedor.setCodigo(codigo);

        System.out.print("\nEntre com o nome do produto: ");
        var nome = sc.nextLine();
        fornecedor.setNome(nome);

        System.out.print("\nEntre com o tipo do produto: ");
        var cpnj = sc.nextLine();
        fornecedor.setCnpj(cpnj);

        System.out.print("\nEntre com o tipo do produto: ");
        var telefone = sc.nextLine();
        fornecedor.setTelefone(telefone);

        return fornecedor;
    }

    public Cliente criarMenuAdicionarCliente() {
        Cliente c = new Cliente();
        Scanner sc = new Scanner(System.in);

        System.out.print("\n\nEntre com o codigo do Cliente: ");
        var codigo = sc.nextLine();
        c.setCodigo(codigo);

        System.out.print("\nEntre com o nome do cliente: ");
        var nome = sc.nextLine();
        c.setNome(nome);

        System.out.print("\nEntre com o email do cliente: ");
        var email = sc.nextLine();
        c.setEmail(email);

        System.out.print("\nEntre com a idade do cliente: ");
        var idade = sc.nextInt();
        c.setIdade(idade);

        return c;
    }

    public String criarMenuCapturarCodigo() {
        Scanner sc = new Scanner(System.in);

        System.out.print("\n\nEntre com o codigo: ");
        return sc.nextLine();
    }

    private void validarNumeroDigitadoMenu(Integer numero) {
        if (numero < 1 || numero > 4) {
            throw new RuntimeException("Numero Invalido");
        }
    }

    private void validarNumeroDigitadoSubMenu(Integer numero, int numInicial, int numFinal) {
        if (numero < numInicial || numero > numFinal) {
            throw new RuntimeException("Numero Invalido");
        }
    }

    public void exibirOpcaoVoltar() {
        System.out.print("\nDeseja voltar? [y]: ");
        Scanner opcaoVoltar = new Scanner(System.in);
        String opcaoVoltarDigitada = opcaoVoltar.nextLine();
    }

    public Integer criarMenuAlterarProduto() {
        Integer numeroDigitado = 0;

        try {
            System.out.print("\n=============================================================================");
            System.out.println("\n\n Alterar produto \n\n" +
                    "1 - Nome \n" +
                    "2 - Quantidade \n" +
                    "3 - Valor \n" +
                    "4 - Tipo \n" +
                    "\n5 - Cancelar ");

            System.out.print("\nEntre com a opção [number]: ");
            Scanner opcao = new Scanner(System.in);
            numeroDigitado = opcao.nextInt();

            validarNumeroDigitadoSubMenu(numeroDigitado, 1 ,5);

            System.out.print("\n=============================================================================");
        } catch (Exception exception) {
            System.out.println("Entrada inválida, é necessario digitar um numero entre 1 e 5.");
            criarMenu();
        }

        return numeroDigitado;
    }

    public Integer criarMenuAlterarFornecedor() {
        Integer numeroDigitado = 0;

        try {
            System.out.print("\n=============================================================================");
            System.out.println("\n\n Alterar Fornecedor \n\n" +
                    "1 - Nome \n" +
                    "2 - Telefone \n" +
                    "\n3 - Cancelar ");

            System.out.print("\nEntre com a opção [number]: ");
            Scanner opcao = new Scanner(System.in);
            numeroDigitado = opcao.nextInt();

            validarNumeroDigitadoSubMenu(numeroDigitado, 1 ,3);

            System.out.print("\n=============================================================================");
        } catch (Exception exception) {
            System.out.println("Entrada inválida, é necessario digitar um numero entre 1 e 5.");
            criarMenu();
        }

        return numeroDigitado;
    }


    public Integer criarMenuAlterarCliente() throws ErroInternoException {
        Integer numeroDigitado = 0;

        try {
            System.out.print("\n=============================================================================");
            System.out.println("\n\n Alterar Cliente \n\n" +
                    "1 - Nome \n" +
                    "2 - Email \n" +
                    "3 - Idade \n" +
                    "4 - Canelar");

            System.out.print("\nEntre com a opção [number]: ");
            Scanner opcao = new Scanner(System.in);
            numeroDigitado = opcao.nextInt();

            validarNumeroDigitadoSubMenu(numeroDigitado,1, 4);

            System.out.print("\n=============================================================================");
        } catch (Exception exception) {
            throw new ErroInternoException("Entrada inválida, é necessario digitar um numero entre 1 e 4.");
        }

        return numeroDigitado;
    }
}
