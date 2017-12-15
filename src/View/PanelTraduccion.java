/**
 * 
 */
package View;

import Controller.Controlador;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;

/**
 * Panel responsable de permitir al usuario realizar las consultas de 
 * traducciones de palabras.
 * @author Cristhian Eduardo Castillo Erazo.
 */


public class PanelTraduccion extends JPanel implements ActionListener
{
    // -------------------------------------------------------------------------
    //  Constantes
    // -------------------------------------------------------------------------
    
    /**
     * Constante utilizada para capturar el evento del boton.
     */
    public static final String TRADUCIR = "Traducir";
        
    /**
     * Constante utilizada para capturar el evento del boton.
     */
    public static final String LIMPIAR = "Limpiar";
    
    // -------------------------------------------------------------------------
    //  Atributos Interfaz
    // -------------------------------------------------------------------------
    
    /**
     * Indica al usuario donde debe ingresar la palabra a traducir.
     */
    private JLabel lblPalabra;
    
    /**
     * Indica donde se debe seleccionaro el idioma origen.
     */
    private JLabel lblIdiomaOrigen;
    
    /**
     * Indica donde se debe seleccionar el idioma destino.
     */
    private JLabel lblIdiomaDestion;
    
    /**
     * Indica donde aparecera la traduccion de la palabra.
     */
    private JLabel lblTraduccion;
    
    /**
     * Muestra al usuario la traduccion de la palabra ingresada.
     */
    private JTextField txtResultadoTraduccion;
    
    /**
     * Permite ingresar la palabra a traducir.
     */
    private JTextField txtPalabra;
    
    /**
     * Permite seleccionar el idioma origen.
     */
    private JComboBox cbxIdiomaOrigen;
    
    /**
     * Permite seleccionar el idioma destino.
     */
    private JComboBox cbxIdiomaDestino;
    
    /**
     * Permite realizar el proceso de traduccion de la palabra.
     */
    private JButton btnTraducir;
    
    /**
     * Permite limipar el diccionario.
     */
    private JButton btnLimpiar;
  
    /**
     * Controlador principal de la aplicación.
     */
    private Controlador ctrl;
    
    // -------------------------------------------------------------------------
    //  Constructores
    // -------------------------------------------------------------------------
    
    public PanelTraduccion(Controlador ctrl)
    {
        this.ctrl = ctrl;
        this.setBorder(new TitledBorder("Consulta de traducciones"));
        this.setLayout(new GridLayout(2, 6, 10, 10));
        
        lblPalabra = new JLabel("Palabra");
        lblIdiomaOrigen = new JLabel("Idioma origen");
        lblIdiomaDestion = new JLabel("Idioma destino");
        lblTraduccion = new JLabel("Traducción");
        
        txtPalabra = new JTextField();
        
        String [] idiomas = {"Español", "Francés", "Inglés", "Italiano"};

        
        cbxIdiomaOrigen = new JComboBox(idiomas);
        
        cbxIdiomaDestino = new JComboBox(idiomas);
        
        txtResultadoTraduccion = new JTextField();
        txtResultadoTraduccion.setEditable(false);
        
        btnTraducir = new JButton("Traducir");
        btnTraducir.setActionCommand(TRADUCIR);
        btnTraducir.addActionListener(this);
        
        btnLimpiar = new JButton("Limpiar");
        btnLimpiar.setActionCommand(LIMPIAR);
        btnLimpiar.addActionListener(this);
        
        this.add(lblPalabra);
        this.add(lblIdiomaOrigen);
        this.add(lblIdiomaDestion);
        this.add(lblTraduccion);
        this.add(new JLabel(""));
        this.add(new JLabel(""));
        
        this.add(txtPalabra);
        this.add(cbxIdiomaOrigen);
        this.add(cbxIdiomaDestino);
        this.add(txtResultadoTraduccion);
        this.add(btnTraducir);
        this.add(btnLimpiar);
        
    }

    // -------------------------------------------------------------------------
    //  Metodos
    // -------------------------------------------------------------------------

    @Override
    public void actionPerformed(ActionEvent e) 
    {
        String comando = e.getActionCommand();
        
        if(comando.equalsIgnoreCase(TRADUCIR))
        {
            String idiomaOrigen = cbxIdiomaOrigen.getSelectedItem().toString();
            String idiomaDestino = cbxIdiomaDestino.getSelectedItem().toString();
            
            if(idiomaOrigen.equalsIgnoreCase(idiomaDestino))
            {
                JOptionPane.showMessageDialog(this, "No se puede traducir al mismo idioma.", "Traducir palabra", JOptionPane.ERROR_MESSAGE);
            }
            else
            {
                if(txtPalabra.getText().trim().equalsIgnoreCase(""))
                {
                    JOptionPane.showMessageDialog(this, "El campo 'Palabra' debe ser distino de vacio.", "Traducir palabra", JOptionPane.ERROR_MESSAGE);
                }
                else
                {
                    ctrl.consultarTraduccion(idiomaOrigen, idiomaDestino, txtPalabra.getText());
                }
            }
        }
        else
        {
            if(comando.equalsIgnoreCase(LIMPIAR))
            {
                txtPalabra.setText("");
                txtResultadoTraduccion.setText("");
            }
        }
           
        
        
    }
    
    public void setTraduccion(String traduccion)
    {
        txtResultadoTraduccion.setText(traduccion);
    }
    
    public String getIdiomaOrigen()
    {
        return cbxIdiomaOrigen.getSelectedItem().toString();
    }
    
}
