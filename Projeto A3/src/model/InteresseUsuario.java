package model;

public class InteresseUsuario {
    private int usuarioId;
    private int categoriaId;

    public InteresseUsuario(int usuarioId, int categoriaId) {
        this.usuarioId = usuarioId;
        this.categoriaId = categoriaId;
    }

    public int getUsuarioId() { return usuarioId; }
    public int getCategoriaId() { return categoriaId; }
}
