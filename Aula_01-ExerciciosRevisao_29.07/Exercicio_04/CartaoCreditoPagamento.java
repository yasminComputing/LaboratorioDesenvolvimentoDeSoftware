
package com.mycompany.exercicio_04;

public class CartaoCreditoPagamento extends MetodoPagamento {
    
    public CartaoCreditoPagamento(String nomeMetodo) {
        super(nomeMetodo);
    }

    @Override
    void processaPagamento(double valor) {
        System.out.println("Pagamento no valor de R$ " + valor + " pagamento pelo cartão de crédito");
    }

    @Override
    String mostraDetalhesPagamento() {
        return "Método de Pagamento: cartão de crédito"
               +"\nID do pagamento: " + idPagamento;
    }
    
    
}
