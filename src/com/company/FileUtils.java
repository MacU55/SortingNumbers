package com.company;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.util.Scanner;
import static com.company.Main.*;


public class FileUtils {
    // method to give name for file where sorted numbers will be written(if that file name is empty)
    public static boolean isFileExists(){

        boolean fileExist = false;

        try{
            String d = fileToSave.toString();
            if(d.equals(".txt")) {
                fileToSave = new File("./results/sortedNumbers.txt");//
            }
            fileExist = true;

        }
        catch (Exception e){
            System.out.println(e.getMessage());
        }
        return fileExist;
    }
    //method to get unsorted list of numbers, reading numbers from file-source
    public static List<Integer> getUnsortedNumbers(File fileToRead){

        //unsortedNumbers = new ArrayList<>();
        try{
            Scanner scannerForNumbers = new Scanner(fileToRead);
            int i = 0 ;
            while (scannerForNumbers.hasNextInt()){
                unsortedNumbers.add(i++, scannerForNumbers.nextInt());
            }
        }

        catch (NumberFormatException t){
            System.out.println("check format data in file");
        }
        catch (Exception e){
            e.printStackTrace();
        }
        System.out.print("unsortedNumbers: ");
        for(Integer r : unsortedNumbers){
            System.out.print(String.format(" %d, ", r ));
        }
        return unsortedNumbers;

    }
    // method to write sorted numbers into file
    public static void saveSortedNumbers(List <Integer> sortedNumbers, File fileToSave) throws IOException {

        try (FileWriter fileWriter = new FileWriter (fileToSave)) {
            for (int i = 0; i < sortedNumbers.size(); i++)
            {
                String s = Integer.toString(sortedNumbers.get(i));
                fileWriter.write(s);
                fileWriter.write(System.lineSeparator());
            }
        }
    }
}

