/**
 * Given an array of integers arr where each element is at most k places away 
 * from its sorted position, code an efficient function sortKMessedArray 
 * that sorts arr. For instance, for an input array of size 10 and k = 2, an element belonging to 
 * index 6 in the sorted array 
 * will be located at either index 4, 5, 6, 7 or 8 in the input array.
 * Example:
 * input:  arr = [1, 4, 5, 2, 3, 7, 8, 6, 10, 9], k = 2
 * output: [1, 2, 3, 4, 5, 6, 7, 8, 9, 10]
 * 
 * https://www.geeksforgeeks.org/nearly-sorted-algorithm/
 * 
 */

 import java.util.Arrays;
import java.util.PriorityQueue;

 class KSort{

    static void kSortUsingInsertionSort(int [] arr, int k){
        /**
         * input:  arr = [1, 4, 5, 2, 3, 7, 8, 6, 10, 9], k = 2
         * process:
            [1, 4, 5, 2, 3, 7, 8, 6, 10, 9]
            -----------------------------
            [1, 4, 5, 2, 3, 7, 8, 6, 10, 9]
            -----------------------------
            [1, 4, 5, 2, 3, 7, 8, 6, 10, 9]
            [1, 4, 2, 5, 3, 7, 8, 6, 10, 9]
            [1, 2, 4, 5, 3, 7, 8, 6, 10, 9]
            -----------------------------
            [1, 2, 4, 5, 3, 7, 8, 6, 10, 9]
            [1, 2, 4, 3, 5, 7, 8, 6, 10, 9]
            [1, 2, 3, 4, 5, 7, 8, 6, 10, 9]
            -----------------------------
            [1, 2, 3, 4, 5, 7, 8, 6, 10, 9]
            -----------------------------
            [1, 2, 3, 4, 5, 7, 8, 6, 10, 9]
            -----------------------------
            [1, 2, 3, 4, 5, 7, 8, 6, 10, 9]
            [1, 2, 3, 4, 5, 7, 6, 8, 10, 9]
            [1, 2, 3, 4, 5, 6, 7, 8, 10, 9]
            -----------------------------
            [1, 2, 3, 4, 5, 6, 7, 8, 10, 9]
            -----------------------------
            [1, 2, 3, 4, 5, 6, 7, 8, 10, 9]
            [1, 2, 3, 4, 5, 6, 7, 8, 9, 10]
            -----------------------------

            Time Complexity : O(N * k)
         */ 
        for(int i=1; i<arr.length; i++){
            int key = arr[i];
            int j = i - 1;
            while(j>=0 && arr[j] > key){
                int temp = arr[j+1];
                arr[j+1] = arr[j];
                arr[j] = temp;
                j--;
            }
        }
    }

    static void kSortUsingBubbleSort(int [] arr, int k){
        /**
         * input:  arr = [1, 4, 5, 2, 3, 7, 8, 6, 10, 9], k = 2
         *  process:
            [1, 4, 5, 2, 3, 7, 8, 6, 10, 9]
            [1, 4, 5, 2, 3, 7, 8, 6, 10, 9]
            [1, 4, 2, 5, 3, 7, 8, 6, 10, 9]
            [1, 4, 2, 3, 5, 7, 8, 6, 10, 9]
            [1, 4, 2, 3, 5, 7, 8, 6, 10, 9]
            [1, 4, 2, 3, 5, 7, 8, 6, 10, 9]
            [1, 4, 2, 3, 5, 7, 6, 8, 10, 9]
            [1, 4, 2, 3, 5, 7, 6, 8, 10, 9]
            [1, 4, 2, 3, 5, 7, 6, 8, 9, 10]
            --------------------
            [1, 4, 2, 3, 5, 7, 6, 8, 9, 10]
            [1, 2, 4, 3, 5, 7, 6, 8, 9, 10]
            [1, 2, 3, 4, 5, 7, 6, 8, 9, 10]
            [1, 2, 3, 4, 5, 7, 6, 8, 9, 10]
            [1, 2, 3, 4, 5, 7, 6, 8, 9, 10]
            [1, 2, 3, 4, 5, 6, 7, 8, 9, 10]
            [1, 2, 3, 4, 5, 6, 7, 8, 9, 10]
            [1, 2, 3, 4, 5, 6, 7, 8, 9, 10]
            [1, 2, 3, 4, 5, 6, 7, 8, 9, 10]
            --------------------
            [1, 2, 3, 4, 5, 6, 7, 8, 9, 10]
            [1, 2, 3, 4, 5, 6, 7, 8, 9, 10]
            [1, 2, 3, 4, 5, 6, 7, 8, 9, 10]
            [1, 2, 3, 4, 5, 6, 7, 8, 9, 10]
            [1, 2, 3, 4, 5, 6, 7, 8, 9, 10]
            [1, 2, 3, 4, 5, 6, 7, 8, 9, 10]
            [1, 2, 3, 4, 5, 6, 7, 8, 9, 10]
            [1, 2, 3, 4, 5, 6, 7, 8, 9, 10]
            [1, 2, 3, 4, 5, 6, 7, 8, 9, 10]
            --------------------
            Time Complexity : O(N * (k+1))
         */
        boolean sorted = false;
        while(!sorted){
            sorted = true;
            for(int i = 0; i < arr.length-1 ; i++){
                if(arr[i] > arr[i+1]){
                    sorted = false;
                    int temp = arr[i];
                    arr[i] = arr[i+1];
                    arr[i+1] = temp;
                }
            }
        }
    }

     static void ksortUsingHeap(int [] arr, int k){
        /**
         * input:  arr = [1, 4, 5, 2, 3, 7, 8, 6, 10, 9], k = 2
         * ---------ARRAY------------------------------PQ-----
            [1, 4, 5, 2, 3, 7, 8, 6, 10, 9]            1,4,5
            [1, 4, 5, 2, 3, 7, 8, 6, 10, 9]            4,5,2
            [1, 2, 5, 2, 3, 7, 8, 6, 10, 9]            4,5,3
            [1, 2, 3, 2, 3, 7, 8, 6, 10, 9]            4,5,7
            [1, 2, 3, 4, 3, 7, 8, 6, 10, 9]            5,7,8
            [1, 2, 3, 4, 5, 7, 8, 6, 10, 9]            7,8,6
            [1, 2, 3, 4, 5, 6, 8, 6, 10, 9]            7,8,10
            [1, 2, 3, 4, 5, 6, 7, 6, 10, 9]            8,10,9
            [1, 2, 3, 4, 5, 6, 7, 8, 10, 9]            10,9
            [1, 2, 3, 4, 5, 6, 7, 8, 9,  9]            10
            [1, 2, 3, 4, 5, 6, 7, 8, 9, 10] 
            
            Time Complexity : O(N * log k)
         */
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(k+1);
        int nextIdxToAdd = 0;
        // add first k+1 elements
        for(int i=0 ; i <= k ; i++){
            priorityQueue.add(arr[i]);
            nextIdxToAdd++;
        }
        arr[0] = priorityQueue.poll();
        // now we just need to add 1 more element each time to the heap
        for(int i=1; i<arr.length; i++){
            if(nextIdxToAdd < arr.length){
                priorityQueue.add(arr[nextIdxToAdd++]);
            }
            arr[i] = priorityQueue.poll();
        }
     }
     public static void main(String[] args){
        int [] arr = getK2MessyArray();
        ksortUsingHeap(arr, 2);
        System.out.println(Arrays.toString(arr));
        arr = getK2MessyArray();
        kSortUsingBubbleSort(arr, 2);
        System.out.println(Arrays.toString(arr));
        arr = getK2MessyArray();
        kSortUsingInsertionSort(arr,2);
        System.out.println(Arrays.toString(arr));
     }

     static int[] getK2MessyArray(){
         return new int[]{1, 4, 5, 2, 3, 7, 8, 6, 10, 9};
     }
 }        