package lab02;

import java.util.Scanner;


public class Ejercicio2 {
    public void ejecutar() {

        Scanner scanner =new Scanner(System.in);
        
        //leer linea de caracteres
        System.out.println("ingrese una linea de texto: ");
        String linea=scanner.nextLine();
     
        int opc;
          
        do{
            System.out.println("----menu----");
            System.out.println("1.vocales sustituidas");
            System.out.println("2.invertir orden");
            System.out.println("3.salir");
            opc=scanner.nextInt();
        
         switch(opc){
         case 1 -> {
             char mafrec=mafrec(linea);
             String resultado=linea.replaceAll("[AEIUOaeiou]",String.valueOf(mafrec));
             System.out.println("Resultado: "+resultado);
         }
         case 2->{
             //invertir orden de letras
            String lineain=new StringBuilder(linea).reverse().toString();
            System.out.println("Resultado invertido: "+lineain);
         }
         case 3->{
             System.out.println("saliendo del programa..");
         }
         default ->{
             System.out.println("opcion no valida");
         }
     }
    }while(opc!=3);
            
        //scanner.close();
    }
    
    private static char mafrec(String linea){
        int[]frecuencias=new int[256];
        
        for(char c:linea.toCharArray()){
            if (c !=' '){
                frecuencias[c]++;
            }
        }
        
        char mafrec=linea.charAt(0);
        int maxf=0;
        
        for (char c:linea.toCharArray()){
            if(frecuencias[c]>maxf){
                maxf=frecuencias[c];
                mafrec=c;
            }
        }
        return mafrec;
    }
    
}

