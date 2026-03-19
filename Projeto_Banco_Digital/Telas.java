package Projeto_Banco_Digital;
import java.util.Scanner;

public class Telas {
    private static final Scanner sc = new Scanner(System.in);

    // Leitura de dados do usuario
    public static String lerTexto(String label) {
        System.out.println(label + ": ");
        return sc.nextLine().trim();
    }

    public static double lerValor(String label) {
        System.out.println(label + ": ");
        try {
            return Double.parseDouble(sc.nextLine().trim().replace(".",","));
        } catch (NumberFormatException e) {
            return -1;
        }
    }
    // Menu inicial (antes do login)
    public void mostrarMenuCadastro() {
        limparTela();
        System.out.println("===== BANCO DIGITAL =====");
        System.out.println("1 - Cadastrar Cliente");
        System.out.println("2 - Login");
        System.out.println("0 - Sair");
        System.out.print("Escolha uma opção: ");
    }

    // Menu depois de logar
    public void mostrarMenuPrincipal() {
        limparTela();
        System.out.println("===== MENU PRINCIPAL =====");
        System.out.println("1 - Ver saldo");
        System.out.println("2 - Depositar");
        System.out.println("3 - Sacar");
        System.out.println("4 - Transferir"); // se futuramente implementar
        System.out.println("0 - Sair");
        System.out.print("Escolha uma opção: ");
    }

    // Mensagem de boas-vindas
    public void mostrarBoasVindas(String nomeCliente) {
        System.out.println("Bem-vindo, " + nomeCliente + "!");
    }

    // Mensagem de erro
    public void mostrarMensagemErro(String msg) {
        limparTela();
        System.out.println("Erro: " + msg);
        System.out.println("Pressione qualquer tecla para continuar...");
        sc.nextLine();
    }

    // Mensagem genérica
    public void mostrarMensagem(String msg) {
        System.out.println(msg);
    }

    public int lerOpcao() {
        try {
        int opcao = Integer.parseInt(sc.nextLine().trim());
        return opcao;
        } catch (NumberFormatException e) {
            return -1;
        }
    }

    public static void limparTela() {
        for (int i = 0; i < 50; i++) {
            System.out.println();
        }
   }
}