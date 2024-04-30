package co.edu.ude.poo.procesospoliticos;

import co.edu.ude.poo.procesospoliticos.vistas.gui.VentanaPrincipal;

public class Principal {
    
    public static void main(String[] args) {
        
        
        VentanaPrincipal v1 = new VentanaPrincipal();
        v1.setLocationRelativeTo(null);
        //v1.setExtendedState(VentanaPrincipal.MAXIMIZED_BOTH);
        v1.setVisible(true);
    }
}
