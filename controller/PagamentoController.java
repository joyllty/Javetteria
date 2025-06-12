package controller;

import model.*;
import utils.InputHelper;

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

    // Processa o pagamento com a forma selecionada
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

    // Obtém informações do pagamento para exibição
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