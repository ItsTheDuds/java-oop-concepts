package Projeto_Banco_Digital;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class Controlador {

    public static void criarConta() {
        // 1. Imprimir cabeçalho
        Telas.limparTela();
        Telas.mostrarMensagem("Criar Conta");

        // Criando e inicializando o objeto cliente
        Cliente c = new Cliente();

        // Coletando o nome do cliente
        String nome;
        do {
            nome = Telas.lerTexto("Digite seu nome completo:");
            if (!c.setNome(nome)) {
                System.out.println("Nome inválido. Tente novamente.");
            }
        } while (!c.getNome().equals(nome.trim()));

        // Coletando CPF
        String cpf;
        boolean cpfValido;
        do {
            cpf = Telas.lerTexto("CPF: ");
            cpfValido = c.setCpf(cpf); // O método setCpf retorna true ou false
            if (!cpfValido) {
                System.out.println("CPF inválido. Tente novamente.");
            }
        } while (!cpfValido);

        // Coletando a data de nascimento
        String dataNascimentoStr = Telas.lerTexto("Digite  sua data de nascimento (dd-MM-yyyy):");

        // Convertendo a String para LocalDate
        LocalDate dataNascimento = LocalDate.parse(dataNascimentoStr, DateTimeFormatter.ofPattern("dd-MM-yyyy"));

        // Definindo a data de nascimento no cliente
        boolean dataValida = c.setDataNascimento(dataNascimentoStr);
        if (!dataValida) {
            System.out.println("Data de nascimento inválida ou você não atende a idade mínima.");
            return; // Ou você pode voltar para o início ou reexecutar a entrada.
        }

        // Coletando a senha do cliente
        String senha = Telas.lerTexto("Informe sua senha: ");
        c.setSenha(senha);

        // Exibindo mensagem de sucesso
        System.out.println("\nConta validada com sucesso!");
        System.out.println("Work in progress...");
    }
}
