package Projeto_Banco_Digital;

import java.time.LocalDate;
import java.util.Scanner;

import java.util.Scanner;
import java.time.LocalDate;
import Projeto_Banco_Digital.ValidaCPF;

public class Controlador {
    public static void criarConta() {
        // 1. Imprimir cabeçalho
        Telas.mostrarMensagem("Criar Conta");

        // 2. Coletar dados
        Scanner sc = new Scanner(System.in);

        // Coletando o nome do cliente
        System.out.print("Nome: ");
        String nome = sc.nextLine();

        // Coletando a data de nascimento
        System.out.print("Data de Nascimento (dd-mm-yyyy): ");
        String dataNascimentoStr = sc.nextLine();

        // Convertendo a String para LocalDate
        LocalDate dataNascimento = LocalDate.parse(dataNascimentoStr);

        // Criando e inicializando o objeto cliente
        Cliente c = new Cliente();
        c.setNome(nome);
        c.setDataNascimento(dataNascimento);

        // Coletando e validando o CPF
        // Coletando e validando o CPF
        String cpf;
        boolean cpfValido;
        do {
            System.out.print("CPF: ");
            cpf = sc.nextLine();
            cpfValido = c.setCpf(cpf); // O método setCpf agora retorna true ou false
            if (!cpfValido) {
                System.out.println("CPF inválido. Tente novamente.");
            }
        } while (!cpfValido);

        c.setCpf(cpf); // Assumindo que você tem um método setCpf na classe Cliente

        // Coletando a senha do cliente
        System.out.print("Senha: ");
        String senha = sc.nextLine();
        c.setSenha(senha);

        // Exibindo mensagem de sucesso
        System.out.println("\nConta validada com sucesso!");
        System.out.println("Work in progress...");
    }
}