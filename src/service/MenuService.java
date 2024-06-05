package service;

import enums.TipoOperacao;
import model.Produto;

import java.util.Scanner;

public class MenuService {

    public Integer criarMenu() {
        Integer numeroDigitado = 0;

        try {
            System.out.print("\n=============================================================================");
            System.out.println("\n\n Gestão de Estoque \n\n" +
                    "1 - Clientes \n" +
                    "2 - Fornecedores \n" +
                    "3 - Produtos \n" +
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

            validarNumeroDigitadoSubMenu(numeroDigitado);

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

    public String criarMenuCapturarCodigoProduto() {
        Scanner sc = new Scanner(System.in);

        System.out.print("\n\nEntre com o codigo do produto: ");
        return sc.nextLine();
    }

    private void validarNumeroDigitadoMenu(Integer numero) {
        if (numero < 1 || numero > 4) {
            throw new RuntimeException("Numero Invalido");
        }
    }

    private void validarNumeroDigitadoSubMenu(Integer numero) {
        if (numero < 1 || numero > 5) {
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

            validarNumeroDigitadoSubMenu(numeroDigitado);

            System.out.print("\n=============================================================================");
        } catch (Exception exception) {
            System.out.println("Entrada inválida, é necessario digitar um numero entre 1 e 5.");
            criarMenu();
        }

        return numeroDigitado;
    }
}
