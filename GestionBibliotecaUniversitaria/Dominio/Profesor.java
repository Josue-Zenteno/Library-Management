package Dominio;
/***********************************************************************************************************************
 * Class Name: Profesor
 * Authors: Josue Carlos Zenteno Yave
 *           Sergio Silvestre Pavon
 *           Adrian Ruiz Esteban
 *           Maria Jesus Dueñas Recuero
 * Date: 12/12/2019
 * Class Description: Clase profesor que extiende a Usuario
 **********************************************************************************************************************/
public class Profesor extends Usuario {
    private static final int numero_maxPROF = 6;
    /*******************************************************************************************************************
     * Method Name: Profesor
     * Authors: Josue Carlos Zenteno Yave
     *           Sergio Silvestre Pavon
     *           Adrian Ruiz Esteban
     *           Maria Jesus Dueñas Recuero
     * Date: 12/12/2019
     * Description: Metodo constructor de la clase Profesor
     ******************************************************************************************************************/
    public Profesor(String login, String password, String Nombre, int numeroLibrosPrestados) {
        super(login, password, Nombre, numeroLibrosPrestados);
    }
    public static int getNumero_maxPROF() {
        return numero_maxPROF;
    }

}
