package view;

public class MenuPrincipal {

    public static void exibirMenu() {
        System.out.println("\n=== Menu Principal ===");
        System.out.println("1) Menu Música");
        System.out.println("2) Menu Playlist");
        System.out.println("0) Sair");
        System.out.print("Escolha uma opção: \n");
    }

    public static void exibirMenuMusica() {
        System.out.println("\n=== Menu Música ===");
        System.out.println("1) Adicionar Música");
        System.out.println("2) Listar Músicas");
        System.out.println("3) Remover Música");
        System.out.println("4) Buscar Música");
        System.out.println("5) Reproduzir Música");
        System.out.println("6) Voltar");
        System.out.print("Escolha uma opção: \n");
    }

    public static void exibirMenuPlaylist() {
        System.out.println("\n=== Menu Playlist ===");
        System.out.println("1) Criar nova Playlist");
        System.out.println("2) Adicionar Música à Playlist");
        System.out.println("3) Remover Música da Playlist");
        System.out.println("4) Listar Músicas da Playlist");
        System.out.println("5) Buscar Música na Playlist");
        System.out.println("6) Reproduzir Playlist");
        System.out.println("7) Voltar");
        System.out.print("\nEscolha uma opção: \n");
    }

    public static void exibirMensagem(String mensagem) {
        System.out.println(mensagem);
    }
}