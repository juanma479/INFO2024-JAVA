package arreglos;

public class ArreglosUnidimensionales {
    public static void main(String[] args) {
        
        int[] array = {1,2,3,4,5,6,7};

        System.out.println("El tamaño del arreglo es: " + array.length);
        System.out.println("Acceder al valor de la posición 3: " + array[2] );

        boolean[] array2 = new boolean[6];
        System.out.println("Valor de la posición 1: " + array2[0]);

        //Cambiar el valor de un elemento en una posición

        array[0]= 100;
        System.out.println("Nuevo valor de array, en posición 0: " + array[0]);

        int[] enteros = {5,23,7,2,2,1,1};

        for(int i=enteros.length-1; i>=0; i--) {
            System.out.println("Indice "+i+" valor "+enteros[i]);
        }


    }
}
