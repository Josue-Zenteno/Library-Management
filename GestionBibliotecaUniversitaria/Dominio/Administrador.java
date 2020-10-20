package Dominio;
/***********************************************************************************************************************
 * Class Name: Administrador
 * Authors: Josue Carlos Zenteno Yave
 *           Sergio Silvestre Pavon
 *           Adrian Ruiz Esteban
 *           Maria Jesus Dueñas Recuero
 * Date: 12/12/2019
 * Class Description: Clase Administrador que consta de su constructor y su correspondiente getter y setter.
 **********************************************************************************************************************/
public class Administrador extends Usuario{
	private int codigoAdmin;
	/*******************************************************************************************************************
	 * Method Name: Usuario
	 * Authors: Josue Carlos Zenteno Yave
	 *           Sergio Silvestre Pavon
	 *           Adrian Ruiz Esteban
	 *           Maria Jesus Dueñas Recuero
	 * Date: 12/12/2019
	 * Description:	Constructor de la clase
	 ******************************************************************************************************************/
	public Administrador(String login, String password, String Nombre, int numeroLibrosPrestados, int codigoAdmin) {
		super(login, password, Nombre, numeroLibrosPrestados);
		this.codigoAdmin = codigoAdmin;
	}
	public int getCodigoAdmin() {
		return codigoAdmin;
	}
	public void setCodigoAdmin(int codigoAdmin) {
		this.codigoAdmin = codigoAdmin;
	}
}