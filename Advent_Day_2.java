import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Advent_Day_2 {
    public static void main(String[] args) {

        ArrayList<String> fileData = getFileData("src/test.txt");
        int safeCount = 0;
        boolean safe;
        boolean firstUnsafe;
        System.out.println(fileData);

        for (int i = 0; i < fileData.size(); i++) {
            safe = true;
            firstUnsafe = true;

            String[] split = fileData.get(i).split(" ");
            int [] numberSplit = new int[split.length];
            for (int j = 0; j < numberSplit.length; j++) {
                numberSplit[j] = Integer.parseInt(split[j]);
            }

            int[] differences = new int[numberSplit.length - 1];
            for (int j = 0; j < numberSplit.length - 1; j++) {
                differences[j] = numberSplit[j] - numberSplit[j + 1];
            }

            int countDiff = 0;

            for (int num : differences) {
                if (Math.abs(num) >= 1 && Math.abs(num) <= 3) {
                    countDiff++;
                } else {
                    if (firstUnsafe) {
                        countDiff++;
                        firstUnsafe = false;
                    }
                }
            }

            if (countDiff != differences.length) {
                safe = false;
            }

            int countNorP = 0;

            for (int num : differences) {
                if ( num > 0) {
                    countNorP++;
                } else {
                    countNorP--;
                }
            }

            if ((Math.abs(countNorP) != differences.length) && (Math.abs(countNorP) != differences.length - 1)) {
                safe = false;
            }

            if (safe) {
                safeCount++;
            }
        }

        System.out.println("safe count: " + safeCount);
    }

    public boolean ifSafe(int[] numList) {
        for (int i = 0; i < numList.length - 1; i++) {
            if (!((Math.abs(numList[i] - numList[i + 1]) <= 3) && (Math.abs(numList[i] - numList[i + 1]) >= 1))) {
                return false;
            }
        }

        return true;
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