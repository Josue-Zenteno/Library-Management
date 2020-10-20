package Presentacion;
import java.util.*;
import Dominio.*;
/***********************************************************************************************************************
 * Class Name: IU_Principal
 * Authors: Josue Carlos Zenteno Yave
 *           Sergio Silvestre Pavon
 *           Adrian Ruiz Esteban
 *           Maria Jesus Dueñas Recuero
 * Date: 12/12/2019
 *Description: Clase Principal que consta de los metodos:
 *                                                              -main
 *                                                              -printMenu
 **********************************************************************************************************************/
public class IU_Principal {
    /*******************************************************************************************************************
     * Method name: main
     * Authors: Josue Carlos Zenteno Yave
     *           Sergio Silvestre Pavon
     *           Adrian Ruiz Esteban
     *           Maria Jesus Dueñas Recuero
     * Date: 12/12/2019
     *Description: Metodo encargado de poner en funcionamiento al sistema
     ******************************************************************************************************************/
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        do {
            //Imprimimos el Menu
            printMenu();
            //Vemos si su opcion en Autenticarse o Solo Ver el Catalogo
            if (sc.nextInt() == 1) {
                //Pedimos Login y Password
                System.out.print("Introduce tu Login: ");
                sc.nextLine();
                String login = sc.nextLine();
                System.out.print("Introduce tu Password: ");
                String password = sc.nextLine();
                //Creamos el Tokenizer para identificar si trabajaremos con un Alumno o un Profesor
                StringTokenizer tokenizer = new StringTokenizer(login, "@");
                tokenizer.nextToken();
                String identificador_rol = tokenizer.nextToken();
                //Creamos el Gestor Usuario
                GestorUsuario GU = new GestorUsuario();
                //Condicional para mostrar las opciones segun si es alumno o profesor
                if (identificador_rol.equals("alu.es")) {
                    Usuario AUXAL = GU.autenticarUsuario(login, password);
                    if (AUXAL != null) {
                        //Iniciamos la Interfaz de IU_Alumno
                        IU_Alumno IUAL = new IU_Alumno(AUXAL);
                        IUAL.iniciarIU_Alumno();
                    } else {
                        System.out.println("No existe el usuario introducido");
                    }
                } else if (identificador_rol.equals("prof.es")) {
                    Usuario AUXPROF = GU.autenticarUsuario(login, password);
                    if (AUXPROF != null) {
                        //Inciamos la interfaz de IU_Profesor
                        IU_Profesor IUPROF = new IU_Profesor(AUXPROF);
                        IUPROF.iniciarIU_Profesor();
                    } else {
                        System.out.println("No existe el usuario introducido");
                    }
                }
            } else {
                //Creamos un Catalogo para poder llamar a sus metodos
                IU_Catalogo catalogo = new IU_Catalogo();
                catalogo.iniciarIU_Catalogo();
            }
        }while(true);
    }
    /*******************************************************************************************************************
     * Method name: printMenu
     * Authors: Josue Carlos Zenteno Yave
     *           Sergio Silvestre Pavon
     *           Adrian Ruiz Esteban
     *           Maria Jesus Dueñas Recuero
     * Date: 12/12/2019
     * Description: Metodo encargado de imprimir el menu principal
     ******************************************************************************************************************/
    public static void printMenu(){
        System.out.println("&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&\n" +
                "BIENVENIDO AL BORROWBOOK\n" +
                "&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&\n"+
                "Elige una operación:\n\t1) Autenticar\n\t2) Mostrar Catálogo\n"+
                "&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&");
    }
}
