package om.example.bubbleSort;

import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BubbleSort {
    public static void main(String[] args){
    List<String> listOfWords = new ArrayList<String>();
    Scanner x;
    long counter= 0; //!!!!!!! COUNTER
    try{

        x= new Scanner(new File("src\\wordList.txt"));
        //while there's word inside the file, it will assign  a variable to the value inside file
        while(x.hasNext()){
            String word= x.next();
            //add the value inside listOfStrings
            listOfWords.add(word);
        }
        // convert arraylist to array
        // array name = SortedArray
        String[] SortedArray = listOfWords.toArray(new String[0]);

        //process to do bubble sort
        String temp;
        counter++;
        System.out.println("Words in bubble sorted order:");
        for (int j = 0; j < SortedArray.length; j++) {
            counter+=5;
            for (int i = j + 1; i < SortedArray.length; i++) {
                counter+=3;
                // comparing adjacent strings and ignoring the upper and lower case differences
                if (SortedArray[i].compareToIgnoreCase(SortedArray[j]) < 0) {
                    counter+=4;
                    temp = SortedArray[j];
                    counter+=2;
                    SortedArray[j] = SortedArray[i];
                    counter+=3;
                    SortedArray[i] = temp;
                    counter+=2;
                }
            }
            //output the sorted words
            System.out.println(SortedArray[j]);
        }
        //closing the file
        x.close();

        //display and insert the sorted words inside other file
        try{
            FileWriter file = new FileWriter("src/BubbleSortedList.txt");
            //insert array value into the file
            for(int z=0; z< SortedArray.length; z++){
                file.write(SortedArray[z]);
                file.write("\n");
            }
            //close the sorted file
            file.close();

            //output the counter of the primitive type
            System.out.printf("\nThe primitive counter are : %d\n", counter);
        }
        //incase the file is not successfully open
        catch(Exception e){
            e.printStackTrace();
        }

    }
    //display message if the file could not be found
    catch(Exception e){
        System.out.println("\nCould not find file");
    }
}

}












