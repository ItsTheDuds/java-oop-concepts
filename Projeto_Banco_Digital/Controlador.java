package Projeto_Banco_Digital;

import java.util.Scanner;

public class Controlador {
    private static final CentralBancaria central = new CentralBancaria();

    public static void criarConta() {
        Telas.cabecalhoCadastro();
        Cliente cliente = new Cliente();

        // Nome
        String nomeInformado;
        do {
            Telas.limparTela();
            nomeInformado = Telas.lerTexto("Digite o nome completo: ");
            if (!cliente.setNome(nomeInformado)) {
                Telas.mensagem("Nome inválido!", true);
            }
        } while (!cliente.setNome(nomeInformado));

        // CPF
        String cpfInformado;
        do {
            Telas.limparTela();
            cpfInformado = Telas.lerTexto("Digite o CPF: ");
            if (!cliente.setCpf(cpfInformado)) {
                Telas.mensagem("CPF inválido.", true);
            }
        } while (!cliente.setCpf(cpfInformado));

        // Data de Nascimento
        String data;
        do {
            Telas.limparTela();
            data = Telas.lerTexto("Data de nascimento (dd/mm/aaaa)");
            if (!cliente.setDataNascimento(data)) {
                Telas.mensagem("Data de nascimento inválida.", true);
            }
        } while (!cliente.setDataNascimento(data));

        // Envia à CentralBancaria
        System.out.println("Enviando dados para a central...");
        String resultado = central.cadastrar(
                cliente.getNome(),
                cliente.getCpf(),
                cliente.getDataNascimento());

        if (resultado.startsWith("ERRO")) {
            Telas.mensagem(resultado, true);
            return;
        }

        String numeroConta = resultado;

        // Solicitar Senha
        Telas.limparTela();
        System.out.println("Conta criada com sucesso!");
        System.out.println("Número da conta: " + numeroConta);
        Telas.separador();

        String senha, confirma;
        do {
            senha = Telas.lerTexto("Crie sua senha (4 dígitos numéricos)");
            confirma = Telas.lerTexto("Confirme sua senha");
            if (!senha.equals(confirma)) {
                Telas.mensagem("Senhas não conferem. Tente novamente.", true);
            } else if (!senha.matches("\\d{4}")) {
                Telas.mensagem("Senha inválida. Use exatamente 4 dígitos numéricos.", true);
            }
        } while (!senha.equals(confirma) || !senha.matches("\\d{4}"));

        central.cadastrarSenha(numeroConta, senha);
        Telas.mensagem("Cadastro concluído! Número da conta: " + numeroConta, false);
    }

    public static void acessarConta() {
        Cliente cliente = new Cliente();
        CentralBancaria central = new CentralBancaria();
        String numeroConta;
        String senha;

        for (int i = 1; i <= 3; i++) {
            Telas.cabecalhoLogin();

            numeroConta = Telas.lerTexto("Número da conta");
            senha = Telas.lerTexto("Senha");

            String status = central.login(numeroConta, senha, cliente);

            switch (status) {
                case "OK":
                    Telas.mensagem("Você acessou sua conta com sucesso", false);
                    return;

                case "SENHA_INCORRETA":
                    Telas.mensagem("Senha incorreta. Tentativa " + i + " de 3", true);
                    break;

                case "CONTA_INEXISTENTE":
                    Telas.mensagem("Conta não encontrada.", true);
                    return;

                case "BLOQUEADA":
                    Telas.mensagem("Conta bloqueada.", true);
                    return;

                default:
                    Telas.mensagem("Erro: " + status, true);
                    return;
            }
        }

        Telas.mensagem("Número máximo de tentativas atingido.", true);
    }

    public static void menuConta(Cliente cliente) {
        int opcao;

        do {
            Telas.menuConta(cliente.getNome(), cliente.getSaldo());
            opcao = Telas.lerOpcao();

            switch (opcao) {

                case 1: // Depositar
                    double valorDep = Telas.lerValor("Valor para depósito");
                    if (valorDep <= 0) {
                        Telas.mensagem("Valor inválido.", true);
                        break;
                    }

                    if (central.depositar(cliente, valorDep)) {
                        Telas.mensagem("Depósito realizado com sucesso.", false);
                    } else {
                        Telas.mensagem("Erro ao realizar depósito.", true);
                    }
                    break;

                case 2: // Sacar
                    double valorSaq = Telas.lerValor("Valor para saque");
                    if (valorSaq <= 0) {
                        Telas.mensagem("Valor inválido.", true);
                        break;
                    }

                    if (valorSaq > cliente.getSaldo()) {
                        Telas.mensagem("Saldo insuficiente.", true);
                        break;
                    }

                    if (central.sacar(cliente, valorSaq)) {
                        Telas.mensagem("Saque realizado com sucesso.", false);
                    } else {
                        Telas.mensagem("Erro ao realizar saque.", true);
                    }
                    break;

                case 3: // Transferir
                    String contaDestino = Telas.lerTexto("Conta destino");
                    double valorTransf = Telas.lerValor("Valor para transferência");

                    if (valorTransf <= 0) {
                        Telas.mensagem("Valor inválido.", true);
                        break;
                    }

                    if (valorTransf > cliente.getSaldo()) {
                        Telas.mensagem("Saldo insuficiente.", true);
                        break;
                    }

                    if (central.transferir(cliente, contaDestino, valorTransf)) {
                        Telas.mensagem("Transferência realizada com sucesso.", false);
                    } else {
                        Telas.mensagem("Erro na transferência.", true);
                    }
                    break;

                case 4: // Extrato
                    Telas.limparTela();
                    System.out.println("======= EXTRATO =======");

                    for (String linha : central.getExtrato(cliente)) {
                        System.out.println(linha);
                    }

                    Telas.separador();
                    System.out.println("Pressione ENTER para continuar...");
                    new Scanner(System.in).nextLine();
                    break;

                case 5: // Sair
                    Telas.mensagem("Saindo da conta...", false);
                    break;

                default:
                    Telas.mensagem("Opção inválida.", true);
            }

        } while (opcao != 5);
    }
}
