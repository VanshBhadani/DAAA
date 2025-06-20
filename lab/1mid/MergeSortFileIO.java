import java.io.*;
import java.util.*;

public class MergeSortFileIO {
    static void merge(int arr[], int left, int mid, int right) {
        int n1 = mid - left + 1;
        int n2 = right - mid;
        int leftArray[] = new int[n1];
        int rightArray[] = new int[n2];

        for (int i = 0; i < n1; i++)
            leftArray[i] = arr[left + i];
        for (int j = 0; j < n2; j++)
            rightArray[j] = arr[mid + 1 + j];

        int i = 0, j = 0, k = left;
        while (i < n1 && j < n2) {
            if (leftArray[i] <= rightArray[j]) {
                arr[k] = leftArray[i];
                i++;
            } else {
                arr[k] = rightArray[j];
                j++;
            }
            k++;
        }
        while (i < n1) {
            arr[k] = leftArray[i];
            i++;
            k++;
        }
        while (j < n2) {
            arr[k] = rightArray[j];
            j++;
            k++;
        }
    }

    static void mergeSort(int arr[], int left, int right) {
        if (left < right) {
            int mid = left + (right - left) / 2;
            mergeSort(arr, left, mid);
            mergeSort(arr, mid + 1, right);
            merge(arr, left, mid, right);
        }
    }

    public static void main(String[] args) {
        try {
            File inputFile = new File("input.txt");
            Scanner sc = new Scanner(inputFile);
            List<Integer> list = new ArrayList<>();

            while (sc.hasNextInt()) {
                list.add(sc.nextInt());
            }
            sc.close();

            int arr[] = list.stream().mapToInt(i -> i).toArray();
            mergeSort(arr, 0, arr.length - 1);

            FileWriter outputFile = new FileWriter("output.txt");
            for (int num : arr) {
                outputFile.write(num + " ");
            }
            outputFile.close();

            System.out.println("Sorting complete. Check output.txt for results.");
        } catch (IOException e) {
            System.out.println("An error occurred: " + e.getMessage());
        }
    }
}