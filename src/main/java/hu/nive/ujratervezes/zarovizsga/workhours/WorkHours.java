package hu.nive.ujratervezes.zarovizsga.workhours;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class WorkHours {

    public String minWork(String file) {

        Path pathOfFile = Path.of(file);

        int minWorkTime = Integer.MAX_VALUE;
        String[] pufferArray = new String[3];
        String[] finalArray = new String[3];
        String line;

        try {
            BufferedReader reader = Files.newBufferedReader(pathOfFile);
            while ((line = reader.readLine()) != null) {
                pufferArray = line.split(",");

                if (Integer.parseInt(pufferArray[1]) < minWorkTime) {
                    finalArray = pufferArray;
                    minWorkTime = Integer.parseInt(pufferArray[1]);
                }
            }
        } catch (IOException ioe) {
            throw new IllegalStateException("File can not read", ioe);
        }

        return finalArray[0] + ": " + finalArray[2];
    }
    /*public static void main(String[] args) {
        System.out.println(new WorkHours().minWork("workhours.txt"));
    }*/
}
