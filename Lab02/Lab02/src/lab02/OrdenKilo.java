package lab02;

public class OrdenKilo {
     public OrdenKilo(Ejercicio4 ejercicio4) {
         
        Carro[] carrosOrdenados = ejercicio4.getCarros();
        
        if(carrosOrdenados != null && carrosOrdenados.length >0){
         bubblesort(carrosOrdenados);
 
         System.out.println("Carros ordenados por kilometraje:");
            for (Carro carro : carrosOrdenados) {
                carro.mostrarInfo();
            }
        } else {
            System.out.println("No hay carros ingresados.");
        }
    }
     
    public void bubblesort(Carro[] arr) {
        int n = arr.length;
        boolean swapped;
        for (int i = 0; i < n - 1; i++) {
            swapped = false;
            for (int j = 0; j < n - i - 1; j++) {
                // Comparar por kilometraje
                if (arr[j].getKilometraje() > arr[j + 1].getKilometraje()) {
                    // Intercambiar los carros
                    Carro temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    swapped = true;
                }
            }
            // Si no hubo intercambio, el arreglo ya está ordenado
            if (!swapped) break;
        }
    }

        }


