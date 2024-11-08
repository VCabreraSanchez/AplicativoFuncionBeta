package Controlador;
import javax.swing.*;
import java.awt.Desktop;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.net.URI;
import java.util.List;

import Clases.Beta;
import Clases.Recursos;


public class Controlador {
    private Beta funcionBeta;
    private Recursos recursos;
    private JList<String> listaRecursos;
    private List<Recursos.Recurso> listaRecursosObj;
    
    public void ProcesoCalculoBeta(JTextField txtVariable1, JTextField txtVariable2, JTextArea txtResultado) {
        try {
            int variable1 = Integer.parseInt(txtVariable1.getText());
            int variable2 = Integer.parseInt(txtVariable2.getText());
            funcionBeta = new Beta(variable1, variable2);
            // Construir el resultado paso a paso
            StringBuilder resultado = new StringBuilder();
            resultado.append("Cálculo de Beta(").append(variable1).append(",").append(variable2).append("):\n\n");
            // 1. Explicación de la función Beta
            resultado.append("----------    1. Explicación de la función Beta:  ----------\n");
            resultado.append("   - Beta(").append(variable1).append(",").append(variable2).append(") = Γ(")
                    .append(variable1).append(") Γ(").append(variable2).append(") / Γ(").append(variable1 + variable2).append(")\n\n");
            // Calcular los factoriales necesarios
            BigInteger factorialVariable1 = funcionBeta.calculador.ResolverFactorial(variable1 - 1);
            BigInteger factorialVariable2 = funcionBeta.calculador.ResolverFactorial(variable2 - 1);
            BigInteger factorialSuma = funcionBeta.calculador.ResolverFactorial(variable1 + variable2 - 1);
            // 2. Calcular los factoriales necesarios
            resultado.append("----------    2. Calcular los factoriales necesarios: ----------\n");
            resultado.append("     (Nota: Γ(n) representa el factorial de n - 1)\n\n");
            resultado.append("   - Γ(").append(variable1).append(") = Γ(").append(variable1 - 1).append(" + 1) = !").append(variable1 - 1).append("\n");
            resultado.append("     - !").append(variable1 - 1).append(" = ").append(factorialVariable1).append("\n");
            resultado.append("   - Γ(").append(variable2).append(") = Γ(").append(variable2 - 1).append(" + 1) = !").append(variable2 - 1).append("\n");
            resultado.append("     - !").append(variable2 - 1).append(" = ").append(factorialVariable2).append("\n");
            resultado.append("   - Γ(").append(variable1 + variable2).append(") = Γ(").append(variable1 + variable2 - 1).append(" + 1) = !").append(variable1 + variable2 - 1).append("\n");
            resultado.append("     - !").append(variable1 + variable2 - 1).append(" = ").append(factorialSuma).append("\n\n");
            // Calcular el resultado final de la función beta
            BigInteger resultadoFactoriales = factorialVariable1.multiply(factorialVariable2);
            BigDecimal resultadoDivision = funcionBeta.calculador.ResolverDivision(resultadoFactoriales, factorialSuma);
            // 3. Calcular el resultado final de la función beta
            resultado.append("----------    3. Calcular el resultado final de la función beta:  ----------\n");
            resultado.append("   - Multiplicar los factoriales obtenidos en el paso 2:\n\t").append(factorialVariable1).append(" * ").append(factorialVariable2)
                    .append(" = ").append(resultadoFactoriales).append("\n");
            resultado.append("   - Dividir el resultado entre el factorial de la suma de las variables:\n\t").append(resultadoFactoriales).append(" / ")
                    .append(factorialSuma).append("\n");
            resultado.append("   - RESULTADO: ").append(String.format("%.15f", resultadoDivision));
            // Mostrar el resultado en el JTextArea
            txtResultado.setText(resultado.toString());
        } catch (NumberFormatException e) {
            // Manejar la excepción si no se ingresaron números válidos en los campos de texto
            txtResultado.setText("Por favor, ingrese números válidos en los campos.");
        }
    }
    
    public void inicializar(JList<String> listaRecursos) {
        recursos = new Recursos();
        listaRecursosObj = recursos.getRecursos();
        
        // Poblar JList con los títulos
        DefaultListModel<String> modelo = new DefaultListModel<>();
        for (Recursos.Recurso recurso : listaRecursosObj) {
            modelo.addElement(recurso.getTitulo());
        }
        listaRecursos.setModel(modelo);

        // Agregar evento de selección
        listaRecursos.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (e.getClickCount() == 2) {
                    int index = listaRecursos.locationToIndex(e.getPoint());
                    abrirEnlace(index);
                }
            }
        });
    }
    
    public void abrirEnlace(int index) {
        if (index >= 0 && index < listaRecursosObj.size()) {
            Recursos.Recurso recurso = listaRecursosObj.get(index);
            try {
                Desktop.getDesktop().browse(new URI(recurso.getEnlace()));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
    
}
