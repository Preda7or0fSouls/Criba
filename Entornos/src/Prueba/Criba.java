package Prueba;

import java.util.Scanner;
// TODO: Auto-generated Javadoc

/**
 * The Class Criba.
 */
public class Criba
{

/**
 * Generar primos.
 *
 * @author Carlos Soler
 * @param max the max
 * @return the int[]
 */
  /** Generar numeros al hazar**/
    public static int[] generarPrimos (int max)
    {
        int x,j;
        if (max >= 2) {

            int dim = max + 1; 
            boolean[] esPrimo = new boolean[dim];
/** Inicializar array**/
            for (x=0; x<dim; x++)
                esPrimo[x] = true;
/** Eliminar el 0 y el 1, que no son primos**/
            esPrimo[0] = esPrimo[1] = false;

            for (x=2; x<Math.sqrt(dim)+1; x++) {
                if (esPrimo[x]) {
/** Eliminar los múltiplos de i**/
                    for (j=2*x; j<dim; j+=x)
                        esPrimo[j] = false;
                }
            }

            int cuenta = 0;
            for (x=0; x<dim; x++) {
                if (esPrimo[x])
                    cuenta++;
            }
/** Rellenar el array de números primos**/
            int[] primos = new int[cuenta];
           
            for (x=0, j=0; x<dim; x++) {
                if (esPrimo[x])
                    primos[j++] = x;
            }
            return primos;
        } else { 
            return new int[0];
/** array vacío**/
        }
    }
    
    /**
     * The main method.
     *
     * @param args the arguments
     */
    public static void main(String[] args) {
        Scanner teclado=new Scanner(System.in);
        System.out.println("Introduce el nÃºmero para la criba de ErastÃ³tenes:");
        int dato=teclado.nextInt();
        int vector[]=new int[dato];
        System.out.println("\nVector inicial hasta :"+dato);
        for (int i = 0; i < vector.length; i++) {
            if (i%10==0) System.out.println();
            System.out.print(i+1+"\t");
        }
        vector=generarPrimos(dato);
        System.out.println("\nVector de primos hasta:"+dato);
        for (int i = 0; i < vector.length; i++) {
            if (i%10==0) System.out.println();
            System.out.print(vector[i]+"\t");
        }
    }
}