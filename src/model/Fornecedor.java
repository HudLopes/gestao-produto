package model;

public class Fornecedor {

    private String codigo;
    private String nome;
    private String cnpj;
    private String telefone;

    public Fornecedor(String codigo, String nome, String cnpj, String telefone) {
        this.nome = nome;
        this.codigo = codigo;
        this.cnpj = cnpj;
        this.telefone = telefone;
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

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    @Override
    public String toString() {
        return "Fornecedor{" +
                "codigo='" + codigo + '\'' +
                ", nome='" + nome + '\'' +
                ", cnpj='" + cnpj + '\'' +
                ", telefone='" + telefone + '\'' +
                '}';
    }
}
