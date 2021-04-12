package com.company;
import java.io.*;
import java.nio.file.Files;
import java.util.Scanner;
//import static org.junit.Assert.assertTrue;


public class Main {

    private static File fileToRead;
    private static File fileToSave;
    public static Scanner scanner;

    public static void main(String[] args) {

        scanner = new Scanner(System.in);
        String fileNameToRead = getFirstParam("Specify path to file with unsorted numbers", scanner);
        String directoryNameToSaveSortedData = getDirectoryToSave("Specify path to directory to save sorted data", scanner);
        String fileNameToSaveSortedData = getFileNameToSave("Specify file name to save sorted data", scanner);
        validateFiles(fileNameToRead, directoryNameToSaveSortedData ,fileNameToSaveSortedData);
        FileUtils.getUnsortedNumbers(fileToRead);
        Sorting.selectSortingMethod();
        FileUtils.saveSortedNumbers(Sorting.numbersToSave, fileToSave);
    }

    private static String getFirstParam (String messageUserCanSeeInConsole, Scanner scanner) {
        System.out.println(messageUserCanSeeInConsole);
        return scanner.nextLine();
    }
    private static String getDirectoryToSave(String messageUserCanSeeInConsole, Scanner scanner){
        System.out.println(messageUserCanSeeInConsole);
        return scanner.nextLine();
    }
    private static String getFileNameToSave(String messageUserCanSeeInConsole, Scanner scanner){
        System.out.println(messageUserCanSeeInConsole);
        return new StringBuilder().append(scanner.nextLine()).append(".txt").toString();
    }

    private static void validateFiles(String fileNameToRead, String directoryNameToSaveSortedData, String fileNameToSaveSortedData){
        try {
            fileToRead = new File(fileNameToRead);
            fileToSave = new File(directoryNameToSaveSortedData, fileNameToSaveSortedData);

            boolean result = fileToSave.createNewFile();
            if(result){
                System.out.println("File to save sorted numbers is created: "+fileToSave.getCanonicalPath());
            }
            else {
                System.out.println("File already exist at location: "+fileToSave.getCanonicalPath());
            }

            if (!fileToRead.exists()) {
                System.out.println("\'" + fileNameToRead + "\' file is not found. Check path and file name");
                System.exit(0);
            }
            if (!fileToRead.canRead()) {
                System.out.println("\'" + fileNameToRead + "\' file impossible to read file. Make another readable file with *.txt extension");
                System.exit(0);
            }
            if (!fileToSave.exists()) {
                System.out.println("\'" + fileNameToSaveSortedData + "\' file for saving sorted numbers is not created. File \"sortedNumbers\" will be created.");
                fileToSave = new File("./results/sortedNumbers.txt ");
            }
            if(!fileToSave.canWrite()){
                System.out.println("\'" + fileNameToSaveSortedData + "\' file is invalid for writing");
            }
        }
        catch (Exception e){
            try(Writer w = new FileWriter("file.log", true)) {
                e.printStackTrace(new PrintWriter(new BufferedWriter(w)));
            } catch (IOException ioException) {
                ioException.printStackTrace();
            }
        }
    }


}




