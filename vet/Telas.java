package vet;

import java.util.Scanner;

public class Telas {

    private static final Scanner scanner = new Scanner(System.in);

    public static void limparTela() {
        for (int i = 0; i < 50; i++) {
            System.out.println();
        }
    }


    public static void menuPrincipal() {
        limparTela();
        System.out.println("\n==============================");
        System.out.println("    CLÍNICA VETERINÁRIA        ");
        System.out.println("==============================");
        System.out.println("1. Adicionar animal à fila");
        System.out.println("2. Atender próximo animal");
        System.out.println("3. Ver fila de espera");
        System.out.println("4. Ver histórico de atendimentos");
        System.out.println("5. Ver veterinários disponíveis");
        System.out.println("0. Sair");
        System.out.print("Opção selecionada: ");
    }

    public static void menuAtendimento(String nomeAnimal) {
        limparTela();
        System.out.println("\n==============================");
        System.out.println(" Atendendo: " + nomeAnimal);
        System.out.println("==============================");
        System.out.println("1. Concluir atendimento");
        System.out.println("2. Voltar");
        System.out.print("Opção selecionada: ");
    }


    public static void cabecalhoCadastroAnimal() {
        limparTela();
        System.out.println("\n======== Cadastro de Animal ========");
    }

    public static void cabecalhoCadastroVeterinario() {
        limparTela();
        System.out.println("\n======== Cadastro de Veterinário ========");
    }

    public static void cabecalhoHistorico() {
        limparTela();
        System.out.println("\n======== Histórico de Atendimentos ========");
    }


    public static String lerTexto(String label) {
        System.out.print(label + ": ");
        return scanner.nextLine().trim();
    }

    public static int lerOpcao() {
        try {
            int opcao = Integer.parseInt(scanner.nextLine().trim());
            return opcao;
        } catch (NumberFormatException e) {
            return -1;
        }
    }

    public static double lerValor(String label) {
        System.out.print(label + ": R$ ");
        try {
            return Double.parseDouble(scanner.nextLine().trim().replace(",", "."));
        } catch (NumberFormatException e) {
            return -1;
        }
    }


    public static void mensagem(String texto, boolean eErro) {
        limparTela();

        if (!eErro) {
            System.out.println("\n" + texto);
            System.out.println("\nPressione qualquer tecla para continuar...");
        } else {
            System.out.println("XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX");
            System.out.println("\n[ERRO] " + texto);
            System.out.println("XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX");
            System.out.println("\nPressione qualquer tecla para continuar...");
        }
        scanner.nextLine();
    }

    public static void separador() {
        System.out.println("--------------------------------------------------");
    }

    public static void listarVeterinarios(String[] veterinarios) {
        limparTela();
        System.out.println("\n==============================");
        System.out.println("  Veterinários Disponíveis    ");
        System.out.println("==============================");

        if (veterinarios.length == 0) {
            System.out.println("Nenhum veterinário cadastrado.");
        } else {
            for (int i = 0; i < veterinarios.length; i++) {
                System.out.println((i + 1) + ". " + veterinarios[i]);
            }
        }

        System.out.println("--------------------------------------------------");
        Telas.lerTexto("Pressione ENTER para continuar...");
    }

    public static void mostrarFilaEspera(String[] fila) {
        limparTela();
        System.out.println("\n==============================");
        System.out.println("   Fila de Espera             ");
        System.out.println("==============================");

        if (fila.length == 0) {
            System.out.println("Nenhum animal na fila de espera.");
        } else {
            for (String animal : fila) {
                System.out.println(animal);
            }
        }

        System.out.println("--------------------------------------------------");
        Telas.lerTexto("Pressione ENTER para continuar...");
    }

    public static void mostrarHistorico(String[] historico) {
        limparTela();
        System.out.println("\n==============================");
        System.out.println("   Histórico de Atendimentos  ");
        System.out.println("==============================");

        if (historico.length == 0) {
            System.out.println("Nenhum atendimento realizado.");
        } else {
            for (String atendimento : historico) {
                System.out.println(atendimento);
            }
        }

        System.out.println("--------------------------------------------------");
        Telas.lerTexto("Pressione ENTER para continuar...");
    }
}