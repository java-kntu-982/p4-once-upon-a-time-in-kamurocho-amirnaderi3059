package ir.ac.kntu.Object;

import ir.ac.kntu.Organizer.Main;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;



public class Upgrade {
    protected static int money = 100;
    protected static Text amount = new Text();
    protected static Rectangle moneyBox = new Rectangle();

    public static void moneySetting(){
        Main.getRoot().getChildren().addAll(moneyBox);
        Main.getRoot().getChildren().addAll(amount);
        amount.setFont(Font.font("s", FontWeight.BOLD, FontPosture.ITALIC,15));
        amount.setX(800);
        amount.setY(30);
        amount.setFill(Color.WHITE);
        moneyBox.setX(790);
        moneyBox.setY(10);
        moneyBox.setHeight(30);
        moneyBox.setWidth(105);
        moneyBox.setOpacity(.2);
        moneyBox.setStroke(Color.WHITE);
        amount.setText("Money: " + money);
    }

    public static void earnMoney(){
        money+=100;
        amount.setText("Money: " + money);
    }

    public static boolean spendMoney(int reduction){
        if(money - reduction >= 0){
            money -= reduction;
            amount.setText("Money: " + money);
            return true;
        }else {
            return false;
        }

    }

}
