package vet;

public class Atendimento {
    private Animal animal;
    private Veterinario veterinario;

    public Atendimento(Animal animal, Veterinario veterinario) {
        this.animal = animal;
        this.veterinario = veterinario;
    }

    public String toString() {
        return animal + " | Atendido por: " + veterinario.getNome();
    }
}
