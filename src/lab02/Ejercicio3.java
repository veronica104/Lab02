package lab02;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;


public class Ejercicio3 {
    public void ejecutar() {
       Random random = new Random();
       Scanner scanner =new Scanner(System.in);
       int[] tamaños ={100,500,1000,5000,10000};

       System.out.printf("%-10s %-15s %-15s %-15s %-15s%n", "Tamaño", "Burbuja (ms)", "Inserción (ms)", "Selección (ms)", "Mergesort (ms)");
       
       for(int  tamaño:tamaños){
           double[] arreglo = new double[tamaño];
           for (int i =0;i<tamaño;i++){
              arreglo[i]=random.nextDouble()*100;
           }
           
        //medir burbuja
        double[] burbuja=Arrays.copyOf(arreglo,arreglo.length);
        long inicio = System.currentTimeMillis();
        ordenarburbuja(burbuja);
        long tiempobu = System.currentTimeMillis()-inicio;
        
        //medir insercion
        double[] insercion=Arrays.copyOf(arreglo,arreglo.length);
        inicio = System.currentTimeMillis();
        ordenarinsercion(insercion);
        long tiempoin = System.currentTimeMillis()-inicio;
        
        //medir burbuja
        double[] seleccion=Arrays.copyOf(arreglo,arreglo.length);
        inicio = System.currentTimeMillis();
        ordenarseleccion(seleccion);
        long tiempose = System.currentTimeMillis()-inicio;
        
        //medir mergesort
        double[] mergesort=Arrays.copyOf(arreglo,arreglo.length);
        inicio = System.currentTimeMillis();
        ordenarmergesort(mergesort);
        long tiempome = System.currentTimeMillis()-inicio;
        
        System.out.printf("%-10d %-15d %-15d %-15d %-15d%n", tamaño, tiempobu, tiempoin, tiempose, tiempome);
   }
       //scanner.close();
}
       
 
    public static void ordenarburbuja(double[] arreglo){
        int n =arreglo.length;
         for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (arreglo[j] > arreglo[j + 1]) {
                    // Intercambiar arreglo[j] y arreglo[j + 1]
                    double temp = arreglo[j];
                    arreglo[j] = arreglo[j + 1];
                    arreglo[j + 1] = temp;
                }
            }
         }    
    }
    
    public static void ordenarinsercion(double[] arreglo){
        int n=arreglo.length;
        for (int i = 1; i < n; i++) {
            double key = arreglo[i];
            int j = i - 1;
            while (j >= 0 && arreglo[j] > key) {
                arreglo[j + 1] = arreglo[j];
                j = j - 1;
            }
            arreglo[j + 1] = key;
        }
    }
    
    public static void ordenarseleccion(double[] arreglo){
        int n = arreglo.length;
        for (int i = 0; i < n - 1; i++) {
            int minIdx = i;
            for (int j = i + 1; j < n; j++) {
                if (arreglo[j] < arreglo[minIdx]) {
                    minIdx = j;
                }
            }
            // Intercambiar arreglo[minIdx] y arreglo[i]
            double temp = arreglo[minIdx];
            arreglo[minIdx] = arreglo[i];
            arreglo[i] = temp;
        } 
    }
    
    public static void ordenarmergesort(double[] arreglo){
        if(arreglo.length<=1){
            return ;
        }
        
        int mid=arreglo.length /2;
        double[] left = Arrays.copyOfRange(arreglo, 0, mid);
        double[] right = Arrays.copyOfRange(arreglo, mid, arreglo.length);

        ordenarmergesort(left);
        ordenarmergesort(right);

       merge(arreglo,left, right);
    }
    
    // funcion auxiliar de mergesort
     private static void merge(double[]arreglo, double[] left, double[] right) {
    
        int i = 0, j = 0, k = 0;

        while (i < left.length && j < right.length) {
            if (left[i] <= right[j]) {
                arreglo[k++] = left[i++];
            } else {
                arreglo[k++] = right[j++];
            }
        }

        while (i < left.length) {
            arreglo[k++] = left[i++];
        }

        while (j < right.length) {
            arreglo[k++] = right[j++];
        }
     }
}

