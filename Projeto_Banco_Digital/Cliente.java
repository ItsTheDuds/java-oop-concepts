package Projeto_Banco_Digital;

import java.time.DateTimeException;
import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.time.format.FormatStyle;

public class Cliente {

    private String nome;
    private String cpf;
    private int idade;
    private LocalDate dataNascimento;
    private String numeroConta;
    private String senha;
    private double saldo;
    private int tentativasFalhas;
    private boolean bloqueada;
    public int idadeMinima = 16;

    // ----- NOME -----
    public String getNome() {
        return nome;
    }

    public boolean setNome(String nome) {
        if (nome == null || nome.trim().split("\\s+").length < 2) {
            return false;
        }
        this.nome = nome.trim();
        return true;
    }

    // ----- CPF -----
    public boolean setCpf(String cpf) {
        // Limpa o CPF, removendo qualquer caractere que não seja número
        String cpfLimpo = cpf.replaceAll("[^0-9]", "");

        // Verifica se o CPF é válido
        if (ValidaCPF.isCPF(cpfLimpo)) {
            this.cpf = cpfLimpo; // Atribui o CPF validado
            return true; // Retorna true se o CPF for válido
        } else {
            System.out.println("CPF inválido.");
            return false; // Retorna false se o CPF for inválido
        }
    }

    public String getCpf() {
        return cpf;
    }

    // ----- DATA DE NASCIMENTO -----
    public LocalDate getDataNascimento() {
        return dataNascimento;
    }

    public boolean setDataNascimento(String data) {

        try {
            DateTimeFormatter formatador = DateTimeFormatter.ofPattern("dd/MM/yyyy");
            LocalDate dataNascimento = LocalDate.parse(data, formatador);
            if (dataNascimento == null) {
                return false;
            }
            if (dataNascimento.isAfter(LocalDate.now())) {
                return false;
            }

            if (dataNascimento.isBefore(LocalDate.of(1900, 1, 1))) {
                return false;
            }

            int idadeCalculada = Period.between(dataNascimento, LocalDate.now()).getYears();
            if (idadeCalculada < idadeMinima) {
                return false;
            }
            this.dataNascimento = dataNascimento;
            this.idade = idadeCalculada;
            return true;

        } catch (DateTimeParseException e) {
            return false;
        }
    }

    // ----- IDADE -----
    public int getIdade() {
        return idade;
    }

    // ----- NUMERO DA CONTA -----
    public String getNumeroConta() {
        return numeroConta;
    }

    public void setNumeroConta(String numeroConta) {
        this.numeroConta = numeroConta;
    }

    // ----- SENHA -----
    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    // ----- SALDO -----
    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    // ----- TENTATIVAS FALHAS -----
    public int getTentativasFalhas() {
        return tentativasFalhas;
    }

    public void setTentativasFalhas(int tentativasFalhas) {
        this.tentativasFalhas = tentativasFalhas;
    }

    // ----- BLOQUEADA -----
    public boolean isBloqueada() {
        return bloqueada;
    }

    public void setBloqueada(boolean bloqueada) {
        this.bloqueada = bloqueada;
    }

    public void registrarTentativaFalha() {
        // Incrementa
        this.tentativasFalhas++;

        // Verifica se atingiu o limite
        if (this.tentativasFalhas >= 3) {
            this.bloqueada = true;
            System.out.println("Conta bloqueada por tentativas de login excedidas!");
        }

    }
}