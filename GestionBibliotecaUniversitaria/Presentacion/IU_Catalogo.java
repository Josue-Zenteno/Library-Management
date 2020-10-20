package Presentacion;
import java.util.*;
import Dominio.*;
/***********************************************************************************************************************
 * Class Name: IU_Catalogo
 * Authors: Josue Carlos Zenteno Yave
 *           Sergio Silvestre Pavon
 *           Adrian Ruiz Esteban
 *           Maria Jesus Dueñas Recuero
 * Date: 12/12/2019
 *Description: IU_Catalogo que consta del metodo iniciarIU_Catalogo
 **********************************************************************************************************************/
public class IU_Catalogo {
    /*******************************************************************************************************************
     * Method name: iniciarIU_Catalogo
     * Authors: Josue Carlos Zenteno Yave
     *           Sergio Silvestre Pavon
     *           Adrian Ruiz Esteban
     *           Maria Jesus Dueñas Recuero
     * Date: 12/12/2019
     *Description: Metodo encargado de mostrar la interfaz del catalogo
     ******************************************************************************************************************/
    public void iniciarIU_Catalogo(){
        Scanner sc = new Scanner(System.in);
        //Creamos un Gestor Catalogo
        GestorCatalogo GC = new GestorCatalogo();
        //Imprimimos un menu para poder elegir el tipo de filtros
        System.out.println("Elige un filtro para los libros:\n"+
                            "\t1) Sin filtros\n" +
                            "\t2) Por Autor\n" +
                            "\t3) Por ISBN\n" +
                            "\t4) Por Genero\n" +
                            "\t5) Por Titulo\n");
        //Le pasamos al metodo mostrarCatalogo() la opcion pillada del teclado
        try {
            System.out.println(GC.mostrarCatalogo(sc.nextInt()));
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }
}
