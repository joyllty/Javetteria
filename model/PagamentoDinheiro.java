package model;

public class PagamentoDinheiro implements Pagamento {
    private float valorRecebido;
    private float troco;

    public PagamentoDinheiro(float valorRecebido) {
        this.valorRecebido = valorRecebido;
    }

    @Override
    public boolean processarPagamento(float valor) {
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
    public boolean validarPagamento(float valor) {
        return valorRecebido >= valor && valor > 0;
    }

    public float getTroco() {
        return troco;
    }

    public float getValorRecebido() {
        return valorRecebido;
    }
}
