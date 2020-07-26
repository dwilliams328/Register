package cash.register;

import java.util.ArrayList;

public class PrintReceipt {

    public void printItems(ArrayList list){
        for(int i = 0; i < list.size(); i++){
            System.out.println(list.get(i));
        }
    }
}
