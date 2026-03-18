package Projeto_Banco_Digital;

public class ContaBancaria {

    private double saldo;

    public void depositar(double valor) {
        if (valor > 0) {
            this.saldo += valor;
        }
    }

    public void sacar(double valor) {
        if (valor > 0 && valor <= saldo) {
            this.saldo -= valor;
        } else {
            System.out.println("Saldo insuficiente ou valor inválido");
        }
    }

    public double getSaldo() {
        return saldo; 
    }
}