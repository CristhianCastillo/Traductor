/**
 * 
 */
package View;

import Controller.Controlador;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;

/**
 * @author Cristhian Eduardo Castillo Erazo
 * Muestra las opciones adicionales de la aplicación.
 */
public class PanelOpciones extends JPanel implements ActionListener  
{
    // -------------------------------------------------------------------------
    //  Constantes
    // -------------------------------------------------------------------------
        
    public static final String OPCION_UNO = "Opcion1";
    
    public static final String OPCION_DOS = "Opcion2";
    
    public static final String OPCION_TRES = "Opcion3";
    // -------------------------------------------------------------------------
    //  Atributos
    // -------------------------------------------------------------------------
    
    private JButton btnOpcionUno;
    
    private JButton btnOpcionDos;
    
    private JButton btnOpcionTres;
    
    private Controlador ctrl;
    // -------------------------------------------------------------------------
    //  Constructores
    // -------------------------------------------------------------------------
    
    public PanelOpciones(Controlador ctrl)
    {
        this.ctrl = ctrl;
        this.setBorder(new TitledBorder("Opciones"));
        this.setLayout(new FlowLayout());
        
        btnOpcionUno = new JButton("Opción 1");
        btnOpcionUno.setActionCommand(OPCION_UNO);
        btnOpcionUno.addActionListener(this);
        
        btnOpcionDos = new JButton("Opción 2");
        btnOpcionDos.setActionCommand(OPCION_DOS);
        btnOpcionDos.addActionListener(this);
        
        btnOpcionTres = new JButton("Opción 3");
        btnOpcionTres.setActionCommand(OPCION_TRES);
        btnOpcionTres.addActionListener(this);
        
        add(btnOpcionUno);
        add(btnOpcionDos);
        add(btnOpcionTres);
    }
    // -------------------------------------------------------------------------
    //  Metodos
    // -------------------------------------------------------------------------

    @Override
    public void actionPerformed(ActionEvent e)
    {
       String comando = e.getActionCommand();
       
       if(comando.equalsIgnoreCase(OPCION_UNO))
       {
           ctrl.opcionUno();
       }
       else
       {
           if(comando.equalsIgnoreCase(OPCION_DOS))
           {
               DialogoLista dialogo = new DialogoLista(ctrl.opcionDos());
               dialogo.setLocationRelativeTo(null);
               dialogo.setVisible(true);
           } 
           else
           {
               if(comando.equalsIgnoreCase(OPCION_TRES))
               {
                   ctrl.opcionTres();
               }
           }
       }
       
       
       
       
    }
    
}
