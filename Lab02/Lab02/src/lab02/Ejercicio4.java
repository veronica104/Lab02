package lab02;

import java.util.Scanner;


class Carro{
            
            private String marca;
            private double modelo;
            private String color;
            private double kilometraje;
            
            public Carro(String marca, double modelo, String color, double kilometraje){
              this.marca=marca;
              this.modelo=modelo;
              this.color=color;
              this.kilometraje=kilometraje;
            }
            
            public void mostrarInfo(){
                System.out.println("marca: "+ marca +", modelo: "+modelo+"color: "+ color +", kilometraje: "+ kilometraje + "km");
            }
            
            public double getModelo(){
                return modelo;
            }
            
            public double getKilometraje(){
                return kilometraje;
            }
}
            
     

public class Ejercicio4 {
    Scanner scanner = new Scanner(System.in);
    public Carro[] carros=null;
    
    public void ejecutar() { 
        
        System.out.println("ingrese la cantidad de carros: ");
        int cantcar = scanner.nextInt();
        scanner.nextLine();
        
        carros = new Carro[cantcar];
        
        for(int i = 0;i < cantcar; i++){
            System.out.println("ingrese la siguiente informacion del carro "+(i+1)+ ":");
            System.out.println("Marca: ");
            String marca = scanner.nextLine();
            System.out.println("Modelo: ");
            double modelo = scanner.nextDouble();
            scanner.nextLine();
            System.out.println("Color: ");
            String color = scanner.nextLine();
            System.out.println("Kilometraje: ");
            double kilometraje = scanner.nextDouble();
            scanner.nextLine();
            
            carros[i] = new Carro(marca,modelo,color,kilometraje);
        }
        
        System.out.println("\nInformacion de los carros ingresados:");
        for(Carro carro : carros){
            carro.mostrarInfo();
        }
        //scanner.close();
        
        //Invovcar jframe despues de ejecuatr el codigo
        Ordenar ordenar = new Ordenar();
        ordenar.mostrar();
       
    }
     
   //medoto getter para devolver el arreglo
    public Carro[] getCarros(){
        if(carros==null)
            ejecutar();
        return carros;
    }
}



