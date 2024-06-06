package service;

import exception.ErroInternoException;
import model.Cliente;
import model.Produto;
import service.contrato.CrudService;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ClienteServiceImpl implements CrudService<Cliente> {

    @Override
    public Cliente buscar(List<Cliente> lista, String codigo) throws ErroInternoException {
        for(Cliente c : lista) {
            if (c.getCodigo().equals(codigo)) {
               return c;
            }
        }
        throw new ErroInternoException("Erro ao buscar Cliente");
    }

    public void criar(List<Cliente> lista, Cliente objeto) {
        lista.add(objeto);
        System.out.println("Cliente criado com sucesso!");
    }

    public boolean remover(List<Cliente> lista, String codigo) {
        var removido = false;
        for(Cliente c : lista) {
            if (c.getCodigo().equals(codigo)) {
                lista.remove(c);
                System.out.println("Cliente removido com sucesso!");
                removido = true;
                break;
            }
        }

        if(!removido) {
            System.out.println("Cliente não encontrado");
        }
        return removido;
    }

    public void listar(List<Cliente> lista) {
        System.out.println("\n\nEstoque de clientes registrados\n");
        for (Cliente c : lista) {
            System.out.println(c.toString());
        }
    }

    @Override
    public boolean editar(List<Cliente> lista, Cliente cliente) {
        var alterado = false;
        var codigo = cliente.getCodigo();

        for(Cliente c : lista) {
            if (c.getCodigo().equals(codigo)){
                c.setNome(cliente.getNome());
                c.setEmail(cliente.getEmail());
                c.setIdade(cliente.getIdade());
                alterado = true;
            }
        }

        return alterado;
    }

    @Override
    public boolean existe(List<Cliente> lista, String codigo) {
        for(Cliente c : lista) {
            if (c.getCodigo().equals(codigo)) {
                return true;
            }
        }
        return false;
    }

    public List<Cliente> mockListaClientes() {
        return new ArrayList<>(Arrays.asList(
                new Cliente("cliente-1", "c1", "email1@gmail.com", 15),
                new Cliente("cliente-2", "c2", "email2@gmail.com", 25),
                new Cliente("cliente-3", "c3", "email3@gmail.com", 17),
                new Cliente("cliente-5", "c4", "email4@gmail.com", 32),
                new Cliente("cliente-4", "c5", "email5@gmail.com", 45)
        ));
    }
}
