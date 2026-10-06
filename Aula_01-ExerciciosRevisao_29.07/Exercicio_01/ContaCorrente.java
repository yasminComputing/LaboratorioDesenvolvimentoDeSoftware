/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.projetoconta;

/**
 *
 * @author laboratorio
 */
public class ContaCorrente {
    private float saldo;
    
    
    public void definirSaldoInicial(float valor){
        this.saldo = valor;
    }
    public void depositar(float valor){
         saldo += valor;
    }
    public boolean sacar(float valor){
       if(valor <= getSaldo()){
           saldo -= valor;
           return true;
       }  
      
       return false;
       }
    

    /**
     * @return the saldo
     */
    public float getSaldo() {
        return saldo;
    }
    
   
}