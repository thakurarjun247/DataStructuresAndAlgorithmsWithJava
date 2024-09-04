package datastructures.arraystring.fun;

import util.ArrayUtil;

import java.util.Arrays;
import java.util.Scanner;

public class SortingSearching {
    ArrayUtil arrayUtil = new ArrayUtil();
    Scanner scanner = new Scanner(System.in);

    public void displayChoice() {

        System.out.println();
        System.out.println("====================choice menu====================");
        System.out.println("-1: exit ");
        System.out.println(" 0: modify the default unsorted datastructures.array ");
        System.out.println(" 1: traverseArray ");
        System.out.println(" 2: linearSearch ");
        System.out.println(" 3: createSortedAscendingArray ");
        System.out.println(" 4: binarySearchIterative  ");
        System.out.println(" 5: binarySearchRecursive  ");
        System.out.println(" 6: bubbleSort");
        System.out.println(" 7: recursive linear search");
        System.out.println(" 8: selection sort");
        System.out.println(" 9: merge sort");
        System.out.println(" 10:quick sort");
        System.out.println("=====================================================");
        System.out.println();

    }

    public void modifyArray(int[] array) {
        for (int i = 0; i < array.length; i++) {
            System.out.print("enter item at index " + i);
            array[i] = scanner.nextInt();
        }
        System.out.println("datastructures.array modified, here it is...");
        traverseArray(array);
    }

    public void findPairOfNumbersWhichHasSomeAsGivenNumber(int[] array) {
        System.out.println("enter the number ");
        int number = scanner.nextInt();

    }

    public void traverseArray(int[] array) {
        System.out.println(
                "---------------------------------------------------------------------------------------------");
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + "  ");
        }
        System.out.println();
        System.out.println(
                "---------------------------------------------------------------------------------------------");
    }

    public int findMissingNumber() {
        System.out.println(
                "You are given a list of n-1 integers and these integers are in the range of 1 to n. There are no duplicates in list. ");
        System.out.println("enter size of datastructures.array");
        int size = scanner.nextInt();
        return 0;
    }

    public int linearSearch(int[] array) {
        System.out.println("enter a number to be searched");
        int number = scanner.nextInt();
        for (int i = 0; i < array.length; i++) {
            if (array[i] == number) {
                System.out.println(number + " found at location " + i);
                return i;
            }
        }
        System.out.println("number not found");
        return -1;

    }

    public int binarySearchIterative(int[] sortedAscendingArray, int key) {

        traverseArray(sortedAscendingArray);
        int start, end, mid;
        start = 0;
        end = sortedAscendingArray.length - 1;

        while (start <= end) {
            mid = (start + end) / 2;
            if (key == sortedAscendingArray[mid]) {
                System.out.println(key + " found at location " + mid);
                return mid;
            }
            if (key < sortedAscendingArray[mid]) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }

        }
        System.out.println(key + " not found in following datastructures.array");
        traverseArray(sortedAscendingArray);
        return -1;
    }

    public int binarySearchRecursive(int[] sortedAscendingArray, int key, int start, int end) {
        if (start > end) {
            System.out.println("not found");
            return -1;
        }
        int mid = (start + end) / 2;

        if (key == sortedAscendingArray[mid]) {
            System.out.println(key + " found at location " + mid);
            return mid;
        }

        if (key < sortedAscendingArray[mid]) {
            return binarySearchRecursive(sortedAscendingArray, key, start, mid - 1);
        } else {
            return binarySearchRecursive(sortedAscendingArray, key, mid + 1, end);
        }
    }

    public int[] bubbleSort(int[] array) {
        // the largest element bubbles up to the rightmost position in pass 1
        // next time we ignore the rightmost element , becuase it is in proper
        // place
        // we process remaining elements only
        traverseArray(array);

        //
        int n = array.length;
        for (int pass = n; pass > 0; pass--) {
            for (int i = 0; i < pass - 1; i++) {
                // Util.swap(datastructures.array, i, i+1);
                if (array[i] > array[i + 1]) {
                    int temp = array[i];
                    array[i] = array[i + 1];
                    array[i + 1] = temp;
                }
            }
        }
        traverseArray(array);
        return array;
    }
    /*
	 * private void bSort(int[] a ) { //Integer[] a=Arrays.copy int n=a.length;
	 * for(int i=0;i<n-1;i++) { for(int j=0;j<n-i-1;j++) { int temp = a[i]; a[i] =
	 * a[i + 1]; a[i + 1] = temp; } } }
	 */

    public int[] selectionSort(int[] a) {
        // scan the datastructures.array and find the smallest element
        // swap it with the leftmost element
        // ignore the leftmost in the next pass
        traverseArray(a);
        int temp = a[0];
        for (int j = 0; j < a.length; j++) {
            for (int i = j + 1; i < a.length; i++) {
                if (a[i] < temp) {
                    temp = a[i];
                    a[i] = a[j];
                    a[j] = temp;
                }


            }
        }
        traverseArray(a);
        return a;
    }

    public void mergeSort(int[] a) {

        int[] temp = new int[a.length];
        mergeSort(a, temp, 0, a.length - 1);
        System.out.println("merge sorting...");
        traverseArray(a);
    }

    private void mergeSort(int[] a, int[] temp, int low, int high) {
        if (low < high) {
            int middle = (low + high) / 2;
            mergeSort(a, temp, low, middle); // split into first and second halves
            mergeSort(a, temp, middle + 1, high);
            mergeHalves(a, temp, low, middle, high);
        }

    }

    private void mergeHalves(int[] array, int[] temp, int low, int middle, int high) {
        // copy into helper datastructures.array
/*		for (int i = low; i <=high; i++) {
			temp[i] = datastructures.array[i];
		}*/
        temp = Arrays.copyOf(array, array.length);
        int helperLeft = low;
        int current = low;
        int helperRight = middle + 1;
		/*
		 * Iterate through helper datastructures.array. Compare the left and right half, copying back
		 * the smaller element from the two halves 28 * into the original datastructures.array.
		 */
        while (helperLeft <= middle && helperRight <= high) {
            if (temp[helperLeft] < temp[helperRight]) {
                array[current] = temp[helperLeft];
                helperLeft++;
            } else {
                array[current] = temp[helperRight];
                helperRight++;
            }
            current++;
        }

        int remaining = middle - helperLeft;
        for (int i = 0; i <= remaining; i++) {
            array[current + i] = temp[helperLeft + i];
        }
		/*
		 * if (helperLeft < middle) { while (helperLeft != middle) { a[current] =
		 * helper[helperLeft]; helperLeft++; current++; } }
		 */
		/*
		 * You may notice that only the remaining elements from the left half of the
		 * helper datastructures.array are copied into the target datastructures.array. Why not the right half? The
		 * right half doesn't need to be copied because it's already there
		 */

		/*
		 * if(helperRight<high) { while(helperRight!=high) {
		 * a[current]=helper[helperRight]; helperRight++; current++; } }
		 */

    }

    public void recursiveLinearSearch() {
        System.out.println("enter item to be found");
        int array[] = {0, 1, 2, 3, 4, 5};
        int item = scanner.nextInt();
        System.out.println("searching...");
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + "  ");
        }

        recursiveLinearSearch(array, item, 0);

    }

    private void recursiveLinearSearch(int[] array, int item, int i) {
        if (array.length == 0) {
            System.out.println("empty datastructures.array");
            return;
        }
        if (i >= array.length) {
            System.out.println("item not found ");
            return;
        }
        if (array[i] == item) {
            System.out.println("found at index " + i);
            return;
        } else {
            // notice it's not i++ otherwise i will be increased after execution
            // of instruction which will be uselsess
            // i=i++; wont work
            // either use ++i or just i=i+1
            i = i + 1;
            System.out.println(i);
            recursiveLinearSearch(array, item, i);
        }

    }

    private void deleteMe(String s) {

    }

    public void quickSort(int[] arr, int left, int right) {
        if (left >= right)
        // can be left>right as well
        {
            return;
        }
        //pivot is the time at mid position
        int pivotItem = arr[(left + right) / 2];
        int pivotIndexAfterPartition = partition(arr, left, right, pivotItem);
        quickSort(arr, left, pivotIndexAfterPartition - 1);
        quickSort(arr, pivotIndexAfterPartition, right);

    }

    private int partition(int[] arr, int left, int right, int pivot) {
        while (left <= right) {
            // can be left<right as well
            while (arr[left] < pivot) {
                left++;
            }
            while (arr[right] > pivot) {
                right--;
            }
            if (left <= right) {
                swap(arr, left, right);
                left++;
                right--;
            }
        }
        return left;
    }

    private void swap(int[] arr, int left, int right) {
        int temp = arr[left];
        arr[left] = arr[right];
        arr[right] = temp;

    }
}
