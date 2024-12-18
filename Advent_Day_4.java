import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Advent_Day_4 {
    public static void main(String[] args) {

        ArrayList<String> fileData = getFileData("src/Day4Input.txt");
        System.out.println(fileData);

        String[][] grid = new String[fileData.size()][fileData.getFirst().length()];

        for (int i = 0; i < fileData.size(); i++) {
            for (int j = 0; j < fileData.getFirst().length(); j++) {
                grid[i][j] = fileData.get(i).substring(j, j + 1);
            }
        }

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                try {

                } catch (ArrayIndexOutOfBoundsException _) {}
            }
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