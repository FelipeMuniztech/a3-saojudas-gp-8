//classe de usuario base para administrador e usuario comum

package model;

import java.util.ArrayList;
import java.util.List;


public class Usuario {
    private int id;
    private String nome;
    private int idade;
    private String tipo; //administrador ou usuario comum
    private List<Interesse> interesses;
    private boolean ativo;

//construtor

    public Usuario() {
        this.interesses = new ArrayList<>();
        this.ativo = true;
    }

    public Usuario(int id, String nome, int idade, String tipo) {

        this();
        this.id = id;
        this.nome = nome;
        this.idade = idade;
        this.tipo = tipo;

    }
    //getters e setters

    public boolean isAtivo() {
        return ativo;
    }
    public void setAtivo(boolean ativo) {
        this.ativo = ativo;
    }


    public String getTipo() {
        return tipo;
    }
    public void setTipo(String tipo) {
        this.tipo = tipo;
    }


    public int getIdade() {
        return idade;
    }
    public void setIdade(int idade) {
        this.idade = idade;
    }


    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }


    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }


    public List<Interesse> getInteresses() {
        return interesses;
    }
    public void setInteresses(List<Interesse> interesses) {
        this.interesses = interesses;
    }


    public boolean Administrador(){
        return "Administrador".equals(tipo);
    }
    public boolean UsuarioComum(){
        return "Usuario Comum".equals(tipo);
    }

    // permissões
    public boolean gerenciarUsuarios(){
        return Administrador();
    }

    //metodo para definir interesses
    public boolean adicionarInteresse(Interesse interesse) {
        if (interesses.size() < 2 && !interesses.contains(interesse)) {
        interesses.add(interesse);
        return true;
        }
        return false;
    }
}
