package Projeto_Banco_Digital;

import java.time.LocalDate;
import java.time.Period;

public class Cliente {

    private String nome;
    private String cpf;
    private int idade;
    private LocalDate dataNascimento;
    private String email;
    private String numeroConta;
    private String senha;
    private double saldo;
    private int tentativasFalhas;
    private boolean bloqueada;

    // ----- NOME -----
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        if (nome == null || nome.trim().isEmpty()) {
            throw new IllegalArgumentException("Nome inválido!");
        }
        this.nome = nome.trim();
    }

    // ----- CPF -----
    public void setCpf(String cpf) {
        int limiteMaximo = 11;
        if (cpf == null) {
        throw new IllegalArgumentException("CPF não pode ser nulo.");
        }
        if (cpf.length() > limiteMaximo) {
        throw new IllegalArgumentException("O texto excede o limite de " + limiteMaximo + " caracteres.");
        }
        this.cpf = cpf;
    }

    public String getCpf() {
        return cpf;
    }

    // ----- DATA DE NASCIMENTO -----
    public LocalDate getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(LocalDate dataNascimento) {
        if (dataNascimento == null) {
            throw new IllegalArgumentException("Data de nascimento não pode ser nula!");
        }
        if (dataNascimento.isAfter(LocalDate.now())) {
            throw new IllegalArgumentException("Data de nascimento não pode ser no futuro!");
        }

        int idadeCalculada = Period.between(dataNascimento, LocalDate.now()).getYears();
        if (idadeCalculada < 18) {
            throw new IllegalArgumentException("Cliente deve ter pelo menos 18 anos!");
        }

        this.dataNascimento = dataNascimento;
        this.idade = idadeCalculada;
    }

    // ----- IDADE -----
    public int getIdade() {
        return idade;
    }


    // ----- EMAIL -----
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
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