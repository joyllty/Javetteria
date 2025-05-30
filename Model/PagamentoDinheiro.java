package Model;

public class PagamentoDinheiro implements Pagamento {
    private double valorRecebido;
    private double troco;

    public PagamentoDinheiro(double valorRecebido) {
        this.valorRecebido = valorRecebido;
    }

    @Override
    public boolean processarPagamento(double valor) {
        if (validarPagamento(valor)) {
            this.troco = valorRecebido - valor;
            return true;
        }
        return false;
    }

    @Override
    public String getFormaPagamento() {
        return "Dinheiro";
    }

    @Override
    public boolean validarPagamento(double valor) {
        return valorRecebido >= valor && valor > 0;
    }

    public double getTroco() {
        return troco;
    }

    public double getValorRecebido() {
        return valorRecebido;
    }
}
