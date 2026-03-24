package Projeto_Banco_Digital;

import java.time.LocalDate;
import java.util.Scanner;

public class Controlador {
    private Cliente cliente;

    public void criarConta() {
        // 1. Imprimir cabeçalho
        Telas.mostrarMensagem("Criar Conta");

        // 2. Coletar dados
        Scanner sc = new Scanner(System.in);

        // Coletando o nome do cliente
        System.out.print("Nome: ");
        String nome = sc.nextLine();

        // Coletando a data de nascimento
        System.out.print("Data de Nascimento (yyyy-mm-dd): ");
        String dataNascimentoStr = sc.nextLine();

        // Convertendo a String para LocalDate
        LocalDate dataNascimento = LocalDate.parse(dataNascimentoStr);

        // Criando e inicializando o objeto cliente
        cliente = new Cliente();
        cliente.setNome(nome);
        cliente.setDataNascimento(dataNascimento);

        // Coletando a senha do cliente
        System.out.print("Senha: ");
        String senha = sc.nextLine();
        cliente.setSenha(senha);

        // Exibindo mensagem de sucesso
        System.out.println("\nConta validada com sucesso!");
        System.out.println("Work in progress...");
    }
}