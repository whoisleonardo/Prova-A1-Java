# Projeto A1-Java: Gerenciador de Músicas e Playlists

## Informações Gerais sobre o Projeto

Este projeto é um sistema simples de gerenciamento de músicas e playlists desenvolvido em Java. O objetivo principal é permitir ao usuário cadastrar, listar, buscar, remover e reproduzir músicas, além de criar e gerenciar playlists personalizadas. O sistema utiliza persistência em arquivos de texto para armazenar as informações de músicas e playlists, garantindo que os dados sejam mantidos entre execuções.

### Funcionalidades Principais

- Cadastro de músicas com título, artista, duração, gênero e álbum.
- Listagem, busca, remoção e reprodução de músicas.
- Criação de playlists, adição e remoção de músicas na playlist.
- Listagem, busca e reprodução de músicas da playlist.
- Persistência dos dados em arquivos `.txt`.

---

## Informações sobre as Classes e suas Relações

### Estrutura de Classes

- **Midia**: Classe base (superclasse) para Musica e Playlist. Contém atributos comuns como título, artista e duração.
- **Musica**: Herda de Midia. Adiciona atributos específicos como gênero e álbum. Possui métodos para serialização (`toText`/`fromText`) e reprodução.
- **Playlist**: Herda de Midia. Adiciona o atributo descrição. Possui métodos para serialização e reprodução.
- **MusicaController**: Gerencia a lista de músicas (adicionar, remover, buscar, salvar/carregar do arquivo).
- **PlaylistController**: Gerencia a playlist (adicionar/remover músicas, salvar/carregar do arquivo).
- **MenuPrincipal**: Responsável por exibir os menus principais e de navegação.
- **Principal**: Classe principal que executa o fluxo do programa, interagindo com o usuário.
- **Console**: Utilitário para entrada de dados do usuário, com tratamento de erros.

### Relações entre as Classes

- **Herança**: Musica e Playlist herdam de Midia.
- **Associação**: MusicaController e PlaylistController mantêm listas de objetos Musica.
- **Composição**: PlaylistController compõe uma playlist a partir de objetos Musica.
- **Associação**: A classe Principal utiliza os controllers para manipular os dados e interagir com o usuário.

---

## Como Executar o Projeto

1. **Pré-requisitos**:  
   - Java JDK instalado (versão 8 ou superior).
   - Um editor de código (recomendado: Visual Studio Code).

2. **Configuração**:  
   - Clone ou baixe o repositório do projeto.
   - Certifique-se de que todos os arquivos `.java` estejam na estrutura de pastas correta (`src/model`, `src/controller`, `src/view`, `src/console`).

3. **Compilação**:  
   No terminal, navegue até a pasta do projeto e execute:
   ```
   javac -d bin src/model/*.java src/controller/*.java src/view/*.java src/console/*.java
   ```

4. **Execução**:  
   Ainda no terminal, execute:
   ```
   java -cp bin view.Principal
   ```

5. **Uso**:  
   Siga as instruções do menu para cadastrar músicas, criar playlists e utilizar as demais funcionalidades.

---

## Uso do ChatGPT

O ChatGPT foi utilizado em diversas etapas do desenvolvimento deste projeto, incluindo:

- **Estruturação do Projeto**: Auxílio na definição da arquitetura das classes, relações de herança e composição, e organização dos pacotes.
- **Dúvidas sobre Erros**: Esclarecimento de mensagens de erro, sugestões de correção de bugs e explicações sobre exceções e problemas de compilação.
- **Sugestões de Funcionalidades**: Recomendações de métodos adicionais, melhorias de usabilidade, persistência de dados e boas práticas de programação.

O uso do ChatGPT permitiu acelerar o desenvolvimento, garantir boas práticas e obter explicações claras sobre conceitos e problemas encontrados.

---

## Referências e Recursos

- Documentação oficial do [Java SE](https://docs.oracle.com/javase/8/docs/)
- [Oracle Java Tutorials](https://docs.oracle.com/javase/tutorial/)
- Exemplos e discussões do [Stack Overflow](https://stackoverflow.com/)
- Materiais e slides das aulas da disciplina de Desenvolvimento de Software
- ChatGPT (OpenAI) para auxílio em estruturação, dúvidas e sugestões

---

## Equipe

- Leonardo Miguel Dubena Munhoz Alves
- João Vitor Oliveira dos Santos
