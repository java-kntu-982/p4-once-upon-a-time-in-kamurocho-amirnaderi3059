package ir.ac.kntu.Object;

import javafx.scene.text.Text;

public class Upgrade {
    protected static int money = 100;
    protected Text amount = new Text();


    public void earnMoney(){

    }

    public static void spendMoney(int reduction){
        if(money - reduction >= 0){
            money -= reduction;
        }else {
            // not enough money
        }

    }

}
