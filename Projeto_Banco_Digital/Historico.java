package Projeto_Banco_Digital;
import java.util.ArrayList;
import java.util.List;

public class Historico {

    private List<Transacao> transacoes = new ArrayList<>();

    public void adicionarTransacao(Transacao transacao) {
        transacoes.add(transacao);
    }

    public void listarTransacoes() {
        if (transacoes.isEmpty()) {
            System.out.println("Nenhuma transação encontrada.");
            return;
        }

        for (Transacao t : transacoes) {
            System.out.println(t);
        }
    }

    public List<Transacao> getTransacoes() {
        return transacoes;
    }
}