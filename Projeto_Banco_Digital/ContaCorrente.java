package Projeto_Banco_Digital;

public class ContaCorrente extends Conta {

    // Sobrescreve o método descricao() para ContaCorrente
    @Override
    public String descricao() {
        return "Conta Corrente";
    }
}