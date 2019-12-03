import java.util.Scanner;
import java.io.File;
import java.util.ArrayList;

/**
 * Class to demonstrate how to read input from a text file.
 * 
 * @author (Sam Levine) 
 * @version (12-2-2019)
 */
public class Randomizer
{
    public static void ConstructDefaultArray()
    {
        ArrayList<String> names = new ArrayList<String>();
        Scanner myScannerInput;
        try
        {
            myScannerInput = new Scanner(new File("names.txt"));
        }
        catch (java.io.FileNotFoundException e)
        {
            System.out.println("FileNotFoundException: " + e.getMessage());
            return;
        }
        while (myScannerInput.hasNextLine())
        {
            String line = myScannerInput.nextLine();
            names.add(line);
        }
        System.out.println(names);
    }
    
    public static void ShuffleArray()
    {
        //ConstructDefaultArray();
        ArrayList<String> names = new ArrayList<String>();
        Scanner myScannerInput;
        try
        {
            myScannerInput = new Scanner(new File("names.txt"));
        }
        catch (java.io.FileNotFoundException e)
        {
            System.out.println("FileNotFoundException: " + e.getMessage());
            return;
        }
        while (myScannerInput.hasNextLine())
        {
            String line = myScannerInput.nextLine();
            names.add(line);
        }
        ArrayList<String> shuffledNames = new ArrayList<String>();
        while (names.size() > 0) {
            int selection = (int) Math.random()*names.size();
            shuffledNames.add(names.get(selection));
            names.remove(selection);
        }
        System.out.println(shuffledNames);
        System.out.println(names);
        System.out.println("Complete.");
    }
}