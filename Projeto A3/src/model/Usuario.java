//classe de usuario base para administrador e usuario comum
package model;

import java.util.ArrayList;
import java.util.List;

public class Usuario {
    private int id;
    private String nome;
    private int idade;
    private String tipo; // "ADMIN" ou "COMUM"
    private String username;
    private String password;
    private boolean ativo;
    private List<Interesse> interesses;

    public Usuario(int id, String nome, int idade, String tipo) {
        this.id = id;
        this.nome = nome;
        this.idade = idade;
        this.tipo = tipo;
        this.interesses = new ArrayList<>();
    }

    public Usuario(String nome, int idade, String tipo, String username, String password) {
        this.nome = nome;
        this.idade = idade;
        this.tipo = tipo;
        this.username = username;
        this.password = password;
        this.ativo = true;
        this.interesses = new ArrayList<>();
    }

    // Getters e Setters
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }

    public int getIdade() { return idade; }
    public void setIdade(int idade) { this.idade = idade; }

    public String getTipo() { return tipo; }
    public void setTipo(String tipo) { this.tipo = tipo; }

    public String getUsername() { return username; }
    public void setUsername(String username) { this.username = username; }

    public String getPassword() { return password; }
    public void setPassword(String password) { this.password = password; }

    public boolean isAtivo() { return ativo; }
    public void setAtivo(boolean ativo) { this.ativo = ativo; }

    public List<Interesse> getInteresses() { return interesses; }
    public void adicionarInteresse(Interesse interesse) {
        if (interesses.size() < 2) {
            interesses.add(interesse);
        }
    }

    @Override
    public String toString() {
        return nome + " (" + tipo + ")";
    }
}
