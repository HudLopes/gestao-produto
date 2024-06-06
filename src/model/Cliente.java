package model;

public class Cliente {

    private String codigo;
    private String nome;
    private String email;
    private Integer idade;

    public Cliente(String nome, String codigo, String email, Integer idade) {
        this.nome = nome;
        this.codigo = codigo;
        this.email = email;
        this.idade = idade;
    }

    public Cliente() {
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
