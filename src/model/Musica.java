package model;

public class Musica extends Midia {

    private String genero;
    private String album;
    
    public Musica(String titulo, String artista, int duracao, String genero, String album) {
        super(titulo, artista, duracao);
        this.genero = genero;
        this.album = album;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getAlbum() {
        return album;
    }

    public void setAlbum(String album) {
        this.album = album;
    }

    @Override
    public String toString() {
        return super.toString()
                + "\nGênero: " + genero
                + "\nÁlbum: " + album;
    }

    @Override
    public void reproduzir() {
        System.out.println("Reproduzindo música: " + getTitulo() + " de " + getArtista());
    }

    public String toText() {
        return getTitulo() + ";" + getArtista() + ";" + getDuracao() + ";" + genero + ";" + album;
    }

    public static Musica fromText(String texto) {
        String[] partes = texto.split(";");
        String titulo = partes[0];
        String artista = partes[1];
        int duracao = Integer.parseInt(partes[2]);
        String genero = partes[3];
        String album = partes[4];
        return new Musica(titulo, artista, duracao, genero, album);
    }
}
