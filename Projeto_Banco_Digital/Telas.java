package Projeto_Banco_Digital;

public class Telas {

    // Menu inicial (antes do login)
    public void mostrarMenuCadastro() {
        System.out.println("===== BANCO DIGITAL =====");
        System.out.println("1 - Cadastrar Cliente");
        System.out.println("2 - Login");
        System.out.println("0 - Sair");
        System.out.print("Escolha uma opção: ");
    }

    // Menu depois de logar
    public void mostrarMenuPrincipal() {
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
        System.out.println("Erro: " + msg);
    }

    // Mensagem genérica
    public void mostrarMensagem(String msg) {
        System.out.println(msg);
    }
}