
package com.mycompany.exercicio_04;

abstract class MetodoPagamento {

    private String nomeMetodo;
    protected int idPagamento;
    
    public MetodoPagamento(String nomeMetodo){
        this.nomeMetodo = nomeMetodo;
        this.idPagamento = (int)(Math.random() * 900) + 1000;
    }

    public String getNomeMetodo() {
        return nomeMetodo;
    }

    public void setNomeMetodo(String nomeMetodo) {
        this.nomeMetodo = nomeMetodo;
    }
    
    abstract void processaPagamento(double valor);
    abstract String mostraDetalhesPagamento();
}
