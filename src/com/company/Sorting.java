package com.company;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Sorting {

    public static int sortMethodNumber;
    public static List<Integer> numbersToSave;

    public static void selectSortingMethod(List<Integer> unsortedNumbers) {// to select sorting method

        System.out.println("\n Select sorting method by" + "\n" +
                "selecting corresponding number: " + "\n" + "\n" +
                "Bubble sorting - press key '1' " + "\n" +
                "Sorting by inserts - press key '2' " + "\n" +
                "Sorting by choice - press key '3' " + "\n"
        );

        try {
            Scanner scanner = new Scanner(System.in);

            sortMethodNumber = scanner.nextInt();
            if (sortMethodNumber == 1) {

                bubbleSorting(unsortedNumbers);
                return;
            }
            else if (sortMethodNumber == 2) {
                insertionSorting(unsortedNumbers);
                return;
            }
            else if  (sortMethodNumber == 3) {
                choiceSorting(unsortedNumbers);
                return;
            }
            else System.out.println(" You can enter just 1, 2 or 3 numbers for choosing sorting method. Run program again. ");
            // here I tried to make recursion of selectSortingMethod() or loop for waiting correct value of sortMethodNumber in case of wrong value. But failure

        }

        catch (Exception e){
            e.printStackTrace();
        }

    }

    public static List<Integer> bubbleSorting(List<Integer> arrayListUnsorted) {//sorting method - bubble  sorting

        boolean sorted = false;// this variable controls quantity of iterations
        int temp;// variable for swapping neighbour numbers in array
        while (!sorted) {//outer cycle
            sorted = true;//condition to stop outer cycle
            for (int i = 0; i < arrayListUnsorted.size() - 1; i++) {//inner cycle
                if (arrayListUnsorted.get(i) > arrayListUnsorted.get(i + 1)) {//condition for swapping neighbour numbers in array
                    temp = arrayListUnsorted.get(i);
                    arrayListUnsorted.set(i, arrayListUnsorted.get(i + 1));
                    arrayListUnsorted.set(i + 1, temp);
                    sorted = false;// condition to keep outer cycle
                }
            }
        }

        numbersToSave = new ArrayList<>(arrayListUnsorted);
        return numbersToSave;
    }

    //sorting method - sorting by insertions
    public static List<Integer> insertionSorting(List<Integer> arrayListUnsorted) {

        for (int i = 1; i < arrayListUnsorted.size(); i++) {//outer cycle
            int current = arrayListUnsorted.get(i);
            int j = i - 1;
            while (j >= 0 && current < arrayListUnsorted.get(j)) {//inner cycle, condition for swapping neighbour numbers
                arrayListUnsorted.set(j + 1, arrayListUnsorted.get(j));//first step for swapping neighbour numbers
                j--;//condition to stop inner cycle
            }
            arrayListUnsorted.set(j + 1, current);// second step for swapping neighbour numbers
        }
        numbersToSave = new ArrayList<>(arrayListUnsorted);
        return numbersToSave;
    }

    //sorting method - sorting by choice
    public static List<Integer> choiceSorting(List<Integer> arrayListUnsorted) {

        for (int i = 0; i < arrayListUnsorted.size(); i++) { // outer cycle
            int min = arrayListUnsorted.get(i);
            int minId = i;
            for (int j = i + 1; j < arrayListUnsorted.size(); j++) { // inner cycle, to find number which smaller than variable "min"
                if (arrayListUnsorted.get(j) < min) { //condition for swapping neighbour numbers in array
                    min = arrayListUnsorted.get(j);
                    minId = j;
                }
            }
            // swapping neighbour numbers
            int temp = arrayListUnsorted.get(i);
            arrayListUnsorted.set(i, min);
            arrayListUnsorted.set(minId, temp);
        }
        numbersToSave = new ArrayList<>(arrayListUnsorted);
        return numbersToSave;
    }
}

