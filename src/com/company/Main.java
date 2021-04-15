package com.company;
import java.io.*;
import java.util.List;
import java.util.Scanner;


public class Main {

    private static File fileToRead;
    private static File fileToSave;
    public static Scanner scanner;

    public static void main(String [] args) {

        scanner = new Scanner(System.in);
        String fileNameToRead = getFirstParam("Specify path to file with unsorted numbers ", scanner);
        String fileNameToSaveSortedData = getFileNameToSave(" Specify path and file name to save sorted data", scanner);

        // added checking: if problems with files, app should be exit
        if (!validateFiles(fileNameToRead, fileNameToSaveSortedData))
            return;

        List<Integer> unsortedNumbersList = FileUtils.getUnsortedNumbers(fileToRead);
        Sorting.selectSortingMethod(unsortedNumbersList);
        FileUtils.saveSortedNumbers(Sorting.numbersToSave, fileToSave);
    }

    private static String getFirstParam (String messageUserCanSeeInConsole, Scanner scanner) {
        System.out.println(messageUserCanSeeInConsole);
        return scanner.nextLine();
    }

    private static String getFileNameToSave(String messageUserCanSeeInConsole, Scanner scanner){
        System.out.println(messageUserCanSeeInConsole);
        return scanner.nextLine() + ".txt";
    }

    private static boolean validateFiles(String fileNameToRead, String fileNameToSaveSortedData){

        try {
            fileToRead = new File(fileNameToRead);

            if (!fileToRead.exists()) {
                System.out.println( "\"" + fileNameToRead + "\" File is not found. Nothing to sort. Check up path to file with unsorted numbers.");
                return false;// if file is not exists, then in main() method will be return
            }
            if (!fileToRead.canRead()) {
                System.out.println( "\'" + fileNameToRead + "\' File impossible to read. Make another readable file with *.txt extension.");
                return false;
            }

            fileToSave = new File( fileNameToSaveSortedData);

            if(fileToSave.exists()){
                System.out.println("File to save sorted numbers is already exists: "+ fileToSave.getAbsolutePath());
            }
            else  if (!fileToSave.exists()) {
                fileToSave = new File("D:\\INTERNSHIP\\JAVA_ROADMAP\\Sorting numbers\\results\\sortedNumbers.txt");
                System.out.println("File \"" + fileNameToSaveSortedData + "\" is not found. Sorted numbers will be saved to new file: " + fileToSave.getAbsolutePath());
            }
            else if(!fileToSave.canWrite()){
                System.out.println("\'" + fileNameToSaveSortedData + "\' file is invalid for writing");
                return false;
            }
        }
        catch (Exception e){
            e.printStackTrace();
        }
        return true;
    }

}




