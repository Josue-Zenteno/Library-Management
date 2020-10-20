package Presentacion;
import java.util.*;
import Dominio.*;
/***********************************************************************************************************************
 * Class Name: IU_Alumno
 * Authors: Josue Carlos Zenteno Yave
 *           Sergio Silvestre Pavon
 *           Adrian Ruiz Esteban
 *           Maria Jesus Dueñas Recuero
 * Date: 12/12/2019
 * Class Description: Clase Agente que cuenta con su constructor y el metodo iniciarIU_Alumno
 **********************************************************************************************************************/
public class IU_Alumno {
    private Usuario u;
    /*******************************************************************************************************************
     * Method name: IU_Alumno
     * Authors: Josue Carlos Zenteno Yave
     *           Sergio Silvestre Pavon
     *           Adrian Ruiz Esteban
     *           Maria Jesus Dueñas Recuero
     * Date: 12/12/2019
     *Description: Metodo constructor de la clase
     ******************************************************************************************************************/
    public IU_Alumno(Usuario u) {
        this.u = u;
    }
    /*******************************************************************************************************************
     * Method name: IU_Alumno
     * Authors: Josue Carlos Zenteno Yave
     *           Sergio Silvestre Pavon
     *           Adrian Ruiz Esteban
     *           Maria Jesus Dueñas Recuero
     * Date: 12/12/2019
     *Description: Metodo que enseña la interfaz de un Alumno, donde sale solo lo que un Alumno puede hacer.
     ******************************************************************************************************************/
    public void iniciarIU_Alumno(){
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
            System.out.println("Elige una operación:\n\t1) Ver Catalogo\n\t2) Pedir prestado un libro\n\t3) Devolver Libro\n\t4) Cerrar Sesion");
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
                    System.out.println("\nNo requerido");
                    break;
                case 4:
                    System.out.println("\nSesion cerrada correctamente.\n ¡Esperamos volver a verte pronto!\n");
                    CerrarSesion=true;
                    break;

            }
        }while(!CerrarSesion);
    }
}
