package enums;

public enum TipoOperacao {
    CLIENTE("cliente"),
    PRODUTO("produto"),
    FORNECEDOR("fornecedor");

    private String nome;

    TipoOperacao(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }
}
