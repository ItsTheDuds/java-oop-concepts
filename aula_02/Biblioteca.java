package aula_02;

import java.util.ArrayList;

public class Biblioteca {

    ArrayList<Livro> listaLivros = new ArrayList<>();

    public void adicionarLivro(String autor, String titulo, int anoLancamento) {
        Livro livro = new Livro(autor, titulo, anoLancamento);
        listaLivros.add(livro);
    }

    public void listarLivros() {

        if (listaLivros.isEmpty()) {
            System.out.println("Nenhum livro cadastrado.");
            return;
        }

        for (Livro livro : listaLivros) {
            System.out.println("----------------------------");
            System.out.println("Autor: " + livro.getAutor());
            System.out.println("Título: " + livro.getTitulo());
            System.out.println("Ano: " + livro.getAnoLancamento());
        }
    }

    public void buscarLivroPeloTitulo(String titulo) {

        //boolean encontrado = false;

        for (Livro livro : listaLivros) {

            if (livro.getTitulo().equalsIgnoreCase(titulo)) {

                System.out.println("--------------------");
                System.out.println("Livro encontrado:");
                System.out.println("Autor: " + livro.getAutor());
                System.out.println("Título: " + livro.getTitulo());
                System.out.println("Ano: " + livro.getAnoLancamento());
                System.out.println("--------------------");
                return;
                //encontrado = true;
            }
        }

        //if (!encontrado) {
            System.out.println("Livro não foi encontrado.");
        }
    }
