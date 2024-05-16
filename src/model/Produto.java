package model;

import java.math.BigDecimal;

public class Produto {

    private String codigo;
    private String nome;
    private Integer quantidade;
    private BigDecimal valor;
    private String tipo;

    public Produto(String codigo, String nome, Integer quantidade, BigDecimal valor, String tipo) {
        this.codigo = codigo;
        this.nome = nome;
        this.quantidade = quantidade;
        this.valor = valor;
        this.tipo = tipo;
    }

    public Produto() {
    }

    public String print() {
        return this.codigo + ", " +
                this.nome + ", " +
                this.quantidade.toString() + ", " +
                this.valor.toString() + ", " +
                this.tipo;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Integer getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(Integer quantidade) {
        this.quantidade = quantidade;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public void setValor(BigDecimal valor) {
        this.valor = valor;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
}
