public class HeapSort {

    public static void heapify(int arr[], int i, int size){
        int left=2*i+1;
        int right=2*i+2;
        int maxIdx=i;

        if(left<size && arr[left]>arr[maxIdx]){
            maxIdx=left;
        }

        if(right<size && arr[right]>arr[maxIdx]){
            maxIdx=right;
        }

        if(maxIdx!=i){
            // swap
            int temp=arr[maxIdx];
            arr[maxIdx]=arr[i];
            arr[i]=temp;
            // 
            heapify(arr, maxIdx, size);
        }
    }


    public static void heapSort(int arr[]){
        // step 1 - create a max heap
        int n=arr.length;
        for(int i=n/2; i>=0; i--){
            heapify(arr, i, n);
        }

        // step 2 - push the largest element to the last
        for(int i=n-1; i>0; i--){
            int temp=arr[0];
            arr[0]=arr[i];
            arr[i]=temp;

            heapify(arr, 0, i);
        }


    }
    public static void main(String[] args) {
        int arr[]={2,3,6,8,1,9,0};
        heapSort(arr);
        for(var x:arr){
            System.out.print(x+" ");
        }
    }
}
