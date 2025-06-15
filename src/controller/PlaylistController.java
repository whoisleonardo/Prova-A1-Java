package controller;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import model.Musica;

public class PlaylistController {

    private static final String ARQUIVO = "playlist.txt";
    private List<Musica> playlist;

    public PlaylistController() {
        playlist = new ArrayList<>();
    }

    public void criarPlaylist() {
        playlist.clear();
        try (PrintWriter pw = new PrintWriter(new FileWriter(ARQUIVO))) {
        } catch (IOException e) {
            System.err.println("Erro ao criar nova playlist: " + e.getMessage());
        }
    }

    public void carregar() {
        File file = new File(ARQUIVO);
        if (!file.exists()) {
            return;
        }
        playlist.clear();
        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String linha;
            while ((linha = br.readLine()) != null) {
                playlist.add(Musica.fromText(linha));
            }
        } catch (IOException e) {
            System.err.println("Erro ao carregar playlist: " + e.getMessage());
        }
    }

    public void salvar(Musica musica) {
        try (PrintWriter pw = new PrintWriter(new FileWriter(ARQUIVO, true))) {
            pw.println(musica.toText());
        } catch (IOException e) {
            System.err.println("Erro ao salvar música na playlist: " + e.getMessage());
        }
    }

    public void salvar() {
        try (PrintWriter pw = new PrintWriter(new FileWriter(ARQUIVO))) {
            for (Musica musica : playlist) {
                pw.println(musica.toText());
            }
        } catch (IOException e) {
            System.err.println("Erro ao salvar playlist: " + e.getMessage());
        }
    }

    public void adicionarMusica(Musica musica) {
        playlist.add(musica);
        salvar(musica);
    }

    public boolean removerMusica(String titulo) {
        for (Musica musica : playlist) {
            if (musica.getTitulo().equalsIgnoreCase(titulo)) {
                playlist.remove(musica);
                salvar(); 
                carregar();
                return true;
            }
        }
        return false;
    }

        public Musica buscarMusica(String titulo) {
        for (Musica musica : playlist) {
            if (musica.getTitulo().equalsIgnoreCase(titulo)) {
                return musica;
            }
        }
        return null;
    }

    public List<Musica> getPlaylist() {
        return Collections.unmodifiableList(playlist);
    }
}