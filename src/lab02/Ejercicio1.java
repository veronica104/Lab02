package lab02;

import java.awt.Menu;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Ejercicio1 {
     public void ejecutar() {
        
        Scanner scanner = new Scanner(System.in);
         Random random = new Random();
         Menu menuPrin=new Menu(); 
        System.out.println("Ingresa el tamano del arreglo");
        int tamaño=scanner.nextInt();
        
        int[] arreglo = new int [tamaño];
        
        for(int i=0;i<tamaño;i++){
            arreglo[i]=random.nextInt(20);
        }
        
        System.out.println("Arreglo");
        for(int i =0;i<tamaño;i++){
            System.out.println(arreglo[i]);
        }
       
        int opc;
        
       
        do{
            System.out.println("----menu----");
            System.out.println("1.calcular la media");
            System.out.println("2.calcular la mediana");
            System.out.println("3.calcular varianza");
            System.out.println("4.calcular deviacion estandar");
            System.out.println("5.calcular moda");
            System.out.println("6.salir del programa");
            
            opc = scanner.nextInt();
            
            switch(opc){
                case 1 -> {
                    double media =calcularmedia(arreglo);
                  System.out.println("la media es:"+media);
                }
                case 2 ->{
                    double mediana =calcularmediana(arreglo);
                  System.out.println("la mediana es: "+mediana);
                }
                case 3 ->{
                    double varianza=calcularvarianza(arreglo);
                  System.out.println("la varianza es: " + varianza);
                }
                case 4 ->{
                    double desviaciones=calculardesviaciones(arreglo);
                  System.out.println("la desviacion estandar es: " + desviaciones);
                }
                case 5 ->{
                    int moda=(int) calcularmoda(arreglo);
                   System.out.println("la moda es: "+ moda);
                }
                case 6 ->{
                    System.out.println("saliendo del programa...");
                }
                 default -> 
                 System.out.println("Opcion invalida.");
            }
        }while (opc != 6);
        scanner.close();
    }
      //media
        private  double calcularmedia(int[]arreglo){
              double suma =0;
            for (double num : arreglo){
                 suma +=num;
            }
             return suma/arreglo.length;
        }
             
        //mediana
            private double calcularmediana(int[]arreglo){
            Arrays.sort(arreglo);
            int tamaño=arreglo.length;
            if (tamaño % 2 == 0){
                return(arreglo[tamaño/2-1]+arreglo[tamaño/2])/2.0;
            }
            else{
                return arreglo[tamaño/2];
            }
            }
         
        //variacion
            private double calcularvarianza(int[]arreglo){
            double media = calcularmedia(arreglo);
            double sumadc=0;
            for(double num:arreglo){
                sumadc += Math.pow( num-media, 2);
            }
              return sumadc/arreglo.length;
            }
            
        //desvicion estandar
            private double calculardesviaciones(int[]arreglo){
            return Math.sqrt(calcularvarianza(arreglo));
            }
       
        //moda
            private double calcularmoda(int[]arreglo){
           int[] frecuencias=new int[20];
           
           for(int num : arreglo){
               frecuencias[num]++;
           }
           
           int moda=arreglo[0];
           int fremax=frecuencias[moda];
           
           for(int i =1;i<frecuencias.length;i++){
               if(frecuencias[i]>fremax){
                 fremax=frecuencias[i];
                 moda=i;
               }
              }
              return moda;
            }
}
