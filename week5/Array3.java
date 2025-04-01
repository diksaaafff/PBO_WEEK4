package week5;
import java.util.Arrays;
import java.util.Scanner;

public class Array3 {

    // Bubble Sort
    public static void bubbleSort(int[] arr) {
        System.out.println("\nBubble Sort:");
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    // Tukar posisi
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
                System.out.println(Arrays.toString(arr));
            }
        }
    }

    // Quick Sort
    public static void quickSort(int[] arr, int low, int high) {
        if (low < high) {
            int pi = partition(arr, low, high);
            System.out.println("Pivot: " + arr[pi] + " -> " + Arrays.toString(arr));
            quickSort(arr, low, pi - 1);
            quickSort(arr, pi + 1, high);
        }
    }

    private static int partition(int[] arr, int low, int high) {
        int pivot = arr[high];
        int i = (low - 1);
        for (int j = low; j < high; j++) {
            if (arr[j] < pivot) {
                i++;
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }
        int temp = arr[i + 1];
        arr[i + 1] = arr[high];
        arr[high] = temp;
        return i + 1;
    }

    // Insertion Sort
    public static void insertionSort(int[] arr) {
        System.out.println("\nInsertion Sort:");
        int n = arr.length;
        for (int i = 1; i < n; i++) {
            int key = arr[i];
            int j = i - 1;
            while (j >= 0 && arr[j] > key) {
                arr[j + 1] = arr[j];
                j--;
                System.out.println(Arrays.toString(arr));
            }
            arr[j + 1] = key;
            System.out.println(Arrays.toString(arr));
        }
    }

    // Selection Sort
    public static void selectionSort(int[] arr) {
        System.out.println("\nSelection Sort:");
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            int minIdx = i;
            for (int j = i + 1; j < n; j++) {
                if (arr[j] < arr[minIdx]) {
                    minIdx = j;
                }
            }
            int temp = arr[minIdx];
            arr[minIdx] = arr[i];
            arr[i] = temp;
            System.out.println(Arrays.toString(arr));
        }
    }

    // Merge Sort
    public static void mergeSort(int[] arr, int left, int right) {
        if (left < right) {
            int mid = (left + right) / 2;
            mergeSort(arr, left, mid);
            mergeSort(arr, mid + 1, right);
            merge(arr, left, mid, right);
            System.out.println("Merged: " + Arrays.toString(arr));
        }
    }

    private static void merge(int[] arr, int left, int mid, int right) {
        int n1 = mid - left + 1;
        int n2 = right - mid;
        int[] L = new int[n1];
        int[] R = new int[n2];

        for (int i = 0; i < n1; i++) {
            L[i] = arr[left + i];
        }
        for (int i = 0; i < n2; i++) {
            R[i] = arr[mid + 1 + i];
        }

        int i = 0, j = 0, k = left;
        while (i < n1 && j < n2) {
            if (L[i] <= R[j]) {
                arr[k] = L[i];
                i++;
            } else {
                arr[k] = R[j];
                j++;
            }
            k++;
        }

        while (i < n1) {
            arr[k] = L[i];
            i++;
            k++;
        }

        while (j < n2) {
            arr[k] = R[j];
            j++;
            k++;
        }
    }

    // Main Method
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Input dari pengguna
        System.out.print("Masukkan jumlah elemen: ");
        int n = scanner.nextInt();
        int[] input = new int[n];

        System.out.println("Masukkan elemen:");
        for (int i = 0; i < n; i++) {
            input[i] = scanner.nextInt();
        }

        System.out.println("Array asli: " + Arrays.toString(input));

        // Bubble Sort
        int[] bubbleInput = input.clone();
        bubbleSort(bubbleInput);

        // Quick Sort
        int[] quickInput = input.clone();
        System.out.println("\nQuick Sort:");
        quickSort(quickInput, 0, quickInput.length - 1);

        // Insertion Sort
        int[] insertionInput = input.clone();
        System.out.println("\nInsertion Sort:");
        insertionSort(insertionInput);

        // Selection Sort
        int[] selectionInput = input.clone();
        System.out.println("\nSelection Sort:");
        selectionSort(selectionInput);

        // Merge Sort
        int[] mergeInput = input.clone();
        System.out.println("\nMerge Sort:");
        mergeSort(mergeInput, 0, mergeInput.length - 1);

        scanner.close();
    }
}