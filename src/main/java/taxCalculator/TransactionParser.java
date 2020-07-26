package cash.register;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class TransactionParser {

    //Parse txt file line; Create Instance of ScannedItem; Store Text File data into Instance Variables.
    public ArrayList<ScannedItem> parseItemList(){

        //MUST CHANGE!! --> Src Data File
        String xFileName = "D:\\IdeaProjects\\Register\\src\\cash\\register\\InputFile3.txt";

        //Assign InArray Fixed length of 3 (for the 3 data file fields)
        String[] InArray = {"0","0","0"};

        //Each distinct scanned ITEM is a transaction & object in List.
        ArrayList<ScannedItem> transactions = new ArrayList<>();

        try{
            //Access File store reference
            Scanner scanIn = new Scanner(new BufferedReader(new FileReader(xFileName)));

            //If a line exists, parse line.
            while (scanIn.hasNextLine()){

                //Parse csv, store values in list
                String InputLine = scanIn.nextLine();
                InArray = InputLine.split(",");
                List<String> newList = Arrays.asList(InArray);

                //get data; create ScannedItem Obj; add Obj to transaction List
                int quantity = Integer.parseInt(newList.get(0));
                String item = newList.get(1);
                double price = Double.parseDouble(newList.get(2));

                //create item transaction and add to list of transactions
                ScannedItem scannedItem = new ScannedItem(item,quantity,price);
                transactions.add(scannedItem);
            }
        }
        catch (Exception e){
            System.out.println("something went wrong " + e);
        }

        return transactions;
    }
}
