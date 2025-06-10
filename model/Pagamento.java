package model;

public interface Pagamento {
    boolean processarPagamento(float valor);
    String getFormaPagamento();
    boolean validarPagamento(float valor);
}
