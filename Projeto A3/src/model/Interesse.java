//classe para interesses
package model;

public enum Interesse {
    IA_RESPONSAVEL("IA Responsável"),
    CIBERSEGURANCA("Cibersegurança"),
    PRIVACIDADE_ETICA("Privacidade & Ética Digital");

    private String descricao;

    Interesse(String descricao) {
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }
}
