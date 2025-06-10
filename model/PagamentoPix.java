package model;

public class PagamentoPix implements Pagamento {
    private String chavePix;
    private String comprovante;

    public PagamentoPix(String chavePix) {
        this.chavePix = chavePix;
    }

    // Processa pagamento e gera comprovante se válido
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

    // Valida se chave PIX existe e valor é positivo
    @Override
    public boolean validarPagamento(float valor) {
        return chavePix != null && !chavePix.isEmpty() && valor > 0;
    }

    // Gera comprovante único baseado no timestamp
    private String gerarComprovante() {
        return "PIX_" + System.currentTimeMillis();
    }

    public String getComprovante() {
        return comprovante;
    }
}
