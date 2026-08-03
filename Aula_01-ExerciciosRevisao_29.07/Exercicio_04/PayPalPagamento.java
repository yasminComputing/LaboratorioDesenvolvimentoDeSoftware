
package com.mycompany.exercicio_04;


public class PayPalPagamento extends MetodoPagamento{

    public PayPalPagamento(String nomeMetodo) {
        super(nomeMetodo);
    }

    @Override
    void processaPagamento(double valor) {
        System.out.println("Pagamento no valor de R$ " + valor + " PayPal");
    }

    @Override
    String mostraDetalhesPagamento() {
        return "Método de Pagamento: PayPal"
                +"\nID do pagamento: " + idPagamento;
    }
    
}
