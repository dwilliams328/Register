package cash.register;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


public class Main {

    public static void main(String[] args) throws IOException {

        TransactionParser transactionParser = new TransactionParser();
        TaxCalculator taxCalculator = new TaxCalculator();

        ArrayList<ScannedItem> itemList;

        itemList = transactionParser.parseItemList();
        ArrayList<ScannedItem> taxAppliedItemList = new ArrayList<>();

         for(int i = 0; i < itemList.size();i++){
            //System.out.println(itemList.get(i).getQuantity());
            //System.out.println(itemList.get(i).getItem());

            taxAppliedItemList.add(taxCalculator.calculate(itemList.get(i)));

        }

        for(int i = 0; i < itemList.size();i++){
            System.out.println(taxAppliedItemList.get(i).getGrandTotal());

        }

    }
}
