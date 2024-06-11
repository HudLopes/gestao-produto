package model;

public class Pessoa {
    String nome;

    public Pessoa(String nome) {
        this.nome = nome;
    }


    public Pessoa() {
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}
