package com.company;

import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FileUtils {

    //method to get unsorted list of numbers, reading numbers from file-source

    public static List<Integer> getUnsortedNumbers(File fileToRead) {

        List <Integer> unsortedNumbers = new ArrayList<>();

        try {
            Scanner scanner = new Scanner(fileToRead);
            int i = 0;
            while (scanner.hasNext()) {
                unsortedNumbers.add(i++, scanner.nextInt());
            }
        } catch (NumberFormatException t) {
            System.out.println("check format data in file");
        } catch (Exception e) {
            e.printStackTrace();
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
                // fileWriter.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}



