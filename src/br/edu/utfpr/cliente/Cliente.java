package br.edu.utfpr.cliente;

public class Cliente {
    private String nome;
    private String conta;

    public Cliente(String nome, String conta) {
        this.nome = nome;
        this.conta = conta;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getConta() {
        return conta;
    }

    public void setConta(String conta) {
        this.conta = conta;
    }
    
}
