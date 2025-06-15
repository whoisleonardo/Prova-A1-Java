package model;

public class Playlist extends Midia {

    private String descricao;

    public Playlist(String titulo, String artista, int duracao, String descricao) {
        super(titulo, artista, duracao);
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    @Override
    public String toString() {
        return super.toString()
                + "\nDescrição: " + descricao;
    }

    @Override
    public void reproduzir() {
        System.out.println("Reproduzindo playlist: " + getTitulo() + " de " + getArtista());
    }

    public String toText() {
        return getTitulo() + ";" + getArtista() + ";" + getDuracao() + ";" + descricao;
    }

    public static Playlist fromText(String texto) {
        String[] partes = texto.split(";");
        String titulo = partes[0];
        String artista = partes[1];
        int duracao = Integer.parseInt(partes[2]);
        String descricao = partes[3];
        return new Playlist(titulo, artista, duracao, descricao);
    }
}
