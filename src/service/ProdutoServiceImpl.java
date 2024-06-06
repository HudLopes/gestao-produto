package service;

import exception.ErroInternoException;
import model.Produto;
import service.contrato.CrudService;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ProdutoServiceImpl implements CrudService<Produto> {

    @Override
    public Produto buscar(List<Produto> listaProdutos, String codigoProduto) throws ErroInternoException {
        for(Produto p : listaProdutos) {
            if (p.getCodigo().equals(codigoProduto)) {
               return p;
            }
        }
        throw new ErroInternoException("Erro ao buscar produto");
    }

    public void criar(List<Produto> listaProdutos, Produto novoProduto) {
        listaProdutos.add(novoProduto);
        System.out.println("Produto criado com sucesso!");
    }

    public boolean remover(List<Produto> listaProdutos, String codigoProduto) {
        var removido = false;
        for(Produto p : listaProdutos) {
            if (p.getCodigo().equals(codigoProduto)) {
                listaProdutos.remove(p);
                System.out.println("Produto removido com sucesso!");
                removido = true;
                break;
            }
        }

        if(!removido) {
            System.out.println("Produto não encontrado");
        }
        return removido;
    }

    public void listar(List<Produto> listaProdutos) {
        System.out.println("\n\nEstoque de produtos registrados\n");
        for (Produto produto : listaProdutos) {
            System.out.println(produto.print());
        }
    }

    @Override
    public boolean editar(List<Produto> listaProdutos, Produto produto) {
        var alterado = false;
        var codigoProduto = produto.getCodigo();

        for(Produto p : listaProdutos) {
            if (p.getCodigo().equals(codigoProduto)){
                p.setNome(produto.getNome());
                p.setValor(produto.getValor());
                p.setTipo(produto.getTipo());
                p.setQuantidade(produto.getQuantidade());
                alterado = true;
            }
        }

        return alterado;
    }

    @Override
    public boolean existe(List<Produto> listaProdutos, String codigoProduto) {
        for(Produto p : listaProdutos) {
            if (p.getCodigo().equals(codigoProduto)) {
                return true;
            }
        }
        return false;
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
