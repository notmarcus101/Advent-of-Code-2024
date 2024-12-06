import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Advent_Day_2 {
    public static void main(String[] args) {

        ArrayList<String> fileData = getFileData("src/test.txt");
        int safeCount = 0;
        boolean safe = true;
        boolean inc = false;
        boolean dec = false;

        for (int i = 0; i < fileData.size(); i++) {
        }

        for (int i = 0; i < fileData.size() - 1; i++) {
            String[] split = fileData.get(i).split(" ");
            int [] numberSplit = new int[split.length];
            for (int j = 0; j < numberSplit.length; j++) {
                numberSplit[j] = Integer.parseInt(split[j]);
            }

            for (int j = 0; j < numberSplit.length - 1; j++) {
                if (numberSplit[j] > numberSplit[j + 1]) {
                    inc = true;
                } else {
                    dec = true;
                }

                if (inc && dec) {
                    safe = false;
                    inc = false;
                    dec = false;
                }
            }
            for (int j = 0; j < numberSplit.length - 1; j++) {
                if (safe && inc) {
                    int differenceInc = numberSplit[j + 1] - numberSplit[j];
                    if (!((differenceInc >= 1) && (differenceInc <= 3))) {
                        safe = false;
                    }
                } else if (safe && dec) {
                    int differenceDec = numberSplit[j] - numberSplit[j + 1];
                    if (!((differenceDec >= 1) && (differenceDec <= 3))) {
                        safe = false;
                    }
                }
                if (!safe) {
                    break;
                }
            }
            if (safe) {
                safeCount++;
            } else {
                safe = true;
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