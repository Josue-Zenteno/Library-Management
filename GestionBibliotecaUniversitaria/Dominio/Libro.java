package Dominio;
import java.util.*;
import Persistencia.*;
/***********************************************************************************************************************
 * Class Name: Libro
 * Authors: Josue Carlos Zenteno Yave
 *           Sergio Silvestre Pavon
 *           Adrian Ruiz Esteban
 *           Maria Jesus Dueñas Recuero
 * Date: 12/12/2019
 * Class Description: Clase Libro que consta del metodo readLibro
 **********************************************************************************************************************/
public class Libro {
    protected String descripcion;
    protected String titulo;
    protected int ISBN;
    protected String genero;
    protected String estado;
    protected double PVP;
    /*protected Date fecha;
    protected String propietario;
    protected int codigoAdmin;*/
    protected String Autor;
    /*******************************************************************************************************************
     * Method Name: Libro
     * Authors: Josue Carlos Zenteno Yave
     *           Sergio Silvestre Pavon
     *           Adrian Ruiz Esteban
     *           Maria Jesus Dueñas Recuero
     * Date: 12/12/2019
     * Description: Metodo constructor de libro
     ******************************************************************************************************************/
    public Libro(String descripcion, String titulo, int ISBN, String genero, String estado, double PVP, /*Date fecha, String propietario, int codigoAdmin,*/ String autor) {
        this.descripcion = descripcion;
        this.titulo = titulo;
        this.ISBN = ISBN;
        this.genero = genero;
        this.estado = estado;
        this.PVP = PVP;
        /*this.fecha = fecha;
        this.propietario = propietario;
        this.codigoAdmin = codigoAdmin;*/
        this.Autor = autor;
    }
    /*******************************************************************************************************************
     * Method Name: readLibro
     * Authors: Josue Carlos Zenteno Yave
     *           Sergio Silvestre Pavon
     *           Adrian Ruiz Esteban
     *           Maria Jesus Dueñas Recuero
     * Date: 12/12/2019
     * Description: Metodo que se encarga de leer un libro de la base de datos
     ******************************************************************************************************************/
    public static Libro[] readLibro(String sql) throws Exception{

        Vector<Object> auxVector= new Vector<Object>();
        Vector<Object> vectorQueLlegaDelAgente = Agente.getAgente().select(sql);
        Libro [] auxMatrix= new Libro[vectorQueLlegaDelAgente.size()/12];

        int j=0;

        if (vectorQueLlegaDelAgente.size() >= 1){
            for(int i=0;i<vectorQueLlegaDelAgente.size();i+=12) {
                auxVector = (Vector<Object>) vectorQueLlegaDelAgente.elementAt(i);
                auxMatrix[j] = new Libro((String) auxVector.elementAt(1), (String) auxVector.elementAt(2), (int) auxVector.elementAt(3), (String) auxVector.elementAt(4),(String) auxVector.elementAt(5),(double) auxVector.elementAt(6),/*(Date) auxVector.elementAt(7),(String) auxVector.elementAt(8),(int) auxVector.elementAt(9),*/(String) auxVector.elementAt(10));
                j++;
            }
        }
        return auxMatrix;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public int getISBN() {
        return ISBN;
    }

    public void setISBN(int ISBN) {
        this.ISBN = ISBN;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public double getPVP() {
        return PVP;
    }

    public void setPVP(double PVP) {
        this.PVP = PVP;
    }

    /*public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public String getPropietario() {
        return propietario;
    }

    public void setPropietario(String propietario) {
        this.propietario = propietario;
    }

    public int getCodigoAdmin() {
        return codigoAdmin;
    }

    public void setCodigoAdmin(int codigoAdmin) {
        this.codigoAdmin = codigoAdmin;
    }*/

    public String getAutor() {
        return Autor;
    }

    public void setAutor(String autor) {
        this.Autor = autor;
    }

    public String toString() {
        return  titulo+"\n" +
                "----------------------------\n" +
                "Autor: "+Autor+"\n" +
                "Genero: "+genero+"\n" +
                "Descripcion: \n\t"+descripcion+"\n" +
                "Precio: "+PVP+"€\n" +
                estado+"\n";
    }
}
