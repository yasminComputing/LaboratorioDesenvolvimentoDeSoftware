
package polimorfismo;

public class FormaGeometrica {
    private float lado;
    protected float area;
  
    public float getLado() {
        return lado;
    }

    public void setLado(float lado) {
        this.lado = lado;
    }

    public float getArea() {
        return area;
    }
    public float calcularArea(){
        area = getLado() * getLado();
        return area;
    }


    
    
}
