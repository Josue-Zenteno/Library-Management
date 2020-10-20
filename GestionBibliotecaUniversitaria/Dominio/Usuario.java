package Dominio;
import Persistencia.Agente;
import java.util.Vector;
/***********************************************************************************************************************
* Class Name: Usuario
* Authors: Josue Carlos Zenteno Yave
*           Sergio Silvestre Pavon
*           Adrian Ruiz Esteban
*           Maria Jesus Dueñas Recuero
* Date: 12/12/2019
* Class Description: Clase usuario que consta de su constructor, getters y setter y de los siguientes metodos:
*                      -readUsusario
*                      -updateUsuario
***********************************************************************************************************************/
public class Usuario {
    protected String login;
    protected String password;
    protected String Nombre;
    protected int numeroLibrosPrestados;
    /*******************************************************************************************************************
     * Method Name: Usuario
     * Authors: Josue Carlos Zenteno Yave
     *           Sergio Silvestre Pavon
     *           Adrian Ruiz Esteban
     *           Maria Jesus Dueñas Recuero
     * Date: 12/12/2019
     * Description: Metodo constructor de la clase Usuario
     ******************************************************************************************************************/
    public Usuario(String login, String password,String Nombre, int numeroLibrosPrestados) {
        this.login = login;
        this.password = password;
        this.Nombre=Nombre;
        this.numeroLibrosPrestados=numeroLibrosPrestados;
    }
    /*******************************************************************************************************************
     * Method Name: readUsuario
     * Authors: Josue Carlos Zenteno Yave
     *           Sergio Silvestre Pavon
     *           Adrian Ruiz Esteban
     *           Maria Jesus Dueñas Recuero
     * Date: 12/12/2019
     * Description: Metodo que se encarga de leer un Usuario de la base de datos
     ******************************************************************************************************************/
    public static Usuario readUsuario(String sql) throws Exception{

        Usuario auxUser=null;
        Vector<Object> auxVector;
        Vector<Object> vectorQueLlegaDelAgente = Agente.getAgente().select(sql);

        auxVector = new Vector<Object>();

        if (vectorQueLlegaDelAgente.size() >= 1){

            auxVector = (Vector<Object>) vectorQueLlegaDelAgente.elementAt(0);
            auxUser = new Usuario((String) auxVector.elementAt(1), (String) auxVector.elementAt(2), (String) auxVector.elementAt(3),(int)auxVector.elementAt(4));
        }
        return auxUser;
    }
    /*******************************************************************************************************************
     * Method Name: updateUsuario
     * Authors: Josue Carlos Zenteno Yave
     *           Sergio Silvestre Pavon
     *           Adrian Ruiz Esteban
     *           Maria Jesus Dueñas Recuero
     * Date: 12/12/2019
     * Description: Metodo que se encarga de actualizar informacion de un Usuario
     ******************************************************************************************************************/
    public boolean updateUsuario(String sql) throws Exception{
        Agente.getAgente().update(sql);
        return true;
    }
    public String getLogin() {
        return login;
    }
    public void setLogin(String login) {
        this.login = login;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public String getNombre() {
        return Nombre;
    }
    public void setNombre(String nombre) {
        Nombre = nombre;
    }
    public int getNumeroLibrosPrestados() {
        return numeroLibrosPrestados;
    }
    public void setNumeroLibrosPrestados(int numeroLibrosPrestados) {
        this.numeroLibrosPrestados = numeroLibrosPrestados;
    }
    public String toString() {
        return  "\nUsuario: "+Nombre+"\n" +
                "Número de libros prestados: "+numeroLibrosPrestados+"\n";
    }
}
