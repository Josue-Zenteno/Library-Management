package Dominio;
import java.util.StringTokenizer;
/***********************************************************************************************************************
 * Class Name: GestorUsuario
 * Authors: Josue Carlos Zenteno Yave
 *           Sergio Silvestre Pavon
 *           Adrian Ruiz Esteban
 *           Maria Jesus Dueñas Recuero
 * Date: 12/12/2019
 * Class Description: Clase Gestor Usuario que consta del metodo autenticarUsuario
 **********************************************************************************************************************/
public class GestorUsuario{
    /*******************************************************************************************************************
     * Method Name: autenticarUsuario
     * Authors: Josue Carlos Zenteno Yave
     *           Sergio Silvestre Pavon
     *           Adrian Ruiz Esteban
     *           Maria Jesus Dueñas Recuero
     * Date: 12/12/2019
     * Class Description: Metodo que se encarga de autenticar a un usuario
     ******************************************************************************************************************/
    public Usuario autenticarUsuario(String login, String password) {

        Usuario AUXuser=null;
        try {
            AUXuser=Usuario.readUsuario("SELECT * FROM PruebaBBDD.Usuarios WHERE login= '" + login + "'  AND password = '" + password + "';");

        }catch(Exception e){
            System.out.println(e.getMessage());
        }
        return AUXuser;
    }
}
