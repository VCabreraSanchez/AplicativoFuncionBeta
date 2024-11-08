
package Clases;

import java.math.BigInteger;
import java.math.BigDecimal;


public class CalculoBeta {
    
    //metodo Pasar Gamma a Factorial
    public int ConvertirFactorial(int var){
        if(var == 1){
            return var;
        }else{
            return var-1;
        }
    }
    //metodo Resolver Factoriales
    public BigInteger ResolverFactorial(int var) {
        if (var <= 1) {
            return BigInteger.ONE;
        } else {
            BigInteger factorial = BigInteger.ONE;
            for (int i = 2; i <= var; i++) {
                factorial = factorial.multiply(BigInteger.valueOf(i));
            }
            return factorial;
        }
    }
    //metodo Reolver divisiones
    public BigDecimal ResolverDivision(BigInteger varX, BigInteger varY){
        
        BigDecimal x = new BigDecimal(varX);
        BigDecimal y = new BigDecimal(varY);

        return x.divide(y, 15, BigDecimal.ROUND_HALF_UP); // Redondeo a 8 decimales
    }
    
}


