/**
 * 
 */
package Model;

/**
 * Representa una traducción almacenada en un diccionario del Traductor.
 * @author Cristhian Eduardo Castillo Erazo.
 */
public class Traduccion 
{
    // -------------------------------------------------------------------------
    //  Constantes
    // -------------------------------------------------------------------------
    
    // -------------------------------------------------------------------------
    //  Atributos
    // -------------------------------------------------------------------------
    
    private String palabraOrigen;
    
    private String palabraDestino;
    
    // -------------------------------------------------------------------------
    //  Constructores
    // -------------------------------------------------------------------------
    
    public Traduccion(String pPalabraOrigen, String pPalabraDestino)
    {
        this.palabraOrigen = pPalabraOrigen;
        this.palabraDestino = pPalabraDestino;
    }
    
    // -------------------------------------------------------------------------
    //  Metodos
    // -------------------------------------------------------------------------
    
    public String getPalabraOrigen()
    {
        return this.palabraOrigen;
    }
    
    public String getPalabraDestino()
    {
        return this.palabraDestino;
    }
}
