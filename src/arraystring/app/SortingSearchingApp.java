package arraystring.app;

import arraystring.fun.SortingSearching;

import java.util.Scanner;

public class SortingSearchingApp {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] array = {5, 4, 3, 2};
        //int[] array = { 1 , 2,  3,  4,  5,  6,  7,  8,  9  };
        int[] sortedArray = {-3, -1, 0, 2, 3, 5, 7, 8};
        SortingSearching sortingSearching = new SortingSearching();
        // arrayOperations.getArray();

        for (int i = 0; i < 100; i++) {
        /*	System.out.println("default sorted array");
			sortingSearching.traverseArray(sortedArray);
			System.out.println("default unsorted array");
			sortingSearching.traverseArray(array);*/
            sortingSearching.displayChoice();
            int choice = scanner.nextInt();
            switch (choice) {
                case -1:
                    System.out.println("exiting...");
                    System.exit(0);
                    break;
                case 0:
                    sortingSearching.modifyArray(array);
                    break;
                case 1:
                    sortingSearching.traverseArray(array);
                    break;
                case 2:
                    sortingSearching.linearSearch(array);
                    break;
                case 3:
                    System.out.println("unimplemented..");
                    break;
                case 4:
                    System.out.println("enter a key");
                    int key = scanner.nextInt();
                    sortingSearching.binarySearchIterative(sortedArray, key);
                    break;
                case 5:
                    System.out.println("enter a key");
                    key = scanner.nextInt();
                    sortingSearching.binarySearchRecursive(sortedArray, key, 0, sortedArray.length - 1);
                    break;
                case 6:
                    sortingSearching.bubbleSort(array);
                    break;
                case 7:
                    sortingSearching.recursiveLinearSearch();
                    break;
                case 8:
                    sortingSearching.selectionSort(array);
                    break;
                case 9:
                    sortingSearching.mergeSort(array);
                    break;
                case 10:
                    System.out.println("before ");
                    sortingSearching.traverseArray(array);
                    sortingSearching.quickSort(array, 0, array.length - 1);
                    System.out.println("after ");
                    sortingSearching.traverseArray(array);
                    break;
                case 11:
                    break;
                case 12:
                    break;
                case 13:
                    break;
                case 14:
                    break;
                case 15:
                    break;
                case 16:
                    break;

                default:
                    System.out.println("invalid choice");

            }
        }
        scanner.close();

    }

}
