
package Clases;

public class Beta {
    
    private int varX;
    private int varY;
    public CalculoBeta calculador;
    
    public Beta(int varX, int varY){
        this.varX = varX;
        this.varY = varY;
        this.calculador = new CalculoBeta();
    }
    
    //metodo Get y Set
    public int getvarX() {
        return varX;
    }
    
    public void setvarX(int varX) {
        this.varX = varX;
    }

    public int getvarY() {
        return varY;
    }

    public void setvarY(int varY) {
        this.varY = varY;
    }
    
}



