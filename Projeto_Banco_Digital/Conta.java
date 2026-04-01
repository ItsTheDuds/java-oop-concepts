package Projeto_Banco_Digital;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.ResolverStyle;

public class Conta {

    private String numeroConta;
    private double saldo;
    private Historico historico = new Historico();
    private LocalDate data;
    private static final DateTimeFormatter FORMATADOR = DateTimeFormatter
            .ofPattern("dd/MM/uuuu")
            .withResolverStyle(ResolverStyle.STRICT);

    public String getNumeroConta() {
        return numeroConta;
    }

    public void setNumeroConta(String numeroConta) {
        this.numeroConta = numeroConta;
    }

    public double getSaldo() {
        return this.saldo;
    }

    public boolean depositar(double valor) {
        if (valor <= 0) {
            return false;
        }
        this.saldo += valor;
        historico.adicionarTransacao(
                new Transacao("DEPOSITO", valor, data.format(FORMATADOR)));
        return true;
    }

    public boolean sacar(double valor) {
        if (valor <= 0 || valor > saldo) {
            return false;
        }
        this.saldo -= valor;
        historico.adicionarTransacao(
                new Transacao("SAQUE", valor, data.format(FORMATADOR)));
        return true;
    }

    public String descricao() {
        return "Conta";
    }
}