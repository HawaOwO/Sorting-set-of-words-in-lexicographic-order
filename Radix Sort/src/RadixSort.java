import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

public class RadixSort
{
    /*
     * Radix sort an array of Strings
     * Assume all Strings consists of ASCII characters only
     * Assume all have length bounded by maxLen
     */

    public static void main(String [] args)
    {
        //Read file
        String temp = "";
        String filename = "src\\validWordList.txt";
        ArrayList<String> words = new ArrayList<String>();

        try {
            File myObj = new File(filename);
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {
                temp =  myReader.nextLine();
                words.add(temp);
            }
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }

        String[] wordList = words.toArray(new String[words.size()]);
        int len = wordList.length;

        int iter = radixSort(wordList, len);

        System.out.println("----------");
        System.out.println("RadixSort:");
        System.out.println("----------");

        for (String i : wordList)
            System.out.println("- " + i);

        System.out.println("----------------------------------------------");
        System.out.println("Number of iteration: " + iter);


        // Insert the sorted words inside other file
        try{
            FileWriter file = new FileWriter("src/RadixSortedList.txt");
            //insert array value into the file
            for(int i = 0; i < wordList.length; i++) {
                file.write(wordList[i]);
                file.write("\n");
            }
            file.close();
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }


    public static int radixSort(String [] arr, int maxLen)
    {
        int n = 0; // The primitive operations counter

        n += 2;
        final int BUCKETS = 127; // Size of bucketes created based on amount of ASCII characters

        n += 4;
        ArrayList<String> [] wordsByLength = new ArrayList[maxLen + 1];
        ArrayList<String> [] buckets = new ArrayList[BUCKETS];


        // ***************************************************************
        // Initializing the ArrayLists wordsByLength and buckets
        // ***************************************************************
        n += 2;
        for(int i = 0; i < wordsByLength.length; i++) {
            n++;
            wordsByLength[i] = new ArrayList<>();
        }

        n += 2;
        for(int i = 0; i < BUCKETS; i++) {
            n++;
            buckets[ i ] = new ArrayList<>();
        }
        // ***************************************************************


        n += 2;
        for(String s : arr) { // Copying the words from the file into wordsByLength
            n++;
            wordsByLength[s.length()].add(s);
        }


        n += 2;
        int index = 0;

        n += 2;
        for(ArrayList<String> wordList : wordsByLength) {
            n++;

            n += 2;
            for(String s : wordList) {
                n++;
                arr[index++] = s;
            }
        }

        n += 3;
        int startingIndex = arr.length;

        n += 5;
        for(int pos = maxLen - 1; pos >= 0; pos--)
        {
            n++;

            startingIndex -= wordsByLength[pos + 1].size();
            n += 4;

            n += 3;
            for(int i = startingIndex; i < arr.length; i++) { // Adding the words into respective buckets
                buckets[arr[i].charAt(pos)].add(arr[i]);
                n++;
            }

            n += 3;
            index = startingIndex;
            for(ArrayList<String> thisBucket : buckets) // Emptying the buckets
            {
                n++;

                n += 2;
                for(String s : thisBucket)
                {
                    n++;
                    arr[index++] = s;
                }
                thisBucket.clear();
            }
        }
        return n;
    }
}