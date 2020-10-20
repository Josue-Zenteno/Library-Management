package Dominio;
/***********************************************************************************************************************
 * Class Name: Alumno que extiende a Usuario
 * Authors: Josue Carlos Zenteno Yave
 *           Sergio Silvestre Pavon
 *           Adrian Ruiz Esteban
 *           Maria Jesus Dueñas Recuero
 * Date: 12/12/2019
 * Class Description: Clase Alumno que consta de su constructor y su correspondiente getter y setter
 **********************************************************************************************************************/
public class Alumno extends Usuario{
    private static final int numero_maxAL = 3;
    private int Dinero;
    /*******************************************************************************************************************
     * Method Name: Alumno
     * Authors: Josue Carlos Zenteno Yave
     *           Sergio Silvestre Pavon
     *           Adrian Ruiz Esteban
     *           Maria Jesus Dueñas Recuero
     * Date: 12/12/2019
     * Description: Constructor de la clase
     ******************************************************************************************************************/
    public Alumno(String login, String password, String Nombre, int numeroLibrosPrestados) {
        super(login, password, Nombre, numeroLibrosPrestados);
    }
    public static int getNumero_maxAL() {
        return numero_maxAL;
    }
    public int getDinero() {
        return Dinero;
    }
    public void setDinero(int dinero) {
        this.Dinero = dinero;
    }
}
