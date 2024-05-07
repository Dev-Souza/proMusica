package br.com.musical.proMusica.principal;

import br.com.musical.proMusica.model.Artista;
import br.com.musical.proMusica.model.Musica;
import br.com.musical.proMusica.model.TipoArtista;
import br.com.musical.proMusica.repository.ArtistaRepository;

import java.util.List;
import java.util.Locale;
import java.util.Optional;
import java.util.Scanner;

public class Principal {
    private Scanner leitura = new Scanner(System.in);
    private ArtistaRepository repositorio;

    public Principal(ArtistaRepository repositorio) {
        this.repositorio = repositorio;
    }

    public void exibeMenu() {
        var opcao = 0;
        //loop do meu menu
        while (opcao != 9) {
            System.out.println("""
                    1- Cadastrar artistas
                    2- Cadastrar musicas
                    3- Listar musicas
                    4- Listar artistas
                    5- Buscar músicas por artistas
                                    
                    9- Sair
                    """);

            //Pegar a opção do usuário
            opcao = leitura.nextInt();
            leitura.nextLine();
            switch (opcao) {
                case 1:
                    cadastrarArtistas();
                    break;
                case 2:
                    cadastrarMusicas();
                    break;
                case 3:
                    listarMusicas();
                    break;
                case 4:
                    listarArtistas();
                    break;
                case 5:
                    buscarMusicasPorArtistas();
                    break;
                case 9:
                    System.out.println("Saindo...");
                    break;
                default:
                    System.out.println("Não existe essa opção!");
            }
        }
    }

    //Função para se criar um artista
    private void cadastrarArtistas() {
        var opcaoCadastrar = "S";

        while (opcaoCadastrar.equalsIgnoreCase("s")) {
            // Função para se pegar nome de artista
            System.out.println("Informe o nome do artista:");
            var nomeDoArtista = leitura.nextLine();

            //Função para se pegar o tipo daquele artista: SOLO, DUETO ou BANDA
            System.out.println("Informe o tipo desse artista:");
            var tipo = leitura.nextLine();
            TipoArtista tipoArtista = TipoArtista.valueOf(tipo.toUpperCase());

            Artista artista = new Artista(nomeDoArtista, tipoArtista);

            //Função para salvar as informações no banco
            repositorio.save(artista);

            System.out.println("Deseja cadastrar outro artista? (S/N)");
            opcaoCadastrar = leitura.nextLine();
        }
    }

    //Função para cadastrar uma música
    private void cadastrarMusicas() {
        System.out.println("Cadastrar música de que artista? ");
        var nome = leitura.nextLine();
        Optional<Artista> artista = repositorio.findByNomeDoArtistaContainingIgnoreCase(nome);
        if (artista.isPresent()) {
            System.out.println("Informe o título da música: ");
            var nomeMusica = leitura.nextLine();
            Musica musica = new Musica(nomeMusica);
            musica.setArtistas(artista.get());
            artista.get().getMusicas().add(musica);
            repositorio.save(artista.get());
        } else {
            System.out.println("Artista não encontrado");
        }
    }

    // Função para se Listar todas
    private void listarMusicas() {
        List<Artista> listaDeMusicas = repositorio.findAll();
        listaDeMusicas.forEach(m -> m.getMusicas().forEach(System.out::println));
    }

    //Função para listar todos os artistas
    private void listarArtistas() {
        List<Artista> listaDeArtistas = repositorio.findAll();
        listaDeArtistas.forEach(a -> {
            System.out.println("Nome: " + a.getNomeDoArtista());
            System.out.println("Tipo: " + a.getTipoArtista());
            List<Musica> musicas = a.getMusicas();
            if (!musicas.isEmpty()) {
                System.out.println("---Músicas deste artista---");
                musicas.forEach(m -> System.out.println(m.getNomeDaMusica()));
                System.out.println("\n******************************************\n");
            } else {
                System.out.println("Nenhuma música encontrada para este artista.\n");
            }
        });
    }

    private void buscarMusicasPorArtistas() {
    }
}
