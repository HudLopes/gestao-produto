package service.contrato;

import java.util.List;

public interface CrudService<T> {

    T buscar(List<T> lista, String codigo);
    void criar(List<T> lista, T item);
    boolean remover(List<T> lista, String codigo);
    void listar(List<T> lista);
    boolean editar(List<T> lista, T item);
    boolean existe(List<T> lista, String codigo);
}
