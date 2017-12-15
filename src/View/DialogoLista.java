/**
 * 
 */
package View;

import Model.Traduccion;
import Model.Traductor;
import java.awt.BorderLayout;
import java.awt.Font;
import java.util.ArrayList;
import javax.swing.JDialog;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Cristhian Eduardo Castillo Erazo.
 */
public class DialogoLista extends JDialog 
{
    // -------------------------------------------------------------------------
    //  Constantes
    // -------------------------------------------------------------------------
    
    public static final String [] COLUMNAS = {"Español", "Inglés"};
    // -------------------------------------------------------------------------
    //  Atributos
    // -------------------------------------------------------------------------
    
    private JTable tabla;
    
    private DefaultTableModel modelo;
    // -------------------------------------------------------------------------
    //  Constructores
    // -------------------------------------------------------------------------
    
    public DialogoLista(ArrayList <Traduccion>traductor)
    {
        this.setTitle("Lista Español - Inglés");
        this.setLayout(new BorderLayout());
        
        modelo = new DefaultTableModel(COLUMNAS,0);
        tabla = new JTable(modelo);
        
        tabla.setColumnSelectionAllowed(false);
        tabla.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        tabla.setFont(new Font("Gregorian", Font.BOLD,12));
        tabla.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
        tabla.getTableHeader().setReorderingAllowed(false);
        
        for(int i = 0; i < traductor.size(); i ++)
        {
            String [] fila  = new String [2];
            fila [0] = traductor.get(i).getPalabraOrigen();
            fila [1] = traductor.get(i).getPalabraDestino();
            modelo.addRow(fila);
        }
        
        JScrollPane scroll = new JScrollPane();
        scroll.setViewportView(tabla);
        scroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        scroll.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        
        add(scroll, BorderLayout.CENTER);
        
        setSize(300,200);
        
    }
    // -------------------------------------------------------------------------
    //  Metodos
    // -------------------------------------------------------------------------
}
