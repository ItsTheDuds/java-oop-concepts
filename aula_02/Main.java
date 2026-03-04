package aula_02;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Biblioteca biblioteca = new Biblioteca();
        biblioteca.adicionarLivro("J.K Rowlling", "Harry Potter", 1997);
        biblioteca.adicionarLivro("Sun Tzu", "A Arte da Guerra", 1772);
        biblioteca.adicionarLivro("Miguel de Cervantes", "Dom Quixote", 1605);
        biblioteca.adicionarLivro("Dante Alighieri", "A Divina Comédia", 1304);

        System.out.println("=== ACERVO DE LIVROS ===");

        biblioteca.listarLivros();

        boolean programa = true; 
        int opcao;
        while (programa) {
            System.out.println("\n=== BIBLIOTECA DE LIVROS ===");
            System.out.println("1 = Adicionar Livro");
            System.out.println("2 = Listar Livros cadastrados");
            System.out.println("3 = Buscar um livro pelo Título");
            System.out.println("0 = Encerrar o programa");
            System.out.println();
            System.out.print("=== Escolha uma opção: ");
            opcao = sc.nextInt();
            sc.nextLine();
            switch (opcao) {
                case 1:
                    System.out.print("Digite o nome do autor à ser adicionado: ");
                    String autor = sc.nextLine();

                    System.out.print("Digite o título do livro à ser adicionado; ");
                    String titulo = sc.nextLine();

                    System.out.print("Digite o ano de lançamento do livro à ser adicionado; ");
                    int anoLancamento = sc.nextInt();
                    sc.nextLine();

                    biblioteca.adicionarLivro(autor, titulo, anoLancamento);
                    break;

                case 2:
                    biblioteca.listarLivros();
                    break;

                case 3:
                    System.out.print("Digite o título do livro a ser buscado: ");
                    String tituloLivro = sc.nextLine();

                    System.out.println();
                    biblioteca.buscarLivroPeloTitulo(tituloLivro);
                    break;

                case 0:
                    System.out.println("Programa encerrado...");
                    programa = false;
                    break;
            }
        }
        sc.close();
    }
}
