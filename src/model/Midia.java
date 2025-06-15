package model;

public abstract class Midia implements Reproduzivel {

    private String titulo;
    private String artista;
    private int duracao;

    public Midia(String titulo, String artista, int duracao) {
        this.titulo = titulo;
        this.artista = artista;
        this.duracao = duracao;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getArtista() {
        return artista;
    }

    public void setArtista(String artista) {
        this.artista = artista;
    }

    public int getDuracao() {
        return duracao;
    }

    public void setDuracao(int duracao) {
        this.duracao = duracao;
    }

    @Override
    public String toString() {
        return "Titulo: " + titulo + "\n" +
            "Artista: " + artista + "\n" +
            "Duração: " + duracao + " minutos";
    }
}
