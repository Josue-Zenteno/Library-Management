package Dominio;
import java.util.*;
import Persistencia.*;
/***********************************************************************************************************************
 * Class Name: Ejemplar que extiende a Libro
 * Authors: Josue Carlos Zenteno Yave
 *           Sergio Silvestre Pavon
 *           Adrian Ruiz Esteban
 *           Maria Jesus Dueñas Recuero
 * Date: 12/12/2019
 * Class Description: Clase Ejemplar que consta de los metodos:
 *                      -readEjemplar
 *                      -createEjemplar
 *                      -updateEjemplar
 *                      -deleteEjemplar
 *                      ademas de su constructor, getters y setters.
 **********************************************************************************************************************/
public class Ejemplar extends Libro{
    private int codigoIdentificativo;
    /*******************************************************************************************************************
     * Method Name: Ejemplar
     * Authors: Josue Carlos Zenteno Yave
     *           Sergio Silvestre Pavon
     *           Adrian Ruiz Esteban
     *           Maria Jesus Dueñas Recuero
     * Date: 12/12/2019
     * Description: Metodo constructor de la clase
     ******************************************************************************************************************/
    public Ejemplar(String descripcion, String titulo, int ISBN, String genero, String estado, double PVP, /*Date fecha, String propietario, int codigoAdmin,*/ String autor, int codigoIdentificativo) {
        super(descripcion, titulo, ISBN, genero, estado, PVP, /*fecha, propietario, codigoAdmin,*/ autor);
        this.codigoIdentificativo = codigoIdentificativo;
    }
    /*******************************************************************************************************************
     * Method Name: readEjemplar
     * Authors: Josue Carlos Zenteno Yave
     *           Sergio Silvestre Pavon
     *           Adrian Ruiz Esteban
     *           Maria Jesus Dueñas Recuero
     * Date: 12/12/2019
     * Description: Metodo encargado de leer un ejemplar de la base de datos
     ******************************************************************************************************************/
    public static Ejemplar readEjemplar(String sql) throws Exception{
        Ejemplar AuxEj = null;
        Vector<Object> auxVector;
        Vector<Object> vectorQueLlegaDelAgente = Agente.getAgente().select(sql);


        auxVector = new Vector<Object>();

        if (vectorQueLlegaDelAgente.size() >= 1){

            auxVector = (Vector<Object>) vectorQueLlegaDelAgente.elementAt(0);

            AuxEj = new Ejemplar((String) auxVector.elementAt(1), (String) auxVector.elementAt(2), (int) auxVector.elementAt(3), (String) auxVector.elementAt(4),(String) auxVector.elementAt(5),(double) auxVector.elementAt(6),/*(Date) auxVector.elementAt(7),(String) auxVector.elementAt(8),(int) auxVector.elementAt(9),*/(String) auxVector.elementAt(10),(int) auxVector.elementAt(11));
        }
        return AuxEj;
    }
    /*******************************************************************************************************************
     * Method Name: updateEjemplar
     * Authors: Josue Carlos Zenteno Yave
     *           Sergio Silvestre Pavon
     *           Adrian Ruiz Esteban
     *           Maria Jesus Dueñas Recuero
     * Date: 12/12/2019
     * Description: Metodo encargado de actualizar la informacion de un ejemplar
     ******************************************************************************************************************/
    public static boolean updateEjemplar(String sql) throws Exception{
        Agente.getAgente().update(sql);
        return true;
    }
    /*******************************************************************************************************************
     * Method Name: createEjemplar
     * Authors: Josue Carlos Zenteno Yave
     *           Sergio Silvestre Pavon
     *           Adrian Ruiz Esteban
     *           Maria Jesus Dueñas Recuero
     * Date: 12/12/2019
     * Description: Metodo encargado de crear un nuevo Ejemplar
     ******************************************************************************************************************/
    public static boolean createEjemplar(String sql) throws Exception {
        Agente.getAgente().create(sql);
        return true;
    }
    /*******************************************************************************************************************
     * Method Name: deleteEjemplar
     * Authors: Josue Carlos Zenteno Yave
     *           Sergio Silvestre Pavon
     *           Adrian Ruiz Esteban
     *           Maria Jesus Dueñas Recuero
     * Date: 12/12/2019
     * Description: Metodo no requerido
     ******************************************************************************************************************/
    public boolean deleteEjemplar(String sql) {
        // TODO - implement Ejemplar.deleteEjemplar
        throw new UnsupportedOperationException();
    }
    public int getCodigoIdentificativo() {
        return codigoIdentificativo;
    }
    public void setCodigoIdentificativo(int codigoIdentificativo) {
        this.codigoIdentificativo = codigoIdentificativo;
    }
    public String toString() {
        return  titulo+"\n" +
                Autor+"\n" +
                genero+"\n" +
                descripcion+"\n" +
                PVP+"\n" +
                estado+"\n" +
                codigoIdentificativo+"\n";
    }
}
