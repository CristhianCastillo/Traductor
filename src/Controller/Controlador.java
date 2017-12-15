/**
 * 
 */
package Controller;

import Model.Traduccion;
import Model.Traductor;
import View.PanelDiccionarios;
import View.PanelPalabras;
import View.PanelTraduccion;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author Cristhian Eduardo Castillo Erazo.
 */

public class Controlador 
{
    // -------------------------------------------------------------------------
    //  Constantes
    // -------------------------------------------------------------------------
    
    // -------------------------------------------------------------------------
    //  Atributos
    // -------------------------------------------------------------------------
    
    private Traductor diccionarioEspaniol_Ingles;
    
    private Traductor diccionarioEspaniol_Frances;
    
    private Traductor diccionarioEspaniol_Italiano;
    
    private PanelPalabras pnlPalabras;
    
    private PanelDiccionarios pnlDiccionarios;
    
    private PanelTraduccion pnlTraduccion;
    
    // -------------------------------------------------------------------------
    //  Constructores
    // -------------------------------------------------------------------------
    
    public Controlador()
    {
        diccionarioEspaniol_Ingles = new Traductor("Inglés");
        diccionarioEspaniol_Frances = new Traductor("Francés");
        diccionarioEspaniol_Italiano = new Traductor("Italiano");
    }
   
    // -------------------------------------------------------------------------
    //  Metodos
    // -------------------------------------------------------------------------
    
    public void conectar(PanelPalabras pPnlPalabras, PanelDiccionarios pPnlDiccionarios, PanelTraduccion pPnlTraduccion)
    {
        this.pnlPalabras = pPnlPalabras;
        this.pnlDiccionarios = pPnlDiccionarios;
        this.pnlTraduccion = pPnlTraduccion;
    }
    
    public void agregarTraduccion(String pIdioma, String pEspaniol, String pTraduccion)
    {
        switch(pIdioma)
        {
            case "Francés":
                    //1. Verificar que la palabra en espanol y su traduccion no exiten en el diccionario.
                    if(!(diccionarioEspaniol_Frances.verificarPalabras(pEspaniol, pTraduccion)))
                    {
                        // == False: No exite la traducción en el diccionario.
                        Traduccion traduccion = new Traduccion(pEspaniol,pTraduccion);
                        diccionarioEspaniol_Frances.agregarTraduccion(traduccion);
                        pnlDiccionarios.setFrances(diccionarioEspaniol_Frances.obtenerTamanio());
                        JOptionPane.showMessageDialog(null, "Palabra agregada al diccionario.", "Agregar palabra", JOptionPane.INFORMATION_MESSAGE);
                        
                    }
                    else
                    {
                        // == True : Existe la traduccion en el diccionario.
                        JOptionPane.showMessageDialog(null, "No es posible agregar esta palabra.", "Agregar palabra", JOptionPane.ERROR_MESSAGE);
                    }
                break;
            case "Inglés":
                //1. Verificar que la palabra en espanol y su traduccion no exiten en el diccionario.
                    if(!(diccionarioEspaniol_Ingles.verificarPalabras(pEspaniol, pTraduccion)))
                    {
                        // == False: No exite la traducción en el diccionario.
                        Traduccion traduccion = new Traduccion(pEspaniol,pTraduccion);
                        diccionarioEspaniol_Ingles.agregarTraduccion(traduccion);
                        pnlDiccionarios.setIngles(diccionarioEspaniol_Ingles.obtenerTamanio());
                        JOptionPane.showMessageDialog(null, "Palabra agregada al diccionario.", "Agregar palabra", JOptionPane.INFORMATION_MESSAGE);
                        
                    }
                    else
                    {
                        // == True : Existe la traduccion en el diccionario.
                        JOptionPane.showMessageDialog(null, "No es posible agregar esta palabra.", "Agregar palabra", JOptionPane.ERROR_MESSAGE);
                    }
                break;
            case "Italiano":
                //1. Verificar que la palabra en espanol y su traduccion no exiten en el diccionario.
                    if(!(diccionarioEspaniol_Italiano.verificarPalabras(pEspaniol, pTraduccion)))
                    {
                        // == False: No exite la traducción en el diccionario.
                        Traduccion traduccion = new Traduccion(pEspaniol,pTraduccion);
                        diccionarioEspaniol_Italiano.agregarTraduccion(traduccion);
                        pnlDiccionarios.setItaliano(diccionarioEspaniol_Italiano.obtenerTamanio());
                        JOptionPane.showMessageDialog(null, "Palabra agregada al diccionario.", "Agregar palabra", JOptionPane.INFORMATION_MESSAGE);
                        
                    }
                    else
                    {
                        // == True : Existe la traduccion en el diccionario.
                        JOptionPane.showMessageDialog(null, "No es posible agregar esta palabra.", "Agregar palabra", JOptionPane.ERROR_MESSAGE);
                    }
                break;
        }
    }
    
    public void consultarTraduccion(String pIdiomaOrigen, String pIdiomaDestino, String palabra)
    {
        /**
         * Español - Ingles
         * Español - Frances
         * Español - Italiano
         * 
         * 1. Origen: Español -> Español - (destino)
         * 2. Origen <> Español -> Español - (origen) -> Español - (destino)
         */
        String traduccion = "";
        if(pIdiomaOrigen.equalsIgnoreCase("Español"))
        {
            switch(pIdiomaDestino)
            {
                case "Francés":
                    traduccion = diccionarioEspaniol_Frances.buscarPalabraEspaniol(palabra);
                    break;
                case "Inglés":
                    traduccion = diccionarioEspaniol_Ingles.buscarPalabraEspaniol(palabra);
                    break;
                case "Italiano":
                    traduccion = diccionarioEspaniol_Italiano.buscarPalabraEspaniol(palabra);
                    break;
            }
        }
        else
        {
            if(pIdiomaDestino.equalsIgnoreCase(("Español")))
            {
                switch(pIdiomaOrigen)
                {
                    case "Francés":
                        traduccion = diccionarioEspaniol_Frances.buscarPalabraDestino(palabra);
                        break;
                    case "Inglés":
                        traduccion = diccionarioEspaniol_Ingles.buscarPalabraDestino(palabra);
                        break;
                    case "Italiano":
                        traduccion = diccionarioEspaniol_Italiano.buscarPalabraDestino(palabra);
                        break;
                }
            }
            else
            {
                String traduccionEspaniol = "";
                switch(pIdiomaOrigen)
                {  
                    case "Francés":
                        traduccionEspaniol = diccionarioEspaniol_Frances.buscarPalabraDestino(palabra);
                        break;
                    case "Inglés":
                        traduccionEspaniol = diccionarioEspaniol_Ingles.buscarPalabraDestino(palabra);
                        break;
                    case "Italiano":
                        traduccionEspaniol = diccionarioEspaniol_Italiano.buscarPalabraDestino(palabra);
                        break;
                }
                
                switch(pIdiomaDestino)
                {
                    case "Francés":
                        traduccion = diccionarioEspaniol_Frances.buscarPalabraEspaniol(traduccionEspaniol);
                        break;
                    case "Inglés":
                        traduccion = diccionarioEspaniol_Ingles.buscarPalabraEspaniol(traduccionEspaniol);
                        break;
                    case "Italiano":
                        traduccion = diccionarioEspaniol_Italiano.buscarPalabraEspaniol(traduccionEspaniol);
                        break;
                }
                
               
            }
           
        }
        
        if(traduccion == null)
        {
            JOptionPane.showMessageDialog(null,"No existe la traducción.", "Traducir palabra", JOptionPane.ERROR_MESSAGE);
        }
        else
        {
            pnlTraduccion.setTraduccion(traduccion);
        }
    }
    
    public void opcionUno()
    {
        String idiomaOrigen = pnlTraduccion.getIdiomaOrigen();
        switch(idiomaOrigen)
        {
            case "Español":
                diccionarioEspaniol_Ingles.ordenarTraducciones();
                diccionarioEspaniol_Frances.ordenarTraducciones();
                diccionarioEspaniol_Italiano.ordenarTraducciones();
                break;
            case "Inglés":
                diccionarioEspaniol_Ingles.ordenarTraducciones();
                break;
            case "Francés":
                diccionarioEspaniol_Frances.ordenarTraducciones();
                break;
            case "Italiano":
                diccionarioEspaniol_Italiano.ordenarTraducciones();
                break;
        }
    }
    
    public ArrayList<Traduccion> opcionDos()
    {
       return diccionarioEspaniol_Ingles.listaTraducciones();
    }
    
    public void opcionTres()
    {
        Traductor traduccionesUno = diccionarioEspaniol_Ingles;
        Traductor traduccionesDos = diccionarioEspaniol_Frances;
        Traductor traduccionesTres = diccionarioEspaniol_Italiano;
        
        Traductor [] diccionarios = {traduccionesUno, traduccionesDos, traduccionesTres};
        
        for(int i = 0; i < diccionarios.length; i ++)
        {
            Traductor traduccionMenor = diccionarios[i];
            Traductor traduccionPivote = traduccionMenor;
            int posicion = i;
            for(int j = i + 1; j < diccionarios.length; j ++)
            {
                Traductor traduccionActual = diccionarios[j];
                if(traduccionActual.obtenerTamanio() < traduccionMenor.obtenerTamanio())
                {
                    traduccionMenor = traduccionActual;
                    posicion = j;
                }
            }
           
            diccionarios[i] = traduccionMenor;
            diccionarios[posicion] = traduccionPivote;
        }
        
        String mensaje = "El orden decreciente es:";
        
        for(int i = 2; i >=0 ; i --)
        {
            mensaje +="\n"+ diccionarios[i].getIdiomaTraduccion() + ": " + diccionarios[i].obtenerTamanio();
        }
        
        JOptionPane.showMessageDialog(pnlTraduccion, mensaje, "Opción 3", JOptionPane.INFORMATION_MESSAGE);
    }
}
