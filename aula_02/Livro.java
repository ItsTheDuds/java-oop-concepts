package aula_02;

public class Livro {

    String autor;
    String titulo;
    int anoLancamento;

    public Livro(String autor, String titulo, int anoLancamento) {
        this.autor = autor;
        this.titulo = titulo;
        this.anoLancamento = anoLancamento;
    }

    public String getAutor() {
        return autor;
    }

    public String getTitulo() {
        return titulo;
    }

    public int getAnoLancamento() {
        return anoLancamento;
    }
}