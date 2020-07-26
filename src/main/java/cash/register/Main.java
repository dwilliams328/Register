package cash.register;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


public class Main {

    public static void main(String[] args) throws IOException {

        TransactionParser transactionParser = new TransactionParser();
        TaxCalculator taxCalculator = new TaxCalculator();


        //Create new array list to store TaxAppliedItemsList. (ScannedItem objects post calculations)
        ArrayList<ScannedItem> itemList;
        itemList = transactionParser.parseItemList();
        ArrayList<ScannedItem> taxAppliedItemList = new ArrayList<>();


        for(int i = 0; i < itemList.size();i++){
            taxAppliedItemList.add(taxCalculator.calculate(itemList.get(i)));
        }

        //Output Display
        for(int i = 0; i < itemList.size();i++){
            System.out.println(taxAppliedItemList.get(i).getItem() + " " + taxAppliedItemList.get(i).getItemTotal());
        }


        System.out.println(taxAppliedItemList.get(0));

    }
}
