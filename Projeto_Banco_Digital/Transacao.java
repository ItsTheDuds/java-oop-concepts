package Projeto_Banco_Digital;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.ResolverStyle;

public class Transacao {

    private String tipo; // Ex: "DEPÓSITO", "SAQUE"
    private double valor;
    private LocalDateTime data;
    private static final DateTimeFormatter FORMATADOR = DateTimeFormatter
                    .ofPattern("dd/MM/uuuu")
                    .withResolverStyle(ResolverStyle.STRICT);

    public Transacao(String tipo, double valor, String data) {
        this.tipo = tipo;
        this.valor = valor;
        this.data = LocalDateTime.parse(data, FORMATADOR);
    }

    public String getTipo() {
        return this.tipo;
    }

    public double getValor() {
        return this.valor;
    }

    public String getData() {
        return this.data.format(FORMATADOR);
    }

    @Override
    public String toString() {
        return String.format
            ("Tipo: %-22s | Valor: R$ %10.2f | Data: %s", this.tipo, this.valor, this.data.format(FORMATADOR));
    }
}