package Dominio;
import java.util.*;
/***********************************************************************************************************************
 * Class Name: GestorCatalogo
 * Authors: Josue Carlos Zenteno Yave
 *           Sergio Silvestre Pavon
 *           Adrian Ruiz Esteban
 *           Maria Jesus Dueñas Recuero
 * Date: 12/12/2019
 * Class Description: Clase Gestor Catalogo que cuenta con el metodo mostrarcatalogo
 **********************************************************************************************************************/
public class GestorCatalogo {
    /*******************************************************************************************************************
     * Method Name: mostrarCatalogo
     * Authors: Josue Carlos Zenteno Yave
     *           Sergio Silvestre Pavon
     *           Adrian Ruiz Esteban
     *           Maria Jesus Dueñas Recuero
     * Date: 12/12/2019
     * Description: Metodo encargado de mostrar el catalogo siguiendo algunas directrices
     ******************************************************************************************************************/
    public String mostrarCatalogo(int opcion) throws Exception{
        Scanner sc = new Scanner (System.in);
        String LaStringDefinitiva="";
        Libro [] auxArray;
        switch(opcion){
            case 1:
                auxArray =Libro.readLibro("SELECT * FROM PruebaBBDD.Libros WHERE Estado = 'Disponible';");
                for(int i= 0; i<auxArray.length;i++){
                    LaStringDefinitiva += "\n"+auxArray[i].toString();
                }
                break;
            case 2:
                System.out.print("Introduce el nombre del Autor:  ");
                String autor = sc.nextLine();
                auxArray =Libro.readLibro("SELECT * FROM PruebaBBDD.Libros WHERE Autor= '"+ autor+"' AND Estado = 'Disponible';");

                //Comprobamos que, en caso de no recibir respuesta, nos diga que no habia libros que cumpliesen el filtro
                if(auxArray != null){
                    for(int i= 0; i<auxArray.length;i++){
                        LaStringDefinitiva += "\n"+auxArray[i].toString();
                    }
                }else{
                    System.out.println("Ningun libro cumple con esa caracteristica");
                }
                break;
            case 3:
                System.out.print("Introduce el ISBN:  ");
                int ISBN = sc.nextInt();
                auxArray=Libro.readLibro("SELECT * FROM PruebaBBDD.Libros WHERE ISBN= '" + ISBN + "'AND Estado = 'Disponible';");

                //Comprobamos que, en caso de no recibir respuesta, nos diga que no habia libros que cumpliesen el filtro
                if(auxArray != null){
                    for(int i= 0; i<auxArray.length;i++){
                        LaStringDefinitiva += "\n"+auxArray[i].toString();
                    }
                }else{
                    System.out.println("Ningun libro cumple con esa caracteristica");
                }
                break;
            case 4:
                System.out.print("Introduce el Genero:  ");
                String genero = sc.nextLine();
                auxArray=Libro.readLibro("SELECT * FROM PruebaBBDD.Libros WHERE Genero= '" + genero + "'AND Estado = 'Disponible';");

                //Comprobamos que, en caso de no recibir respuesta, nos diga que no habia libros que cumpliesen el filtro
                if(auxArray != null){
                    for(int i= 0; i<auxArray.length;i++){
                        LaStringDefinitiva += "\n"+auxArray[i].toString();
                    }
                }else{
                    System.out.println("Ningun libro cumple con esa caracteristica");
                }
                break;
            case 5:
                System.out.print("Introduce el Titulo:  ");
                String titulo = sc.nextLine();
                auxArray=Libro.readLibro("SELECT * FROM PruebaBBDD.Libros WHERE Titulo= '" + titulo + "'AND Estado = 'Disponible';");

                //Comprobamos que, en caso de no recibir respuesta, nos diga que no habia libros que cumpliesen el filtro
                if(auxArray != null){
                    for(int i= 0; i<auxArray.length;i++){
                        LaStringDefinitiva += "\n"+auxArray[i].toString();
                    }
                }else{
                    System.out.println("Ningun libro cumple con esa caracteristica");
                }
                break;
            default:
                System.out.println("Ni darle a un boton sabes");
                break;
        }
        return LaStringDefinitiva;
    }
}
