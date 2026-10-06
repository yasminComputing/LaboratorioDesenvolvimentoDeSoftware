/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.projetoconta;

/**
 *
 * @author laboratorio
 */
public class ProjetoConta {

    public static void main(String[] args) {
        
        ContaCorrente conta = new ContaCorrente();
        
        conta.definirSaldoInicial(1000);
        
        if(conta.sacar(500)){
            System.out.println("Saque efetuado");
        }
        
        
        conta.depositar(50);
        
        System.out.println("Saldo: R$ " + conta.getSaldo());
        
        if(conta.sacar(600)){
            System.out.println("Saque efetuado");
        }else{
            System.out.println("Saque não efetuado");
        }
       
        
        
    }
}
