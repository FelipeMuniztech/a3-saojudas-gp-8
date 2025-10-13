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
// Getters
    public int getId() { return id; }
    public String getNome() { return nome; }
    public int getIdade() { return idade; }
    public String getTipo() { return tipo; }
    public String getSenha() { return senha; }
    public Boolean getAtivo() { return ativo; }

    // Setters
    public void setId(int id) { this.id = id; }
    public void setNome(String nome) { this.nome = nome; }
    public void setIdade(int idade) { this.idade = idade; }
    public void setTipo(String tipo) { this.tipo = tipo; }
    public void setSenha(String senha) { this.senha = senha; }
    public void setAtivo(Boolean ativo) { this.ativo = ativo; }
}

    


