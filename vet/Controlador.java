package vet;

import java.util.*;

public class Controlador {

    private static Queue<Animal> fila = new LinkedList<>(); // Usando Queue para a fila de espera
    private static Stack<Atendimento> historico = new Stack<>(); // Usando Stack para o histórico de atendimentos
    private static List<Veterinario> veterinarios = new ArrayList<>(); // Lista de veterinários

    public Controlador() {
        fila = new LinkedList<>();
        historico = new Stack<>();
        veterinarios = new ArrayList<>();

        veterinarios.add(new Veterinario("Dr. João"));
        veterinarios.add(new Veterinario("Dra. Maria"));
    }

    public void adicionarAnimal() {
        String nome = Telas.lerTexto("Nome do animal");
        String especie = Telas.lerTexto("Espécie");
        String dono = Telas.lerTexto("Dono");

        Animal animal = new Animal(nome, especie, dono);
        fila.add(animal);

        Telas.mensagem("Animal adicionado à fila!", false);
    }

    public void atenderAnimal() {
        if (fila.isEmpty()) {
            Telas.mensagem("Fila vazia!", true);
            return;
        }

        Animal animal = fila.poll();

        System.out.println("Escolha o veterinário:");
        for (int i = 0; i < veterinarios.size(); i++) {
            System.out.println((i + 1) + ". " + veterinarios.get(i).getNome());
        }

        int opcao = Telas.lerOpcao();

        if (opcao < 1 || opcao > veterinarios.size()) {
            Telas.mensagem("Opção inválida!", true);
            return;
        }

        Veterinario vet = veterinarios.get(opcao - 1);

        Atendimento atendimento = new Atendimento(animal, vet);
        historico.push(atendimento);

        Telas.mensagem("Atendimento realizado!", false);
    }

    public void verFila() {
        Telas.limparTela();
        System.out.println("=== FILA DE ESPERA ===");

        if (fila.isEmpty()) {
            System.out.println("Nenhum animal aguardando.");
        } else {
            fila.forEach(animal -> System.out.println(animal));
        }

        Telas.lerTexto("Pressione ENTER para continuar...");
    }

    public void verHistorico() {
        Telas.limparTela();
        System.out.println("=== HISTÓRICO (mais recente primeiro) ===");

        if (historico.isEmpty()) {
            System.out.println("Nenhum atendimento realizado.");
        } else {
            for (int i = historico.size() - 1; i >= 0; i--) {
                System.out.println(historico.get(i));
            }
        }

        Telas.lerTexto("Pressione ENTER para continuar...");
    }

    public void listaVeterinarios() {
        Telas.limparTela();
        for (Veterinario veterinario : veterinarios) {
            System.out.println("Doutor disponível: " + veterinario);
        }
        Telas.lerTexto("Pressione ENTER para continuar...");
    }
}