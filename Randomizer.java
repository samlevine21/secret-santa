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
    static ArrayList<String> names = new ArrayList<String>();
    static ArrayList<String> shuffledNames = new ArrayList<String>();
    public static void main(String[] args)
    {
        ClearShuffledArray();
        ReadNames();
        Randomize();
        PrintPairs();
    }
    
    private static void ClearShuffledArray() 
    {
           while (shuffledNames.size() > 0) {
               shuffledNames.remove(0);
           } 
    }
    
    private static void ReadNames()
    {
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
    }
    
    private static void Randomize() 
    {
        int initialSize = names.size();
        int selection;
        for (int i = 0;  i < initialSize; i++) {
            selection = (int) (Math.random()*names.size());
            shuffledNames.add(i, names.get(selection));
            names.remove(selection);
        }
    }
    
    private static void PrintPairs()
    {
        for (int i = 0;  i < shuffledNames.size()-1; i++) {
            System.out.println(shuffledNames.get(i) + " is assigned to " 
            + shuffledNames.get(i+1));
        }
        System.out.println(shuffledNames.get(shuffledNames.size()-1) +
        " is assigned to " + shuffledNames.get(0));
    }
}