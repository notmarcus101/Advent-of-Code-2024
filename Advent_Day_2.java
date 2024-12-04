import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Advent_Day_2 {
    public static void main(String[] args) {

        ArrayList<String> fileData = getFileData("src/Day 2 Input.txt");
        System.out.println(fileData);
        int safeCount = 0;
        boolean safe = true;

        for (int i = 0; i < fileData.size() - 1; i++) {
            String[] split = fileData.get(i).split(" ");
            int [] numberSplit = new int[split.length];
            for (int j = 0; j < split.length; j++) {
                numberSplit[j] = Integer.parseInt(split[j]);
            }

            while (safe = true) {
                for (int j = 0; j < numberSplit.length; j++) {
                    if (Math.abs(numberSplit[j + 1] - numberSplit[j]) > 3) {
                        safe = false;
                    }
                    if (safe) {
                        safeCount++;
                    }
                }
            }
            safe = true;
        }
    }



    public static ArrayList<String> getFileData(String fileName) {
        ArrayList<String> fileData = new ArrayList<String>();
        try {
            File f = new File(fileName);
            Scanner s = new Scanner(f);
            while (s.hasNextLine()) {
                String line = s.nextLine();
                if (!line.equals(""))
                    fileData.add(line);
            }
            return fileData;
        }
        catch (FileNotFoundException e) {
            return fileData;
        }
    }
}