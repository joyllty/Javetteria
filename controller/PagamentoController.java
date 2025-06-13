package controller;

import model.*;
import utils.InputHelper;

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

    public boolean processarPagamentoCompleto(Pedido pedido, int formaPagamento, String dadosPagamento) {
        Pagamento pagamento = null;
        
        switch (formaPagamento) {
            case 1 -> pagamento = criarPagamentoCartao(dadosPagamento);
            case 2 -> pagamento = criarPagamentoPix(dadosPagamento);
            case 3 -> {
                try {
                    float valorRecebido = Float.parseFloat(dadosPagamento);
                    pagamento = criarPagamentoDinheiro(valorRecebido);
                } catch (NumberFormatException e) {
                    return false;
                }
            }
            default -> {
                return false;
            }
        }
        
        return processarPagamento(pedido, pagamento);
    }

    public String obterInformacoesPagamento(Pagamento pagamento, float valorTotal) {
        StringBuilder info = new StringBuilder();
        
        if (pagamento instanceof PagamentoPix pix) {
            info.append("Comprovante PIX: ").append(pix.getComprovante());
        }
        if (pagamento instanceof PagamentoDinheiro dinheiro) {
            float troco = calcularTroco(dinheiro, valorTotal);
            info.append("Troco: R$ ").append(String.format("%.2f", troco));
        }
        
        return info.toString();
    }
} 