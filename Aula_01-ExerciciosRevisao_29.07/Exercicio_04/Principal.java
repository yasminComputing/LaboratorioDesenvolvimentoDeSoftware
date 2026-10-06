/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.exercicio_04;

/**
 *
 * @author yasmi
 */
public class Principal {
    public static void main(String[] args) {
        CartaoCreditoPagamento credito = new CartaoCreditoPagamento("Cartão de Crédito");
       
        credito.processaPagamento(300);
        System.out.println(credito.mostraDetalhesPagamento());
        System.out.println("------------------------");
        
        PayPalPagamento payPal = new PayPalPagamento("PayPal");
        payPal.processaPagamento(500);
        System.out.println(payPal.mostraDetalhesPagamento());
        System.out.println("------------------------");
        
        PIXPagamento pix = new PIXPagamento("PIX");
        pix.processaPagamento(900);
        System.out.println(pix.mostraDetalhesPagamento());
        System.out.println("------------------------");
        
        
        
    }
}
