package model;

public class PagamentoCartao implements Pagamento {
    private String numeroCartao;

    public PagamentoCartao(String numeroCartao) {
        this.numeroCartao = numeroCartao;
    }

    // Processa pagamento se cartão for válido
    @Override
    public boolean processarPagamento(float valor) {
        return validarPagamento(valor);
    }

    @Override
    public String getFormaPagamento() {
        return "Cartão";
    }

    // Valida se número do cartão existe e valor é positivo
    @Override
    public boolean validarPagamento(float valor) {
        return numeroCartao != null && !numeroCartao.isEmpty() && valor > 0;
    }
}
