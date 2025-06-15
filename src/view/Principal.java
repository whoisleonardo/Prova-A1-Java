package view;

import controller.MusicaController;
import controller.PlaylistController;
import model.Musica;
import console.Console;

public class Principal {
    public static void main(String[] args) {
        MusicaController musicaController = new MusicaController();
        PlaylistController playlistController = new PlaylistController();

        int OP;
        do {
            MenuPrincipal.exibirMenu();
            OP = Console.lerInt();

            switch (OP) {
                case 1:
                    menuMusica(musicaController);
                    break;
                case 2:
                    menuPlaylist(playlistController, musicaController);
                    break;
                case 0:
                    MenuPrincipal.exibirMensagem("Saindo...");
                    break;
                default:
                    MenuPrincipal.exibirMensagem("Opção inválida!");
            }
        } while (OP != 0);
    }

    private static void menuMusica(MusicaController musicaController) {
        int OP;
        do {
            MenuPrincipal.exibirMenuMusica();
            OP = Console.lerInt();

            switch (OP) {
                case 1:
                    System.out.print("Título: ");
                    String titulo = Console.lerString();
                    System.out.print("Artista: ");
                    String artista = Console.lerString();
                    System.out.print("Duração (segundos): ");
                    int duracao = Console.lerInt();
                    System.out.print("Gênero: ");
                    String genero = Console.lerString();
                    System.out.print("Álbum: ");
                    String album = Console.lerString();
                    Musica musica = new Musica(titulo, artista, duracao, genero, album);
                    musicaController.adicionar(musica);
                    MenuPrincipal.exibirMensagem("\nMúsica adicionada!");
                    break;
                case 2:
                    for (var m : musicaController.getListaMusicas()) {
                        System.out.println(m);
                        System.out.println("-------------------");
                    }
                    break;
                case 3:
                    System.out.print("\nTítulo da música para remover: ");
                    String tituloRemover = Console.lerString();
                    if (musicaController.remover(tituloRemover)) {
                        MenuPrincipal.exibirMensagem("Música removida!");
                    } else {
                        MenuPrincipal.exibirMensagem("Música não encontrada!");
                    }
                    break;
                case 4:
                    System.out.print("\nTítulo da música para buscar: ");
                    String tituloBuscar = Console.lerString();
                    var lista = musicaController.getListaMusicas();
                    boolean encontrada = false;
                    for (var m : lista) {
                        if (m.getTitulo().equalsIgnoreCase(tituloBuscar)) {
                            System.out.println(m);
                            encontrada = true;
                        }
                    }
                    if (!encontrada) {
                        MenuPrincipal.exibirMensagem("Música não encontrada!");
                    }
                    break;
                case 5:
                    System.out.print("\nTítulo da música para reproduzir: ");
                    String tituloReproduzir = Console.lerString();
                    for (var m : musicaController.getListaMusicas()) {
                        if (m.getTitulo().equalsIgnoreCase(tituloReproduzir)) {
                            m.reproduzir();
                        }
                    }
                    break;
                case 6:
                    break;
                default:
                    MenuPrincipal.exibirMensagem("Opção inválida!");
            }
        } while (OP != 6);
    }

    private static void menuPlaylist(PlaylistController playlistController, MusicaController musicaController) {
        int OP;
        do {
            MenuPrincipal.exibirMenuPlaylist();
            OP = Console.lerInt();

            switch (OP) {
                case 1:
                    playlistController.criarPlaylist();
                    MenuPrincipal.exibirMensagem("\nNova playlist criada!");
                    break;
                case 2:
                    System.out.print("\nTítulo da música para adicionar à playlist: ");
                    String tituloAdd = Console.lerString();
                    Musica musicaAdd = null;
                    for (var m : musicaController.getListaMusicas()) {
                        if (m.getTitulo().equalsIgnoreCase(tituloAdd)) {
                            musicaAdd = (Musica) m;
                            break;
                        }
                    }
                    if (musicaAdd != null) {
                        playlistController.adicionarMusica(musicaAdd);
                        MenuPrincipal.exibirMensagem("Música adicionada à playlist!");
                    } else {
                        MenuPrincipal.exibirMensagem("Música não encontrada!");
                    }
                    break;
                case 3:
                    System.out.print("\nTítulo da música para remover da playlist: ");
                    String tituloRemover = Console.lerString();
                    if (playlistController.removerMusica(tituloRemover)) {
                        MenuPrincipal.exibirMensagem("Música removida da playlist!");
                    } else {
                        MenuPrincipal.exibirMensagem("Música não encontrada na playlist!");
                    }
                    break;
                case 4:
                    for (var m : playlistController.getPlaylist()) {
                        System.out.println(m);
                        System.out.println("-------------------");
                    }
                    break;
                case 5:
                    System.out.print("\nTítulo da música para buscar na playlist: ");
                    String tituloBuscar = Console.lerString();
                    var musica = playlistController.buscarMusica(tituloBuscar);
                    if (musica != null) {
                        System.out.println(musica);
                    } else {
                        MenuPrincipal.exibirMensagem("Música não encontrada na playlist!");
                    }
                    break;
                case 6:
                    System.out.println("\nReproduzindo playlist:");
                    for (var m : playlistController.getPlaylist()) {
                        m.reproduzir();
                    }
                    break;
                case 7:
                    break;
                default:
                    MenuPrincipal.exibirMensagem("Opção inválida!");
            }
        } while (OP != 7);
    }
}