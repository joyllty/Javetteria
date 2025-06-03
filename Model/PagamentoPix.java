package Model;

public class PagamentoPix implements Pagamento {
    private String chavePix;
    private String comprovante;

    public PagamentoPix(String chavePix) {
        this.chavePix = chavePix;
    }

    @Override
    public boolean processarPagamento(float valor) {
        if (validarPagamento(valor)) {
            this.comprovante = gerarComprovante();
            return true;
        }
        return false;
    }

    @Override
    public String getFormaPagamento() {
        return "PIX";
    }

    @Override
    public boolean validarPagamento(float valor) {
        return chavePix != null && !chavePix.isEmpty() && valor > 0;
    }

    private String gerarComprovante() {
        // Simulação de geração de comprovante
        return "PIX_" + System.currentTimeMillis();
    }

    public String getComprovante() {
        return comprovante;
    }
}
