package Projeto_Banco_Digital;

public class Controlador {

    public static void criarConta() {
        // 1. Imprimir cabeçalho
        Telas.limparTela();
        Telas.mostrarMensagem("Criar Conta");

        // Criando e inicializando o objeto cliente
        Cliente c = new Cliente();

        // Coletando o nome do cliente
        String nome;
        do {
            nome = Telas.lerTexto("Digite seu nome completo:");
            if (!c.setNome(nome)) {
                System.out.println("Nome inválido. Tente novamente.");
            }
        } while (!c.setNome(nome));

        // Coletando CPF
        String cpf;
        do {
            cpf = Telas.lerTexto("Digite seu CPF:");
            if (!c.setCpf(cpf)) {
                System.out.println("CPF inválido. Tente novamente.");
            }
        } while (!c.setCpf(cpf));

        String dataNascimento;
        do {
            // Coletando a data de nascimento
            dataNascimento = Telas.lerTexto("Digite  sua data de nascimento (dd-MM-yyyy):");
            // Definindo a data de nascimento no cliente
            c.setDataNascimento(dataNascimento);
            if (!c.setDataNascimento(dataNascimento)) {
                Telas.mensagemErro("Data de nascimento inválida ou você não atende a idade mínima.", true);
            }

        } while (!c.setDataNascimento(dataNascimento));

        // Coletando a senha do cliente
        String senha = Telas.lerTexto("Informe sua senha: ");
        c.setSenha(senha);

        // Exibindo mensagem de sucesso
        System.out.println("\nConta validada com sucesso!");
        System.out.println("Work in progress...");
    }
}
