package Contability.dto;
import java.time.OffsetDateTime;


public class TransactionRequest {
    @org.antlr.v4.runtime.misc.NotNull
    private double valor;

    @org.antlr.v4.runtime.misc.NotNull
    private OffsetDateTime dataHora;

    public double getValor() {
        return valor;
    }

    public OffsetDateTime getDataHora() {
        return dataHora;
    }
}
