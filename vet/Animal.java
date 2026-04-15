package vet;

public class Animal {
    String nome;
    String especie;
    String dono;

    public Animal(String nome, String especie, String dono) {
        this.nome = nome;
        this.especie = especie;
        this.dono = dono;
    }

    public String getNome() {
        return nome;
    }

    public String toString() {
        return nome + " (" + especie + ") - Dono: " + dono;
    }
}
