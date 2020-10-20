package Persistencia;
import java.sql.*;
import java.util.Vector;
/***********************************************************************************************************************
 * Class Name: Agente
 * Authors: Josue Carlos Zenteno Yave
 *           Sergio Silvestre Pavon
 *           Adrian Ruiz Esteban
 *           Maria Jesus Dueñas Recuero
 * Date: 12/12/2019
 * Class Description: Clase Agente que cuenta con los metodos:
 *                      -select
 *                      -create
 *                      -update
 *                      -delete
 *                      Ademas de su constructor
 **********************************************************************************************************************/
public class Agente {
    static String dbURL = "jdbc:mysql://localhost:3306/PruebaBBDD"; //Esta string es el path de nuestra bbdd
    static String username = "root"; //El usuario que por defecto es root
    static String password = "3459443"; //Contraseña que le puse para poder acceder
    protected static Agente mInstancia=null;
    protected static Connection mBD;
    /*******************************************************************************************************************
     * Method Name: Agente
     * Authors: Josue Carlos Zenteno Yave
     *           Sergio Silvestre Pavon
     *           Adrian Ruiz Esteban
     *           Maria Jesus Dueñas Recuero
     * Date: 12/12/2019
     * Description: Constructor de la clase Agente
     ******************************************************************************************************************/
    public Agente() throws Exception {
        Class.forName("com.mysql.cj.jdbc.Driver");
        mBD=DriverManager.getConnection(dbURL, username, password);
    }
    /*******************************************************************************************************************
     * Method Name: getAgente
     * Authors: Josue Carlos Zenteno Yave
     *           Sergio Silvestre Pavon
     *           Adrian Ruiz Esteban
     *           Maria Jesus Dueñas Recuero
     * Date: 12/12/2019
     * Description: Metodo que autoinstacia al Agente
     ******************************************************************************************************************/
    public static Agente getAgente() throws Exception {
        if (mInstancia==null) {
            mInstancia=new Agente();
        }
        return mInstancia;
    }
    /*******************************************************************************************************************
     * Method Name: select
     * Authors: Josue Carlos Zenteno Yave
     *           Sergio Silvestre Pavon
     *           Adrian Ruiz Esteban
     *           Maria Jesus Dueñas Recuero
     * Date: 12/12/2019
     * Description: Metodo que lee de la base de datos
     ******************************************************************************************************************/
    public Vector<Object> select(String SQL) throws SQLException, Exception{
        Vector<Object> aux = null;
        Statement stmt = mBD.createStatement();
        ResultSet res=stmt.executeQuery(SQL);
        Vector<Object> vectoradevolver=new Vector<Object>();
        while (res.next()) {
            aux=new Vector<Object>();
            for(int i=1;i<=res.getMetaData().getColumnCount();i++){
                aux.add(res.getObject(i));
                vectoradevolver.add(aux);
            }
        }
        stmt.close();
        return vectoradevolver;
    }
    /*******************************************************************************************************************
     * Method Name: create
     * Authors: Josue Carlos Zenteno Yave
     *           Sergio Silvestre Pavon
     *           Adrian Ruiz Esteban
     *           Maria Jesus Dueñas Recuero
     * Date: 12/12/2019
     * Description: Metodo que crea elementos en la base de datos
     ******************************************************************************************************************/
    public static int create(String sql) throws Exception{
        PreparedStatement stmt = mBD.prepareStatement(sql);
        int res=stmt.executeUpdate();
        stmt.close();
        return res;
    }
    /*******************************************************************************************************************
     * Method Name: update
     * Authors: Josue Carlos Zenteno Yave
     *           Sergio Silvestre Pavon
     *           Adrian Ruiz Esteban
     *           Maria Jesus Dueñas Recuero
     * Date: 12/12/2019
     * Description: Metodo que actualiza elementos en la base de datos
     ******************************************************************************************************************/
    public int update(String sql)throws Exception{
        PreparedStatement stmt = mBD.prepareStatement(sql);
        int res=stmt.executeUpdate();
        stmt.close();
        return res;
    }
    /*******************************************************************************************************************
     * Method Name: delete
     * Authors: Josue Carlos Zenteno Yave
     *           Sergio Silvestre Pavon
     *           Adrian Ruiz Esteban
     *           Maria Jesus Dueñas Recuero
     * Date: 12/12/2019
     * Description: Metodo no requerido
     ******************************************************************************************************************/
    public static int delete(String sql) throws Exception{
        PreparedStatement stmt = mBD.prepareStatement(sql);
        int res=stmt.executeUpdate();
        stmt.close();
        return res;
    }
}



