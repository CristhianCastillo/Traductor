/**
 * 
 */
package View;

import Controller.Controlador;
import java.awt.BorderLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 * @version 1.0
 * @author Cristhian Eduardo Castillo Erazo
 * Description: 
 */
public class InterfazApp extends JFrame
{
    // -------------------------------------------------------------------------
    //  Constantes
    // -------------------------------------------------------------------------
    
    // -------------------------------------------------------------------------
    //  Atributos
    // -------------------------------------------------------------------------
    
    private PanelTitulo pnlTitulo;
    
    private PanelTraduccion pnlTraduccion;
    
    private PanelPalabras pnlPalabras;
    
    private PanelDiccionarios pnlDiccionarios;
    
    private PanelOpciones pnlOpciones;
    
    // -------------------------------------------------------------------------
    //  Constructores
    // -------------------------------------------------------------------------
    
    public InterfazApp()
    {
        Controlador ctrl = new Controlador();
        this.setTitle("Traductor");
        this.setLayout(new BorderLayout());
        
        pnlTitulo = new PanelTitulo();
        
        JPanel pnlPendiente = new JPanel();
        pnlPendiente.setLayout(new BorderLayout());
        pnlTraduccion = new PanelTraduccion(ctrl);
        pnlPalabras = new PanelPalabras(ctrl);
        pnlDiccionarios = new PanelDiccionarios();
        pnlPendiente.add(pnlTraduccion, BorderLayout.NORTH);
        pnlPendiente.add(pnlPalabras, BorderLayout.CENTER);
        pnlPendiente.add(pnlDiccionarios, BorderLayout.SOUTH);
        
        pnlOpciones = new PanelOpciones(ctrl);
        
        add(pnlTitulo, BorderLayout.NORTH);
        add(pnlPendiente, BorderLayout.CENTER);
        add(pnlOpciones, BorderLayout.SOUTH);
        
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        this.setResizable(false);
        //this.pack();
        this.setSize(720,425);
        this.setLocationRelativeTo(null);
        
        ctrl.conectar(pnlPalabras, pnlDiccionarios, pnlTraduccion);
    }
    // -------------------------------------------------------------------------
    //  Metodos
    // -------------------------------------------------------------------------
    public static final void main (String arg0s[])
    {
        InterfazApp interfaz = new InterfazApp();
        interfaz.setVisible(true);
    }
}
