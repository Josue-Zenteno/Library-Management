package Presentacion;
import java.util.*;
import java.sql.*;
import Persistencia.*;
import Dominio.*;
/***********************************************************************************************************************
 * Class Name: IU_Profesor
 * Authors: Josue Carlos Zenteno Yave
 *           Sergio Silvestre Pavon
 *           Adrian Ruiz Esteban
 *           Maria Jesus Dueñas Recuero
 * Date: 12/12/2019
 *Description: Clase IU_Profesor que consta de su constructor y del metodo iniciarIU_Profesor
 **********************************************************************************************************************/
public class IU_Profesor {
    private Usuario u;
    /*******************************************************************************************************************
     * Method name: IU_Profesor
     * Authors: Josue Carlos Zenteno Yave
     *           Sergio Silvestre Pavon
     *           Adrian Ruiz Esteban
     *           Maria Jesus Dueñas Recuero
     * Date: 12/12/2019
     *Description: Metodo constructor de la clase
     ******************************************************************************************************************/
    public IU_Profesor(Usuario u) {
        this.u = u;
    }
    /*******************************************************************************************************************
     * Method name: iniciarIU_Profesor
     * Authors: Josue Carlos Zenteno Yave
     *           Sergio Silvestre Pavon
     *           Adrian Ruiz Esteban
     *           Maria Jesus Dueñas Recuero
     * Date: 12/12/2019
     *Description:  Metodo que enseña la interfaz de un Profesor, donde sale solo lo que un Profesor puede hacer.
     ******************************************************************************************************************/
    public void iniciarIU_Profesor(){
        Scanner sc = new Scanner(System.in);
        IU_Catalogo catalogo = new IU_Catalogo();
        GestorLibro GL = new GestorLibro();

        System.out.println("\n" +
                "&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&\n" +
                "Bienvenido:  "+u.getNombre()+"\n" +
                "Tu numero de libros prestados actual es: "+u.getNumeroLibrosPrestados()+"\n" +
                "&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&\n");

        boolean CerrarSesion = false;
        do {
            System.out.println("Elige una operación:\n\t1) Ver Catalogo\n\t2) Pedir prestado un libro\n\t3) Devolver libro\n\t4) Solicitar Adicion de Libro\n\t5) Cerrar Sesion");
            switch (sc.nextInt()) {
                case 1:
                    catalogo.iniciarIU_Catalogo();
                    break;
                case 2:
                    try {
                        System.out.println("Introduce el ISBN del libro que quieres pedir prestado");
                        int ISBN = sc.nextInt();
                        int Error = GL.prestarLibro(u, ISBN);
                        if (Error == 1) {

                            System.out.println("El libro ya se encuentra prestado. ¿Desea reservar?\n\t1) Si\n\t2) No");
                            if(sc.nextInt() == 1){
                                if(GL.reservarLibro(u,ISBN)){
                                    System.out.println("\nLibro reservado correctamente\n");
                                }
                            }

                        } else if (Error == 2){

                            System.out.println("El libro introducido no existe en nuestra Biblioteca");

                        }else{
                            System.out.println("Libro prestado correctamente");
                        }
                    }catch(Exception e){
                        System.out.println(e.getMessage());
                    }
                    break;
                case 3:
                    System.out.println("\nMetemos metodo de devolver libro");
                    break;
                case 4:
                    try {
                        System.out.println("Introduce el ISBN del Libro que quieres que forme parte de nuestra biblioteca");
                        int ISBN = sc.nextInt();
                        System.out.println("Introduce el código identificativo de tu libro");
                        int codigoIdentificativo = sc.nextInt();
                        if (!(GL.SolicitudAdicionDeLibro(u, ISBN, codigoIdentificativo))) {
                            System.out.println("Solicitud enviada correctamente");
                        }else{
                            System.out.println("\nEse ejemplar ya forma parte de nuestra Biblioteca\n");
                        }
                    }catch(Exception e){
                        System.out.println(e.getMessage());
                    }
                    break;
                case 5:
                    System.out.println("\nSesion cerrada correctamente.\n ¡Esperamos volver a verte pronto!\n");
                    CerrarSesion=true;
                    break;
            }
        }while(!CerrarSesion);
    }
}
