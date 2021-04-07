package com.company;
import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class Main {

    static File fileToRead;
    static File fileToSave;
    static FileWriter fileWriter;
    static List<Integer> unsortedNumbers = new ArrayList<>();
    public static List<Integer> numbersToSave;

    public static void main(String[] args) throws IOException {

        System.out.println("Path to unsorted numbers file:\n");

        try{
            Scanner filePathScanner = new Scanner(System.in);
            String filePathAndName = filePathScanner.nextLine();
            System.out.println("you entered path: " + filePathAndName + "\n");
            fileToRead = new File(filePathAndName);

            System.out.println("Enter file name for saving sorted numbers ");
            Scanner fileSaveScanner = new Scanner(System.in);
            String fileSaveSorted = fileSaveScanner.nextLine();
            fileToSave = new File(fileSaveSorted + ".txt");

        }
        catch (Exception e){
            System.out.println(e.getMessage());
            e.printStackTrace();
        }

        if( FileUtils.isFileExists()){
            FileUtils.getUnsortedNumbers(fileToRead);
        }
        Sorting.selectSortingMethod();
        FileUtils.saveSortedNumbers( numbersToSave, fileToSave);

    }

}

