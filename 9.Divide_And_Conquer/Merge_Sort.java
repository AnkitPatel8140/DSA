public class Merge_Sort {
    // this function will merge the left and right sorted part of the array
    public static void merge(int arr[], int si, int mid, int ei) {
        // creating a temporary array to store the array in sorted order
        int temp[] = new int[ei - si + 1];
        // pointer to left array
        int i = si;
        // pointer to right array
        int j = mid + 1;
        // pointer to the temporary array
        int k = 0;

        // this while loop will sort the left and right array in the temp array
        while (i <= mid && j <= ei) {
            if (arr[i] < arr[j]) {
                temp[k++] = arr[i++];
            } else {
                temp[k++] = arr[j++];
            }
        }

        // if left or right array are still having some element
        while (i <= mid) {
            temp[k++] = arr[i++];
        }
        while (j <= ei) {
            temp[k++] = arr[j++];
        }

        // copying the temp array into the original array
        for (k = 0, i = si; k < temp.length; k++, i++) {
            arr[i] = temp[k];
        }
    }

    // this function divides the array into smaller parts
    public static void mergeSort(int arr[], int si, int ei) {
        if (si >= ei) {
            return;
        }
        int mid = si + (ei - si) / 2;
        // we assume that this will sort the left part
        mergeSort(arr, si, mid);
        // this will sort the right part
        mergeSort(arr, mid + 1, ei);
        // this function merges the two sorted parts
        merge(arr, si, mid, ei);
    }

    // this function print the array
    static void printArray(int arr[]) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int arr[] = { 6, 3, 9, 5, 2, 8 };
        printArray(arr);
        mergeSort(arr, 0, arr.length-1);
        printArray(arr);
    }
}
