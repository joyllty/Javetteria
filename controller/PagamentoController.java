package controller;

import model.*;

public class PagamentoController {
    
    // Cria pagamento com cartão
    public Pagamento criarPagamentoCartao(String numeroCartao) {
        return new PagamentoCartao(numeroCartao);
    }

    // Cria pagamento com PIX
    public Pagamento criarPagamentoPix(String chavePix) {
        return new PagamentoPix(chavePix);
    }

    // Cria pagamento em dinheiro
    public Pagamento criarPagamentoDinheiro(float valorRecebido) {
        return new PagamentoDinheiro(valorRecebido);
    }

    // Processa pagamento se válido
    public boolean processarPagamento(Pedido pedido, Pagamento pagamento) {
        if (validarPagamento(pedido, pagamento)) {
            return pedido.processarPagamento(pagamento);
        }
        return false;
    }

    // Valida se pagamento pode ser processado
    private boolean validarPagamento(Pedido pedido, Pagamento pagamento) {
        return pagamento.validarPagamento(pedido.getValorTotal());
    }

    // Calcula troco para pagamento em dinheiro
    public float calcularTroco(PagamentoDinheiro pagamento, float valorTotal) {
        if (pagamento.getValorRecebido() >= valorTotal) {
            return pagamento.getValorRecebido() - valorTotal;
        }
        return 0.0f;
    }
} 