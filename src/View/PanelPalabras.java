/**
 * 
 */
package View;

import Controller.Controlador;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;

/**
 * Representa el panel Agregar Palabras
 * @author Cristhian Eduardo Castillo Erazo.
 */
public class PanelPalabras extends JPanel implements ActionListener
{
    // -------------------------------------------------------------------------
    //  Constantes
    // -------------------------------------------------------------------------
    
    public static final String AGREGAR = "Agregar";
    
    public static final String LIMPIAR = "Limpiar";
    
    // -------------------------------------------------------------------------
    //  Atributos
    // -------------------------------------------------------------------------
    
    private JLabel lblPalabraEspaniol;
    
    private JLabel lblPalabraTraducida;
    
    private JLabel lblIdiomaTraduccion;
    
    private JTextField txtPalabraEspaniol;
    
    private JTextField txtPalabraTraducida;
    
    private JComboBox cbxTraduccion;
    
    private JButton btnAgregar;
    
    private JButton btnLimpiar;
    
    private Controlador ctrl;
    // -------------------------------------------------------------------------
    //  Constructores
    // -------------------------------------------------------------------------
    
    public PanelPalabras(Controlador ctrl)
    {
        this.ctrl = ctrl;
        this.setBorder(new TitledBorder("Agregar palabras"));
        this.setLayout(new GridLayout(2,5,10,10));
        
        lblPalabraEspaniol = new JLabel("Palabra en español");
        lblPalabraTraducida = new JLabel("Palabra traducida");
        lblIdiomaTraduccion = new JLabel("Idioma traducción");
        
        txtPalabraEspaniol = new JTextField();
        txtPalabraTraducida = new JTextField();
        
        String opciones [] = {"Inglés", "Francés", "Italiano"};
        cbxTraduccion =  new JComboBox(opciones);

        btnAgregar = new JButton("Agregar");
        btnAgregar.setActionCommand(AGREGAR);
        btnAgregar.addActionListener(this);
        
        btnLimpiar = new JButton("Limpiar");
        btnLimpiar.setActionCommand(LIMPIAR);
        btnLimpiar.addActionListener(this);
        
        add(lblPalabraEspaniol);
        add(lblPalabraTraducida);
        add(lblIdiomaTraduccion);
        add(new JLabel(""));
        add(new JLabel(""));
        add(txtPalabraEspaniol);
        add(txtPalabraTraducida);
        add(cbxTraduccion);
        add(btnAgregar);
        add(btnLimpiar);
         
    }
    // -------------------------------------------------------------------------
    //  Metodos
    // -------------------------------------------------------------------------
    @Override
    public void actionPerformed(ActionEvent e) 
    {
        String comando = e.getActionCommand();
        if(comando.equalsIgnoreCase(AGREGAR))
        {
            if(txtPalabraEspaniol.getText().trim().equalsIgnoreCase("") || txtPalabraTraducida.getText().trim().equalsIgnoreCase(""))
            {
                JOptionPane.showMessageDialog(this, "Verifique la información ingresada.", "Agregar Palabra", JOptionPane.ERROR_MESSAGE);
            }
            else
            {
                String idioma = cbxTraduccion.getSelectedItem().toString();
                ctrl.agregarTraduccion(idioma, txtPalabraEspaniol.getText(), txtPalabraTraducida.getText());
            }
        }
        else
        {
            if(comando.equalsIgnoreCase(LIMPIAR))
            {
                txtPalabraEspaniol.setText("");
                txtPalabraTraducida.setText("");
            }
        }
    }
    
}
