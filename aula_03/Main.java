package aula_03;

import aula_03.Cliente.Cliente;
import aula_03.Estoque.Estoque;

public class Main {
    public static void main(String[] args) {

        Estoque estoque = new Estoque();

        estoque.adicionarProduto("Camisa", 75.40, 10);
        estoque.adicionarProduto("Boné", 24.99, 50);

        Cliente cliente = new Cliente("João Silva", "79232442312");

        cliente.comprarProduto(estoque, "Camisa", 2);
        cliente.comprarProduto(estoque, "Boné", 1);

    }
}
