package model;

public class Usuario {
    private int id;
    private String nome;
    private int idade;
    private String tipo;
    private String senha;
    public Usuario(int id, String nome, int idade, String tipo, String senha, Boolean ativo) {
        this.id = id;
        this.nome = nome;
        this.idade = idade;
        this.tipo = tipo;
        this.senha = senha;
        this.ativo = ativo;
    }
    private Boolean ativo;

    
}
