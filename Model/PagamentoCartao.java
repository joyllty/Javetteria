package Model;

public class PagamentoCartao implements Pagamento {
    private String numeroCartao;

    public PagamentoCartao(String numeroCartao) {
        this.numeroCartao = numeroCartao;
    }

    @Override
    public boolean processarPagamento(double valor) {
        return validarPagamento(valor);
    }

    @Override
    public String getFormaPagamento() {
        return "Cartão";
    }

    @Override
    public boolean validarPagamento(double valor) {
        return numeroCartao != null && !numeroCartao.isEmpty() && valor > 0;
    }
}
