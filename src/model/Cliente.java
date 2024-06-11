package model;

import java.math.BigDecimal;

public class Cliente extends Pessoa {

    private String codigo;
    private String email;
    private Integer idade;

    public Cliente(String nome) {
        super(nome);
    }

    public Cliente() {
        super();
    }

    public Cliente(String nome, String codigo, String email, Integer idade) {
        super(nome);
        this.codigo = codigo;
        this.email = email;
        this.idade = idade;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getIdade() {
        return idade;
    }

    public void setIdade(Integer idade) {
        this.idade = idade;
    }

    @Override
    public String toString() {
        return "Cliente{" +
                "codigo='" + codigo + '\'' +
                ", nome='" + nome + '\'' +
                ", email='" + email + '\'' +
                ", idade=" + idade +
                '}';
    }
}
