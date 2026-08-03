
package com.mycompany.exercicio_04;


public class PIXPagamento extends MetodoPagamento {

    public PIXPagamento(String nomeMetodo) {
        super(nomeMetodo);
    }

    @Override
    void processaPagamento(double valor) {
        System.out.println("Pagamento no valor de R$ " + valor + " PIX");
    }

    @Override
    String mostraDetalhesPagamento() {
        return "Método de Pagamento: PIX"
                +"\nID do pagamento: " + idPagamento;
    }
    
}
