import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Aluno aluno1 = new Aluno();
        Aluno aluno2 = new Aluno();
        Aluno aluno3 = new Aluno();

        System.out.print("Qual nome do primeiro aluno: ");

        aluno1.nome = sc.nextLine();

        System.out.print("Qual a matrícula do primeiro aluno: ");
        aluno1.matricula = sc.nextLine();


        System.out.print("Qual idade do primeiro aluno: ");
        aluno1.idade = sc.nextInt();
        sc.nextLine();

        System.out.print("Qual a média do primeiro aluno: ");
        aluno1.media = sc.nextDouble();
        sc.nextLine();
        aluno1.calcularNota(aluno1.media);

        System.out.println();
        System.out.print("Qual nome do segundo aluno: ");
        aluno2.nome = sc.nextLine();

        System.out.print("Qual a matrícula do segundo aluno: ");
        aluno2.matricula = sc.nextLine();

        System.out.print("Qual idade do segundo aluno: ");
        aluno2.idade = sc.nextInt();
        
        sc.nextLine();

        System.out.print("Qual a média do segundo aluno: ");
        aluno2.media = sc.nextDouble();
        sc.nextLine();
        aluno2.calcularNota(aluno2.media);

        System.out.println();
        System.out.print("Qual nome do terceiro aluno: ");
        aluno3.nome = sc.nextLine();

        System.out.print("Qual a matrícula do terceiro aluno: ");
        aluno3.matricula = sc.nextLine();

        System.out.print("Qual idade do terceiro aluno: ");
        aluno3.idade = sc.nextInt();
        sc.nextLine();

        System.out.print("Qual a média do terceiro aluno: ");
        aluno3.media = sc.nextDouble();
        sc.nextLine();
        aluno3.calcularNota(aluno3.media);

        aluno1.exibirAluno();
        aluno2.exibirAluno();
        aluno3.exibirAluno();

        sc.close();
    }
}