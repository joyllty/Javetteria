package model;

public class PagamentoDinheiro implements Pagamento {
    private float valorRecebido;
    private float troco;

    public PagamentoDinheiro(float valorRecebido) {
        this.valorRecebido = valorRecebido;
    }

    // Processa pagamento e calcula troco se valor recebido for suficiente
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

    // Valida se valor recebido é suficiente e valor da compra é positivo
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
