/**
 * 
 */
package View;


import java.awt.GridLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;




/**
 * Panel que muestra la cantidad de palabras en cada diccionario.
 * @author Cristhian Eduardo Castillo Erazo 
 */
public class PanelDiccionarios extends JPanel 
{   
    // -------------------------------------------------------------------------
    //  Constantes
    // -------------------------------------------------------------------------
    
    // -------------------------------------------------------------------------
    //  Atributos
    // -------------------------------------------------------------------------
    
    private JLabel lblIngles;
    
    private JTextField txtResultadoIngles;
    
    private JLabel lblFrances;
    
    private JTextField txtResultadoFrances;
    
    private JLabel lblItailiano;
    
    private JTextField txtResultadoItaliano;
    
    // -------------------------------------------------------------------------
    //  Constructores
    // -------------------------------------------------------------------------
    
    public PanelDiccionarios()
    {
        this.setBorder(new TitledBorder("Cantidad de Traducciones"));
        this.setLayout(new GridLayout(1, 6,10,10));
        
        lblIngles = new JLabel("Inglés:");

        txtResultadoIngles = new JTextField("0");
        txtResultadoIngles.setEditable(false);

        lblFrances = new JLabel("Francés:");

        txtResultadoFrances = new JTextField("0");
        txtResultadoFrances.setEditable(false);
        
        lblItailiano = new JLabel("Italiano:");

        txtResultadoItaliano = new JTextField("0");
        txtResultadoItaliano.setEditable(false);

        add(lblIngles);
        add(txtResultadoIngles);
        add(lblFrances);
        add(txtResultadoFrances);
        add(lblItailiano);
        add(txtResultadoItaliano);
    }
    
    // -------------------------------------------------------------------------
    //  Metodos
    // -------------------------------------------------------------------------
    
    /**
     * Actualiza el nuemero de pañabras en el diccionario Español-Inglés.
     * @param numeroPalabras numero actual de palabras. 
     */
    public void setIngles(int numeroPalabras)
    {
        txtResultadoIngles.setText(numeroPalabras + "");
    }
    
    /**
     * Actualiza el nuemero de pañabras en el diccionario Español-Francés.
     * @param numeroPalabras numero actual de palabras. 
     */
    public void setFrances(int numeroPalabras)
    {
        txtResultadoFrances.setText(numeroPalabras + "");
    }
    
    /**
     * Actualiza el nuemero de pañabras en el diccionario Español-Italiano.
     * @param numeroPalabras numero actual de palabras. 
     */
    public void setItaliano(int numeroPalabras)
    {
        txtResultadoItaliano.setText(numeroPalabras +"");
    }
    
}
