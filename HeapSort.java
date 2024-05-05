import java.util.*;

public class HeapSort {
    public static void heapsort(int arr[]){
        int N=arr.length;
        for(int i=N/2-1; i >=0;i--){
            heapify(arr,N,i);
        }
        for(int i = N-1; i>=0; i--){
            int temp=arr[0];
            arr[0]=arr[i];
            arr[i]=temp;
            heapify(arr,i,0);
        }
    }
    static void heapify(int arr[], int N, int i){
        int largest=i;
        int l = 2*i+1;
        int r = l + 1;
        if(l < N && arr[l] > arr[largest]){
            largest=l;
        }
        if(r < N && arr[r] > arr[largest]){
            largest=r;
        }
        if(largest!=i){
            int swap=arr[i];
            arr[i]=arr[largest];
            arr[largest]=swap;
            heapify(arr, N, largest);
        }
    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int arr [] = new int[n];
        for(int i = 0; i < n; i++){
            arr[i] = sc.nextInt();
        }
        heapsort(arr);
        for(int i = 0; i < n; i++){
            System.out.print(arr[i] + " ");
        }
    }
}
