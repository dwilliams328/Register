//This Class is a tool. It Accepts Objects, alters them if Tax application applicable ;)
package cash.register;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//Apply Base sales tax and Import tax on specific goods.
public class TaxCalculator {

    private static ArrayList<String> exemptItem;
    private static String importKey = "import";

    //On Instantiation, create exemptItem list
    //To Do - make exempt list and import key Case insensitive :)
    public TaxCalculator(){
        this.exemptItem = new ArrayList<>();
        this.exemptItem.add("book");
        this.exemptItem.add("pill");

        //Covers chocolate bar, imported box of chocolate etc.
        this.exemptItem.add("chocolate");
    }

    public static ScannedItem calculate(ScannedItem item){
        double saleTaxAmount = 0.0;
        double importTaxAmount = 0.0;
        //Check if goods are exempt
        int i = 0;
        boolean isExempt = false;

        while (i < TaxCalculator.exemptItem.size()){
            isExempt = item.getItem().contains(TaxCalculator.exemptItem.get(i));

            if(isExempt){
                break;
            }

            i++;
        }

        //If it's not exempt then apply basic sales tax
        if (!isExempt){
            saleTaxAmount = (item.getPrice() * .10);

            item.setSaleTaxAmount(saleTaxAmount);
        }

        //Check if good are imported
        boolean isImport = item.getItem().contains(TaxCalculator.importKey);

        //IF isImport != -1, then item is in list and therefore should have import taxes applied
        if(isImport){
            importTaxAmount = (item.getPrice() * .05);

            item.setImportTaxAmount(importTaxAmount);
        }

        item.itemTaxesApplied = (item.getSaleTaxAmount() + item.getImportTaxAmount());
        item.itemTotal = (item.getPrice() + item.itemTaxesApplied);

        item.grandTotal += item.itemTotal;
        item.grandTaxTotal += item.itemTaxesApplied;

        return item;
    }
}
