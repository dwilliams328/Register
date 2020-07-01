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


        for(int i = 0; i < itemList.size();i++){

            System.out.println(itemList.get(i).getItem());
            System.out.println(itemList.get(i).getPrice());
            TaxCalculator.calculate(itemList.get(i));
            System.out.println(itemList.get(i).getSaleTaxAmount());
        }
    }
}
