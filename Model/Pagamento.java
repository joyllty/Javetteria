package Model;

public interface Pagamento {
    boolean processarPagamento(double valor);
    String getFormaPagamento();
    boolean validarPagamento(double valor);
}
