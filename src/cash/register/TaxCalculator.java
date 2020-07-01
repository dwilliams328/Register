//This Class is a tool. It Accepts Objects, alters them if Tax application applicable ;)
package cash.register;

import com.sun.org.apache.xpath.internal.operations.Bool;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//Apply Base sales tax and Import tax on specific goods.
public class TaxCalculator {

    private static ArrayList<String> exemptItem;
    private static String importKey = "Import";

    //On Instantiation, create exemptItem list
    public TaxCalculator(){
        this.exemptItem = new ArrayList<>();
        this.exemptItem.add("Book");
        this.exemptItem.add("Pill");

        //Covers chocolate bar, imported box of chocolate etc.
        this.exemptItem.add("Chocolate");
    }

    /* ROAD BLOCK-ISH. Data has to exactly match exemptItem(etc) as oppose to substringing.
       Probably has to do with indexOf() on a list.*/
    public static ScannedItem calculate(ScannedItem item){

        //Store basic sales TAX AMOUNT - Store -1 if item is not in list
        int isExempt = TaxCalculator.exemptItem.indexOf(item.getItem());

        //If isExempt == -1, then item is in list and therefore is exempt from basic sales taxes
        if (isExempt == -1){
            double saleTaxAmount = (item.getPrice() * .10);

            item.setSaleTaxAmount(saleTaxAmount);

        }

        //Calculate & store imported good TAX AMOUNT - Stores -1 if item is not in list
        int isImport = TaxCalculator.importKey.indexOf(item.getItem());

        //IF isImport != -1, then item is in list and therefore should have import taxes applied
        if(isImport != -1){
            double importTaxAmount = (item.getPrice() * .05);

            item.setImportTaxAmount(importTaxAmount);
        }

        return item;
    }
}
