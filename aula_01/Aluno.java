public class Aluno {
    String nome;
    int idade;
    String matricula;
    double media;

    public Aluno(String nome, int idade, String matricula) {
        this.nome = nome;
        this.idade = idade;
        this.matricula = matricula;

    }

    public Aluno() {

    }

    public void calcularNota(double media) {
        if (media >= 6) {
            System.out.println("Aluno " + nome + " foi aprovado com nota: " + media);
        } else {
            System.out.println("Aluno " + nome + " foi reprovado com nota: " + media);
        }

    }

    public void exibirAluno() {
        System.out.print("Nome: " + nome + "\n");
        System.out.print("Idade: " + idade + "\n");
        System.out.print("Matricula: " + matricula + "\n");
        System.out.print("Média: " + media + "\n");
        System.out.println();

    }

}