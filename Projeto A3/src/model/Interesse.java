//classe para interesses
package model;

public enum Interesse {
    IA ("IA Responsável"),
    CIBERSEGURANÇA ("Cibersegurança"),
    PRIVACIDADE ("Privacidade e etica digital");

    private final String descricao;

    Interesse(String descricao){
        this.descricao = descricao;
    }
    public String getDescricao(){
        return descricao;
    }
    @Override
    public String toString(){
        return descricao;
    }
}
