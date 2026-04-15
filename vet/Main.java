package vet;

public class Main {

    public static void main(String[] args) {
        // Instância do controlador
        Controlador controlador = new Controlador();
        int opcao;

        do {
            // Exibe o menu principal
            Telas.menuPrincipal();
            opcao = Telas.lerOpcao();

            switch (opcao) {
                case 1: 
                    controlador.adicionarAnimal();
                    break;

                case 2: 
                    controlador.atenderAnimal();
                    break;

                case 3:
                    controlador.verFila();
                    break;

                case 4: 
                    controlador.verHistorico();
                    break;

                case 5:
                    controlador.listaVeterinarios();
                    break;
                case 0: 
                    Telas.mensagem("Saindo do sistema. Até logo!", false);
                    break;

                default:
                    Telas.mensagem("Opção inválida. Tente novamente.", true);
                    break;
            }

        } while (opcao != 0); 
    }
}