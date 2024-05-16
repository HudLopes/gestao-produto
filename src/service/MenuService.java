package service;

import model.Produto;

import java.math.BigDecimal;
import java.util.Scanner;

public class MenuService {

    public Integer criarMenu() {
        Integer numeroDigitado = 0;

        try {
            System.out.print("\n=============================================================================");
            System.out.println("\n\n Gestão de Estoque \n\n" +
                    "1 - Adicionar produto \n" +
                    "2 - Remover produto \n" +
                    "3 - Atualizar produto \n" +
                    "4 - Visualizar produtos \n" +
                    "\n5 - Sair ");

            System.out.print("\nEntre com a opção [number]: ");
            Scanner opcao = new Scanner(System.in);
            numeroDigitado = opcao.nextInt();

            validarNumeroDigitado(numeroDigitado);

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

        produto.setQuantidade(10);
        produto.setValor(BigDecimal.TEN);
        produto.setTipo("Avon");

        return produto;
    }

    public String criarMenuRemoverProduto() {
        Scanner sc = new Scanner(System.in);

        System.out.print("\n\nEntre com o codigo do produto à ser removido: ");
        return sc.nextLine();
    }

    private void validarNumeroDigitado(Integer numero) {
        if (numero < 1 || numero > 5) {
            throw new RuntimeException("Numero Invalido");
        }
    }

    public void exibirOpcaoVoltar() {
        System.out.print("\nDeseja voltar? [y/n]: ");
        Scanner opcaoVoltar = new Scanner(System.in);
        String opcaoVoltarDigitada = opcaoVoltar.nextLine();
    }

}
