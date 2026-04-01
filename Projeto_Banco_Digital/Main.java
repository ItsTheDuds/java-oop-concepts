package Projeto_Banco_Digital;

public class Main {
    public static void main(String[] args) {
        int opcao;

        do {
            Telas.menuPrincipal();
            opcao = Telas.lerOpcao();

            switch (opcao) {
                case 1:
                    Controlador.criarConta();
                    break;
                case 2:
                    break;
                case 3:
                    Telas.mostrarMensagem("Encerrando. Até logo!");
                    break;
                default:
                    Telas.mostrarMensagem("Opção inválida. Tente novamente.");
            }

        } while (opcao != 3);
    }
}
