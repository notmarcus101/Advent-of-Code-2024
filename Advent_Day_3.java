
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Advent_Day_3 {
    public static void main(String[] args) {

        ArrayList<String> fileData = getFileData("src/Day3Input.txt");
        System.out.println(fileData);

        int sum = 0;
        boolean dont = false;
        for (String str : fileData) {
            ArrayList<String> matchList = new ArrayList<>();
            String look = "mul\\([0-9]{1,3},[0-9]{1,3}\\)|don't|do";
            Matcher match = Pattern.compile(look).matcher(str);
            while (match.find()) {
                matchList.add(match.group());
            }
            for (String n : matchList) {
                if (n.equals("don't")) {
                    dont = true;
                } else if (n.equals("do")) {
                    dont = false;
                } else if (!dont) {
                    String[] nums = n.replaceAll("[^,0-9]", "").split(",");
                    sum += Integer.parseInt(nums[0]) * Integer.parseInt(nums[1]);
                }
            }
        }

        System.out.println(sum);
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