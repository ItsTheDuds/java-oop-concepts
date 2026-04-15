package Projeto_Banco_Digital;

import java.util.List;

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
                    menuConta(cliente);
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
                case 1:
                    depositar(cliente);
                    break;
                case 2:
                    sacar(cliente);
                    break;
                case 3:
                    transferir(cliente);
                    break;
                case 4:
                    exibirExtrato(cliente);
                    break;
                case 5:
                    Telas.mensagem("Saindo da conta...", false);
                    break;
                default:
                    Telas.mensagem("Opção inválida.", true);
                    break;
            }

        } while (opcao != 5);
    }

    // Métodos individuais
    private static void depositar(Cliente cliente) {
        double valor = Telas.lerValor("Valor para depósito");
        if (central.depositar(cliente, valor)) {
            Telas.mensagem("Depósito realizado com sucesso.", false);
        } else {
            Telas.mensagem("Erro ao realizar depósito.", true);
        }
    }

    private static void sacar(Cliente cliente) {
        String senha = Telas.lerTexto("Senha");

        if (!cliente.verificarSenha(senha)) {
            Telas.mensagem("Senha incorreta", true);
            return;
        }

        double valor = Telas.lerValor("Valor para saque");
        if (central.sacar(cliente, valor)) {
            Telas.mensagem("Saque realizado com sucesso.", false);
        } else {
            Telas.mensagem("Erro ao realizar saque.", true);
        }
    }

    private static void transferir(Cliente cliente) {
        String senha = Telas.lerTexto("Senha");
        if (!cliente.verificarSenha(senha)) {
            Telas.mensagem("Senha incorreta", true);
            return;
        }

        String contaDestino = Telas.lerTexto("Conta destino");
        double valor = Telas.lerValor("Valor para transferência");

        if (valor <= 0) {
            Telas.mensagem("Valor inválido.", true);
            return;
        }

        if (central.transferir(cliente, contaDestino, valor)) {
            Telas.mensagem("Transferência realizada com sucesso.", false);
        } else {
            Telas.mensagem("Erro na transferência.", true);
        }
    }

    private static void exibirExtrato(Cliente cliente) {

        int opcao;

        do {
            Telas.limparTela();
            System.out.println("""
                    ======= EXTRATO =======
                    1 - Ver tudo
                    2 - Depósitos
                    3 - Saques
                    4 - Transferências enviadas
                    5 - Transferências recebidas
                    0 - Voltar
                    """);
            
            System.out.print("Selecione uma opção: ");
            opcao = Telas.lerOpcao();

            List<String> extrato = central.getExtrato(cliente);

            switch (opcao) {

                case 1 -> {
                    Telas.limparTela();
                    System.out.println("\n--- EXTRATO COMPLETO ---");

                    if (extrato.isEmpty()) {
                        System.out.println("Nenhuma movimentação encontrada.");
                    } else {
                        extrato.forEach(System.out::println);
                    }
                }

                case 2 -> {
                    Telas.limparTela();
                    System.out.println("\n--- DEPÓSITOS ---");

                    List<String> filtrado = extrato.stream()
                            .filter(l -> l.contains("DEPOSITO"))
                            .toList();

                    if (filtrado.isEmpty()) {
                        System.out.println("Nenhum depósito encontrado.");
                    } else {
                        filtrado.forEach(System.out::println);
                    }
                }

                case 3 -> {
                    Telas.limparTela();
                    System.out.println("\n--- SAQUES ---");

                    List<String> filtrado = extrato.stream()
                            .filter(l -> l.contains("SAQUE"))
                            .toList();

                    if (filtrado.isEmpty()) {
                        System.out.println("Nenhum saque realizado.");
                    } else {
                        filtrado.forEach(System.out::println);
                    }
                }

                case 4 -> {
                    Telas.limparTela();
                    System.out.println("\n--- TRANSFERÊNCIAS ENVIADAS ---");

                    List<String> filtrado = extrato.stream()
                            .filter(l -> l.contains("TRANSFERENCIA_ENVIADA"))
                            .toList();

                    if (filtrado.isEmpty()) {
                        System.out.println("Nenhuma transferência enviada.");
                    } else {
                        filtrado.forEach(System.out::println);
                    }
                }

                case 5 -> {
                    Telas.limparTela();
                    System.out.println("\n--- TRANSFERÊNCIAS RECEBIDAS ---");

                    List<String> filtrado = extrato.stream()
                            .filter(l -> l.contains("TRANSFERENCIA_RECEBIDA"))
                            .toList();

                    if (filtrado.isEmpty()) {
                        System.out.println("Nenhuma transferência recebida.");
                    } else {
                        filtrado.forEach(System.out::println);
                    }
                }

                case 0 -> {
                    System.out.println("Voltando ao menu...");
                }

                default -> {
                    System.out.println("Opção inválida.");
                }
            }

            if (opcao != 0) {
                Telas.lerTexto("\nPressione ENTER para continuar...");
            }

        } while (opcao != 0);
    }
}
