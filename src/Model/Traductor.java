/**
 * 
 */
package Model;

import java.util.ArrayList;

/**
 *  Representa un diccionario del traductor.
 * @author Cristhian Eduardo Castillo Erazo
 */
public class Traductor 
{
    // -------------------------------------------------------------------------
    //  Constantes
    // -------------------------------------------------------------------------
    
    // -------------------------------------------------------------------------
    //  Atributos
    // -------------------------------------------------------------------------
    
    private ArrayList<Traduccion> diccionario;
    
    private String idiomaTraduccion;
    // -------------------------------------------------------------------------
    //  Constructores
    // -------------------------------------------------------------------------
    
    public Traductor(String pIdiomaTraduccion)
    {
        diccionario = new ArrayList<>();
        this.idiomaTraduccion = pIdiomaTraduccion;
    }
    
    // -------------------------------------------------------------------------
    //  Metodos
    // -------------------------------------------------------------------------
    
    public void agregarTraduccion(Traduccion traduccion)
    {
        diccionario.add(traduccion);
    }
    
    /**
     * Verifica que no exista la palabra en Español y su traducción en el
     * diccionario.
     * @param pEspaniol
     * @param pTraduccion
     * @return true: si exite alguna, false: si no exiten.
     */
    public boolean verificarPalabras(String pEspaniol, String pTraduccion)
    {
        for(int i = 0; i < diccionario.size(); i ++)
        {
            Traduccion palabra = diccionario.get(i);
            String palabraEspaniol = palabra.getPalabraOrigen();
            String palabraTraduccion = palabra.getPalabraDestino();
            
            if(palabraEspaniol.equalsIgnoreCase(pEspaniol) || palabraTraduccion.equalsIgnoreCase(pTraduccion))
            {
                return true;
            }  
        }
        return false;
    }
    
    public String buscarPalabraEspaniol(String pPalabra)
    {
        for(int i = 0; i < diccionario.size(); i ++)
        {
            Traduccion palabra = diccionario.get(i);
            String palabraEspaniol = palabra.getPalabraOrigen();
            String palabraTraduccion = palabra.getPalabraDestino();
            
            if(palabraEspaniol.equalsIgnoreCase(pPalabra))
            {
                return palabraTraduccion;
            }  
        }
        return null;
    }
    
    public String buscarPalabraDestino(String pPalabra)
    {
        for(int i = 0; i < diccionario.size(); i ++)
        {
            Traduccion palabra = diccionario.get(i);
            String palabraEspaniol = palabra.getPalabraOrigen();
            String palabraTraduccion = palabra.getPalabraDestino();
            
            if(palabraTraduccion.equalsIgnoreCase(pPalabra))
            {
                return palabraEspaniol;
            }  
        }
        return null;
    }
    
    public int obtenerTamanio()
    {
        return diccionario.size();
    }
    
    public void ordenarTraducciones()
    {
        for(int i = 0; i < diccionario.size(); i ++)
        {
            Traduccion traduccionMenor = diccionario.get(i);
            Traduccion traduccionPivote = traduccionMenor;
            int posicion = i;
            for(int j = i + 1; j < diccionario.size(); j ++)
            {
                Traduccion traduccionActual = diccionario.get(j);
                if(traduccionActual.getPalabraDestino().length() < traduccionMenor.getPalabraDestino().length())
                {
                    traduccionMenor = traduccionActual;
                    posicion = j;
                }
            }
           
            diccionario.set(i, traduccionMenor);
            diccionario.set(posicion, traduccionPivote);
        }
    }
    
    public ArrayList<Traduccion> listaTraducciones()
    {
        return diccionario;
    }
    
    public String getIdiomaTraduccion()
    {
        return this.idiomaTraduccion;
    }
}
