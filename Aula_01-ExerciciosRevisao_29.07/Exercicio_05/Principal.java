
package com.mycompany.exercicio_05;

/**
 *
 * @author yasmi
 */
public class Principal {
    public static void main(String[] args) {
        Calculadora calculadora = new Calculadora();
        
        System.out.println("Calculadora: ");
        System.out.println("Soma: " + calculadora.somar(40,15));
        System.out.println("Subtração: " + calculadora.subtrair(10, 5));
        System.out.println("Multiplicação: " + calculadora.multiplicar(10, 4));
        System.out.println("Divisão: " + calculadora.dividir(10, 0));
        System.out.println("Divisão: " + calculadora.dividir(10, 5));
        System.out.println("Raiz quadrada: " + calculadora.raizQuadrada(25, 0));
        System.out.println("Potência: " + calculadora.elevarPotencia(15, 2));
        System.out.println("Logaritmo base 10 de 100: " + calculadora.logaritmo10(100));
    }
}
