package com.company;
import java.util.List;
import java.util.Scanner;


public class Main {


    public static Scanner scanner;

    public static void main(String [] args) {

        scanner = new Scanner(System.in);
        String fileNameToRead = getFirstParam(" Specify path to file with unsorted numbers ", scanner);
        String fileNameToSaveSortedData = getFileNameToSave("\n Specify path and file name to save sorted data ", scanner);

        // checking file for reading: if problems with file, app is to close
        if (!FileUtils.validateFileForReading(fileNameToRead))
            return;

        // checking file for writing: if problems with file, app is to close
        if (!FileUtils.validateFileForWriting(fileNameToSaveSortedData))
            return;

        List<Integer> unsortedNumbersList = FileUtils.getUnsortedNumbers(FileUtils.fileToRead);
        Sorting.selectSortingMethod(unsortedNumbersList);
        FileUtils.saveSortedNumbers(Sorting.numbersToSave, FileUtils.fileToSave);
    }

    private static String getFirstParam (String messageUserCanSeeInConsole, Scanner scanner) {
        System.out.println(messageUserCanSeeInConsole);
        return scanner.nextLine();
    }

    private static String getFileNameToSave(String messageUserCanSeeInConsole, Scanner scanner){
        System.out.println(messageUserCanSeeInConsole);
        return scanner.nextLine() + ".txt";
    }
}




