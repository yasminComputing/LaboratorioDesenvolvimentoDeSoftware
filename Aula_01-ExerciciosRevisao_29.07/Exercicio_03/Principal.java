
package sobrecarga;
public class Principal {
    public static void main(String[] args) {
        Casa c = new Casa();
        System.out.println("Preco da casa: R$  " + c.calcularPreco(70));
        
        System.out.println("Preco da casa com adicional dos quartos: R$ "+ c.calcularPreco(70, 3));
    }
}
