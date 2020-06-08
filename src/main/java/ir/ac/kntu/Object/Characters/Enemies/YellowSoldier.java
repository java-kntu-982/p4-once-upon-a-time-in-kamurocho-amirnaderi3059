package ir.ac.kntu.Object.Characters.Enemies;

import ir.ac.kntu.Object.Characters.Characters;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

import java.util.LinkedList;

public class YellowSoldier extends Enemy implements Cloneable{
    static LinkedList<YellowSoldier> yellowSoldiers = new LinkedList<>();

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
}
