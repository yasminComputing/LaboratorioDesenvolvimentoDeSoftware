
package sobrecarga;

public class Casa {
    public float valor;
    
    public float calcularPreco(int tamanho){
        valor = 4300 * tamanho;
        return valor;
    }
    
    public float calcularPreco(int tamanho,int numeroDeQuartos){
      valor = (4300 * tamanho) + (2500 * numeroDeQuartos);
      return valor;
    }
    
    
   
}
