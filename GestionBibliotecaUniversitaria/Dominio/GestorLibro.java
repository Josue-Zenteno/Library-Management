package Dominio;
import java.util.Random;
import java.util.StringTokenizer;
/***********************************************************************************************************************
 * Class Name: GestorLibro
 * Authors: Josue Carlos Zenteno Yave
 *           Sergio Silvestre Pavon
 *           Adrian Ruiz Esteban
 *           Maria Jesus Dueñas Recuero
 * Date: 12/12/2019
 * Class Description:   Clase GestoLibro que consta de los metodos:
 *
 *                          -reservarLibro
 *                          -prestarLibro
 *                          -ampliarPlazo
 *                          -devolucionLibro
 *                          -solicitudAdicionDeLibro
 *                          -mostrarPrestado
 *                          -mostrarComprado
 *                          -mostrarTotalPrestado
 *                          -mostrarTotalComprado
 *                          -mostrarTotalDisponible
 *                          -mostrarSolicitudes
 *                          -aceptarSolicitud
 *                          -rechazarSolicitud
 **********************************************************************************************************************/
public class GestorLibro {
    /*******************************************************************************************************************
     * Method Name: prestarLibro
     * Authors: Josue Carlos Zenteno Yave
     *           Sergio Silvestre Pavon
     *           Adrian Ruiz Esteban
     *           Maria Jesus Dueñas Recuero
     * Date: 12/12/2019
     * Description: Metodo encargado de prestar un libro
     ******************************************************************************************************************/
    public int prestarLibro(Usuario u, int ISBN) throws Exception{

        int maxLibros=0;
        int numError=0;
        StringTokenizer tokenizer = new StringTokenizer(u.getLogin(), "@");
        tokenizer.nextToken();
        String identificador_rol = tokenizer.nextToken();

        if(identificador_rol.equals("alu.es")){
            maxLibros=Alumno.getNumero_maxAL();
        }else if(identificador_rol.equals("prof.es")){
            maxLibros=Profesor.getNumero_maxPROF();
        }

        if(u.getNumeroLibrosPrestados() == maxLibros){

            System.out.println("Has alcanzado el número máximo de libros prestados");

        }else{

            Ejemplar AuxEj  = Ejemplar.readEjemplar("SELECT * FROM PruebaBBDD.Libros WHERE ISBN= '" + ISBN + "'AND (Estado = 'Disponible' OR Estado = 'Prestado');");

            if(AuxEj!= null){

                if(AuxEj.getEstado().equals("Prestado")){

                    numError=1;

                }else{

                    Ejemplar.updateEjemplar("UPDATE PruebaBBDD.Libros SET Estado = 'Prestado' WHERE ISBN = "+AuxEj.getISBN()+";");
                    u.updateUsuario("UPDATE PruebaBBDD.Usuarios SET numeroLibrosPrestados = '"+(u.getNumeroLibrosPrestados()+1)+"' WHERE login = '"+u.getLogin()+"';");
                }
            }else{
                 numError = 2;
            }
        }
        return numError;
    }
    /*******************************************************************************************************************
     * Method Name: reservarLibro
     * Authors: Josue Carlos Zenteno Yave
     *           Sergio Silvestre Pavon
     *           Adrian Ruiz Esteban
     *           Maria Jesus Dueñas Recuero
     * Date: 12/12/2019
     * Description: Metodo encargado de reservar un libro
     ******************************************************************************************************************/
    public boolean reservarLibro(Usuario u, int ISBN) throws Exception {
        boolean reservado=false;

        if(Ejemplar.updateEjemplar("UPDATE PruebaBBDD.Libros SET Estado = 'Reservado' WHERE ISBN = "+ISBN+";")){
            reservado = true;
        }
        return reservado;
    }
    /*******************************************************************************************************************
     * Method Name: SolicitudAdicionDeLibro
     * Authors: Josue Carlos Zenteno Yave
     *           Sergio Silvestre Pavon
     *           Adrian Ruiz Esteban
     *           Maria Jesus Dueñas Recuero
     * Date: 12/12/2019
     * Description: Metodo encargado de solicitar la adicion de un libro
     ******************************************************************************************************************/
    public boolean SolicitudAdicionDeLibro(Usuario u, int ISBN, int codigoIdentificativo) throws Exception {
        Random r = new Random();
        boolean bool=false;

        if(Ejemplar.readEjemplar("SELECT * FROM PruebaBBDD.Libros WHERE ISBN= '" + ISBN + "'AND codigoIdentificativo = "+codigoIdentificativo+";") == null){
            Ejemplar.createEjemplar("insert into PruebaBBDD.Solicitudes values ('"+r.nextInt(100000000)+"','"+ISBN+"','"+codigoIdentificativo+"','"+u.getNombre()+"');");
        }else{
            bool=true;
        }

        return bool;
    }
    /*******************************************************************************************************************
     * Method Name: ampliarPlazo
     * Authors: Josue Carlos Zenteno Yave
     *           Sergio Silvestre Pavon
     *           Adrian Ruiz Esteban
     *           Maria Jesus Dueñas Recuero
     * Date: 12/12/2019
     * Description: Metodo No requerido
     ******************************************************************************************************************/
    public boolean ampliarPlazo(Usuario u, int ISBN, int codigoIdentificativo) {
        // TODO - implement GestorLibro.ampliarPlazo
        throw new UnsupportedOperationException();
    }
    /*******************************************************************************************************************
     * Method Name: devolucionLibro
     * Authors: Josue Carlos Zenteno Yave
     *           Sergio Silvestre Pavon
     *           Adrian Ruiz Esteban
     *           Maria Jesus Dueñas Recuero
     * Date: 12/12/2019
     * Description: Metodo No requerido
     ******************************************************************************************************************/
    public boolean devolucionLibro(Usuario u, int ISBN, int codigoIdentificativo) {
        // TODO - implement GestorLibro.devolucionLibro
        throw new UnsupportedOperationException();
    }
    /*******************************************************************************************************************
     * Method Name: mostrarPrestados
     * Authors: Josue Carlos Zenteno Yave
     *           Sergio Silvestre Pavon
     *           Adrian Ruiz Esteban
     *           Maria Jesus Dueñas Recuero
     * Date: 12/12/2019
     * Description: Metodo No requerido
     ******************************************************************************************************************/
    public String mostrarPrestados(Usuario u) {
        // TODO - implement GestorLibro.mostrarPrestados
        throw new UnsupportedOperationException();
    }
    /*******************************************************************************************************************
     * Method Name: mostrarComprados
     * Authors: Josue Carlos Zenteno Yave
     *           Sergio Silvestre Pavon
     *           Adrian Ruiz Esteban
     *           Maria Jesus Dueñas Recuero
     * Date: 12/12/2019
     * Description: Metodo No requerido
     ******************************************************************************************************************/
    public String mostrarComprados(Usuario u) {
        // TODO - implement GestorLibro.mostrarComprados
        throw new UnsupportedOperationException();
    }
    /*******************************************************************************************************************
     * Method Name: mostrarTotalPrestados
     * Authors: Josue Carlos Zenteno Yave
     *           Sergio Silvestre Pavon
     *           Adrian Ruiz Esteban
     *           Maria Jesus Dueñas Recuero
     * Date: 12/12/2019
     * Description: Metodo No requerido
     ******************************************************************************************************************/
    public int mostrarTotalPrestados() {
        // TODO - implement GestorLibro.mostrarTotalPrestados
        throw new UnsupportedOperationException();
    }
    /*******************************************************************************************************************
     * Method Name: mostrarTotalComprados
     * Authors: Josue Carlos Zenteno Yave
     *           Sergio Silvestre Pavon
     *           Adrian Ruiz Esteban
     *           Maria Jesus Dueñas Recuero
     * Date: 12/12/2019
     * Description: Metodo No requerido
     ******************************************************************************************************************/
    public int mostrarTotalComprados() {
        // TODO - implement GestorLibro.mostrarTotalComprados
        throw new UnsupportedOperationException();
    }
    /*******************************************************************************************************************
     * Method Name: mostrarTotalDisponibles
     * Authors: Josue Carlos Zenteno Yave
     *           Sergio Silvestre Pavon
     *           Adrian Ruiz Esteban
     *           Maria Jesus Dueñas Recuero
     * Date: 12/12/2019
     * Description: Metodo No requerido
     ******************************************************************************************************************/
    public int mostrarTotalDisponibles() {
        // TODO - implement GestorLibro.mostrarTotalDisponibles
        throw new UnsupportedOperationException();
    }
    /*******************************************************************************************************************
     * Method Name: mostrarSolicitudes
     * Authors: Josue Carlos Zenteno Yave
     *           Sergio Silvestre Pavon
     *           Adrian Ruiz Esteban
     *           Maria Jesus Dueñas Recuero
     * Date: 12/12/2019
     * Description: Metodo No requerido
     ******************************************************************************************************************/
    public String mostrarSolicitudes() {
        // TODO - implement GestorLibro.mostrarSolicitudes
        throw new UnsupportedOperationException();
    }
    /*******************************************************************************************************************
     * Method Name: AceptarSolicitud
     * Authors: Josue Carlos Zenteno Yave
     *           Sergio Silvestre Pavon
     *           Adrian Ruiz Esteban
     *           Maria Jesus Dueñas Recuero
     * Date: 12/12/2019
     * Description: Metodo No requerido
     ******************************************************************************************************************/
    public boolean AceptarSolicitud(Ejemplar e) {
        // TODO - implement GestorLibro.AceptarSolicitud
        throw new UnsupportedOperationException();
    }
    /*******************************************************************************************************************
     * Method Name: RechazarSolicitud
     * Authors: Josue Carlos Zenteno Yave
     *           Sergio Silvestre Pavon
     *           Adrian Ruiz Esteban
     *           Maria Jesus Dueñas Recuero
     * Date: 12/12/2019
     * Description: Metodo No requerido
     ******************************************************************************************************************/
    public boolean RechazarSolicitud(int ISBN, int codigoIdentificativo) {
        // TODO - implement GestorLibro.RechazarSolicitud
        throw new UnsupportedOperationException();
    }
}
