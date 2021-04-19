package com.company;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FileUtils {

    static File fileToRead;
    static File fileToSave;
    private static File fileToSaveChars = new File("./chars.txt");

    static boolean validateFileForReading(String fileNameToRead){

        try {
            fileToRead = new File(fileNameToRead);

            if (!fileToRead.exists()) {
                System.out.println( "\"" + fileNameToRead + "\" File is not found. Nothing to sort. Check up path to file with unsorted numbers.");
                return false;// if file is not exists, then in main() method will be return
            }
            if (!fileToRead.canRead()) {
                System.out.println( "\'" + fileNameToRead + "\' File is impossible to read. Make another readable file with *.txt extension.");
                return false;
            }
        }
        catch (Exception e){
            e.printStackTrace();
        }
        return true;
    }

    static boolean validateFileForWriting (String fileNameToSaveSortedData){

        try {
            fileToSave = new File( fileNameToSaveSortedData);
            if(fileToSave.exists()){
                System.out.println("File to save sorted numbers is already exists: "+ fileToSave.getAbsolutePath());
            }
            else  if (!fileToSave.exists()) {
                fileToSave = new File("D:\\INTERNSHIP\\JAVA_ROADMAP\\sortingNumbers_3\\results\\sortedNumbers.txt");
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

    //method to get unsorted list of numbers, also it can read chars from file-source
    public static List<Integer> getUnsortedNumbers(File fileToRead) {

        List <Integer> unsortedNumbers = new ArrayList<>();
        List <String> someChars = new ArrayList<>();
        int numbersCounter = 0;
        int charsCounter = 0;

        try {
            FileReader fileReader = new FileReader(fileToRead);
            BufferedReader reader = new BufferedReader(fileReader);
            Scanner scanner = new Scanner(fileToRead);

            String line = reader.readLine();
            while (line != null) {
                String [] splitString = line.split("\\s+");//split line into array of chars
                for(String g : splitString){//check every char: number or not?
                    if(g.matches("\\d+(\\d+)?")){// here char is number
                        unsortedNumbers.add(numbersCounter++, Integer.valueOf(g) );
                    }
                    else someChars.add(charsCounter++, g);// here is char
                }
                line = reader.readLine();
            }
            fileReader.close();
            reader.close();
            scanner.close();
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        if(numbersCounter == 0){
            System.out.println(" Numbers were not found in file: " + fileToRead.getAbsolutePath());
        }
        if(charsCounter > 0){
            saveChars(someChars, fileToSaveChars);
            System.out.println("\n Some characters were found and saved in file: " + fileToSaveChars.getAbsolutePath());
        }
        return unsortedNumbers;
    }
    // method to write sorted numbers into file
    public static void saveSortedNumbers(List<Integer> sortedNumbers, File fileToSave) {

        try (FileWriter fileWriter = new FileWriter(fileToSave)) {
            for (int i = 0; i < sortedNumbers.size(); i++) {
                String s = Integer.toString(sortedNumbers.get(i));
                fileWriter.write(s);
                fileWriter.write(System.lineSeparator());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    //method for saving chars in file, if chars are in file)
    public static void saveChars(List<String> someChars, File fileToSaveChars) {

        try (FileWriter fileWriter = new FileWriter(fileToSaveChars)) {
            for (int i = 0; i < someChars.size(); i++) {
                String s = (someChars.get(i));
                fileWriter.write(s);
                fileWriter.write(System.lineSeparator());
                //fileWriter.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}



