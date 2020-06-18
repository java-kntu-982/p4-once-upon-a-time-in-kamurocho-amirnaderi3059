package ir.ac.kntu.Object.Characters.Enemies;


import javafx.scene.paint.Color;
import java.util.LinkedList;

public class YellowSoldier extends Enemy implements Cloneable{
    static LinkedList<YellowSoldier> yellowSoldiers = new LinkedList<>();
    static LinkedList<YellowSoldier> yellowSoldiers1 = new LinkedList<>();


    public YellowSoldier(int health, int attack, int attackRange) {
        super(health, attack, attackRange);
    }



    @Override
    public void ShapeSetter() {
        representative.setFill(Color.YELLOW);
        representative.setRadius(6);
    }



    public static LinkedList<YellowSoldier> getYellowSoldiers() {
        return yellowSoldiers;
    }

    public static LinkedList<YellowSoldier> getYellowSoldiers1() {
        return yellowSoldiers1;
    }
}
