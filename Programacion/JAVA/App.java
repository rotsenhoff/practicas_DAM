import java.util.Scanner;


public class App{

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int numero = 0;
        String apellido_1 = "Labrada";
        int sumaPrecios = 0;
        
        String [] apellidos = new String [5];

        apellidos[0] = "Labrada";
        apellidos[4] = "García";
        apellidos[1] = "Arteaga";
        apellidos[2] = "Suárez";
        apellidos[3] = "Romo";

        /* System.out.println(apellidos[0]); */
        for(int i=0; i<apellidos.length; i++){

            System.out.print(apellidos[i]);

        }

        /* i = 0
        
         */

         int [] precios = new int[3];
         for(int i=0; i<precios.length; i++){

            System.out.println("Introduce un precio: ");
            precios[i] = sc.nextInt();

        }
        for(int i=0; i<precios.length; i++){

            System.out.println(precios[i]);

        }

        for(int i=0; i<precios.length; i++){
            sumaPrecios = sumaPrecios + precios[i];
        }

        System.out.println("Suma de los precios: " + sumaPrecios);


        double promedio = sumaPrecios/precios.length;

        System.out.println("Promedio: " + promedio);

    }
}