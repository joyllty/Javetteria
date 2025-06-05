package Controller;

import Model.*;

public class PagamentoController {
    
   
    public Pagamento criarPagamentoCartao(String numeroCartao) {
        return new PagamentoCartao(numeroCartao);
    }

    
    public Pagamento criarPagamentoPix(String chavePix) {
        return new PagamentoPix(chavePix);
    }

    public Pagamento criarPagamentoDinheiro(float valorRecebido) {
        return new PagamentoDinheiro(valorRecebido);
    }

    
    public boolean processarPagamento(Pedido pedido, Pagamento pagamento) {
        if (validarPagamento(pedido, pagamento)) {
            return pedido.processarPagamento(pagamento);
        }
        return false;
    }


    private boolean validarPagamento(Pedido pedido, Pagamento pagamento) {
        return pagamento.validarPagamento(pedido.getValorTotal());
    }


    public float calcularTroco(PagamentoDinheiro pagamento, float valorTotal) {
        if (pagamento.getValorRecebido() >= valorTotal) {
            return pagamento.getValorRecebido() - valorTotal;
        }
        return 0.0f;
    }
} 