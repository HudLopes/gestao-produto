package service;

import model.Produto;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ProdutoService {

    public void criarProduto(List<Produto> listaProdutos, Produto novoProduto) {
        listaProdutos.add(novoProduto);
        System.out.println("Produto criado com sucesso!");
    }

    public void removerProduto(List<Produto> listaProdutos, String codigoProduto) {
        var produto = listaProdutos.stream()
                .filter(p -> p.getCodigo().equals(codigoProduto))
                .findFirst()
                .orElseThrow(() -> new RuntimeException("O produto não existe"));

//        for(Produto p : listaProdutos) {
//            if (p.getCodigo().equals(codigoProduto)){
//                listaProdutos.remove(p);
//                System.out.println("Produto removido com sucesso!");
//            } else {
//                throw new RuntimeException("O produto não existe");
//            }
//        }

        listaProdutos.remove(produto);
        System.out.println("Produto removido com sucesso!");
    }

    public void listarProdutos(List<Produto> listaProdutos) {
        System.out.println("\n\nEstoque de produtos registrados\n");
        for (Produto produto : listaProdutos) {
            System.out.println(produto.print());
        }
    }

    public List<Produto> mockListaProdutos() {
        return new ArrayList<>(Arrays.asList(
                new Produto("gestoq-1", "Produto 1", 5, new BigDecimal("100.00"), "Eudora"),
                new Produto("gestoq-2", "Produto 2", 5, new BigDecimal("100.00"), "Natura"),
                new Produto("gestoq-3", "Produto 3", 5, new BigDecimal("100.00"), "Avon"),
                new Produto("gestoq-5", "Produto 4", 5, new BigDecimal("100.00"), "Sephora"),
                new Produto("gestoq-4", "Produto 5", 5, new BigDecimal("100.00"), "MaryKay")
        ));
    }
}
