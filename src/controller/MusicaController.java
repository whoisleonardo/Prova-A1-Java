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

import model.Midia;
import model.Musica;

public class MusicaController {

    private static final String ARQUIVO = "musicas.txt";
    private List<model.Midia> musicas;

    public MusicaController() {
        musicas = new ArrayList<>();
    }

    public void carregar(){

        File file = new File(ARQUIVO);
        if(!file.exists()) {
            return;
        }

        musicas.clear();

        try(BufferedReader br = new BufferedReader(new FileReader(file))){
            String musicaAtual;

            while ((musicaAtual = br.readLine()) != null) {
                
                musicas.add(Musica.fromText(musicaAtual));
                
            } 
        } catch (IOException e) {
            System.err.println("Erro ao carregar dados do arquivo: " + e.getMessage());
        }
    }

        public void salvar(Musica musica) {
        try (PrintWriter pw = new PrintWriter(new FileWriter(ARQUIVO, true))) {
            pw.println(musica.toText());
        } catch (IOException e) {
            System.err.println("Erro ao salvar no arquivo de texto: " + e.getMessage());
        }
    }

    public void salvar() {
        try (PrintWriter pw = new PrintWriter(new FileWriter(ARQUIVO))) {
            for (Midia musica : musicas) {
                if (musica instanceof Musica) {
                    pw.println(((Musica) musica).toText());
                }
            }
        } catch (IOException e) {
            System.err.println("Erro ao salvar no arquivo de texto: " + e.getMessage());
        }
    }

    public void adicionar(Musica musica) {
        musicas.add(musica);
        salvar(musica);
    }

    public boolean remover(String titulo) {
        for (Midia temp : musicas) {
            if (temp.getTitulo().equalsIgnoreCase(titulo)) {
                musicas.remove(temp);
                salvar();
                carregar();
                return true;
            }
        }
        return false; 
    }

    public List<Midia> getListaMusicas() {
        return Collections.unmodifiableList(musicas);
    }
}
