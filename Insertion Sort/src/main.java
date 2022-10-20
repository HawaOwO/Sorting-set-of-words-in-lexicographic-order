import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class main {

    public static void main(String[] args) throws IOException {

        // read the file
//        String path = ;
        Scanner sc = new Scanner(new File("src\\CompleteFiltered.txt"));

        // new file for sorted list
        FileWriter fw = new FileWriter("src/insertionSortedList.txt");
        List<String> lines = new ArrayList<String>();

        //reading the file
        while(sc.hasNextLine()){
            lines.add(sc.nextLine());
        }

        String[] arr = lines.toArray(new String[0]);

        insSort(arr, fw);
        fw.close();
    }


    public static void insSort(String[] arr, FileWriter fw) throws IOException {
        long counter = 0;
        String key;
        counter += 1;
        int i,j,k;
        counter += 3;

        counter++; // initialize i = 1
        for (i = 1; i < arr.length; ++i) {
            counter+=2;

            key = arr[i];
            counter++;

            j = i - 1;
            counter+=2;
            // Compare key with each element on the left of it until an element smaller than
            // it is found.

            while (j >= 0) {
                counter += 2;
                if (key.compareTo(arr[j]) > 0) {
                    break;
                }
                counter += 2;
                arr[j + 1] = arr[j];
                counter += 2;
                j--;
                counter++;
            }
            // Place key at after the element just smaller than it.
            arr[j + 1] = key;
        }
        counter++;

        for(k=0;k< arr.length;++k){
            System.out.println(arr[k]);
            fw.write(arr[k] + "\n");
        }
        System.out.println("Premitive Counter: " + counter);

    }
}
