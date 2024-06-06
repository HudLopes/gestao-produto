package service;

import model.Cliente;
import model.Fornecedor;
import service.contrato.CrudService;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FornecedoresServiceImpl implements CrudService<Fornecedor> {

    @Override
    public Fornecedor buscar(List<Fornecedor> lista, String codigo) {
        for(Fornecedor c : lista) {
            if (c.getCodigo().equals(codigo)) {
               return c;
            }
        }
        throw new RuntimeException("O Fornecedor não existe");
    }

    public void criar(List<Fornecedor> lista, Fornecedor objeto) {
        lista.add(objeto);
        System.out.println("Fornecedor criado com sucesso!");
    }

    public boolean remover(List<Fornecedor> lista, String codigo) {
        var removido = false;
        for(Fornecedor c : lista) {
            if (c.getCodigo().equals(codigo)) {
                lista.remove(c);
                System.out.println("Fornecedor removido com sucesso!");
                removido = true;
                break;
            }
        }

        if(!removido) {
            System.out.println("Fornecedor não encontrado");
        }
        return removido;
    }

    public void listar(List<Fornecedor> lista) {
        System.out.println("\n\nEstoque de Fornecedores registrados\n");
        for (Fornecedor c : lista) {
            System.out.println(c.toString());
        }
    }

    @Override
    public boolean editar(List<Fornecedor> lista, Fornecedor objeto) {
        var alterado = false;
        var codigo = objeto.getCodigo();

        for(Fornecedor c : lista) {
            if (c.getCodigo().equals(codigo)){
                c.setNome(objeto.getNome());
                c.setTelefone(objeto.getTelefone());
                c.setCnpj(objeto.getCnpj());
                alterado = true;
            }
        }

        return alterado;
    }

    @Override
    public boolean existe(List<Fornecedor> lista, String codigo) {
        for(Fornecedor c : lista) {
            if (c.getCodigo().equals(codigo)) {
                return true;
            }
        }
        return false;
    }

    public List<Fornecedor> mockListaFornecedores() {
        return new ArrayList<>(Arrays.asList(
                new Fornecedor("f1", "Fornecedor 1", "12304560651", "81988888888"),
                new Fornecedor("f2", "Fornecedor 2", "12304560651", "81988888888"),
                new Fornecedor("f3", "Fornecedor 3", "12304560651", "81988888888"),
                new Fornecedor("f5", "Fornecedor 4", "12304560651", "81988888888"),
                new Fornecedor("f4", "Fornecedor 5", "12304560651", "81988888888")
        ));
    }
}
