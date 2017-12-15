/**
 * 
 */
package View;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;

/**
 *
 * @author Cristhian Eduardo Castillo Erazo
 */
public class PanelTitulo extends JPanel 
{
    // -------------------------------------------------------------------------
    //  Constantes
    // -------------------------------------------------------------------------
    
    // -------------------------------------------------------------------------
    //  Atributos
    // -------------------------------------------------------------------------
    
    private JLabel imagen;
    
    // -------------------------------------------------------------------------
    //  Constructores
    // -------------------------------------------------------------------------
    
    /**
     * Construye el panel con la imagen decorativa.
     */
    public PanelTitulo()
    {
        FlowLayout layout = new FlowLayout();
        layout.setHgap(0);
        layout.setVgap(0);
        
        this.setLayout(layout);
        imagen = new JLabel(" ");
        ImageIcon icono = new ImageIcon("data/titulo.jpg");
        imagen.setIcon(icono);        
        add(imagen);
        
        this.setBackground(Color.WHITE);
        this.setBorder(new LineBorder(java.awt.Color.GRAY));
    }
    
    // -------------------------------------------------------------------------
    //  Metodos
    // -------------------------------------------------------------------------
}
