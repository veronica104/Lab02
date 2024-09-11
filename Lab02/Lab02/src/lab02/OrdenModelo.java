
package lab02;

public class OrdenModelo {
    public OrdenModelo(Ejercicio4 ejercicio4){
        
        Carro[] carrosOrdenados = ejercicio4.getCarros();
        
        if (carrosOrdenados != null && carrosOrdenados.length > 0) {
            mergesorts(carrosOrdenados,0,carrosOrdenados.length-1);
            System.out.println("Carros ordenados por modelo:");
            for (Carro carro : carrosOrdenados) {
                carro.mostrarInfo();
            }
        } else {
            System.out.println("No hay carros ingresados.");
        }
    }
        
// Método MergeSort recursivo
    public static void mergesorts(Carro[] arr, int left, int right) {
        if (left < right) {
            int middle = (left + right) / 2;

            mergesorts(arr, left, middle);
            mergesorts(arr, middle + 1, right);

            merge(arr, left, middle, right);
        }
    }
 
    public static void merge(Carro[] arr, int left, int middle, int right) {
        int n1 = middle - left + 1;
        int n2 = right - middle;

        Carro[] L = new Carro[n1];
        Carro[] R = new Carro[n2];

        for (int i = 0; i < n1; i++) {
            L[i] = arr[left + i];
        }
        for (int j = 0; j < n2; j++) {
            R[j] = arr[middle + 1 + j];
        }

        int i = 0, j = 0;
        int k = left;
        while (i < n1 && j < n2) {
            if (L[i].getModelo() <= R[j].getModelo()) {
                arr[k] = L[i];
                i++;
            } else {
                arr[k] = R[j];
                j++;
            }
            k++;
        }

        // Copiar los elementos restantes de L[]
        while (i < n1) {
            arr[k] = L[i];
            i++;
            k++;
        }

        // Copiar los elementos restantes de R[]
        while (j < n2) {
            arr[k] = R[j];
            j++;
            k++;
        }
    } 
}
