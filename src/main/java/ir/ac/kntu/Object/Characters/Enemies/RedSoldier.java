package ir.ac.kntu.Object.Characters.Enemies;

import ir.ac.kntu.Object.Characters.Characters;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

import java.util.LinkedList;

public class RedSoldier extends Enemy{
    static LinkedList<RedSoldier> redSoldiers = new LinkedList<>();


    public RedSoldier(int health, int attack, int attackRange) {
        super(health, attack, attackRange);
    }





    @Override
    public void ShapeSetter() {
        representative.setFill(Color.RED);
        representative.setRadius(6);
    }


    public static LinkedList<RedSoldier> getRedSoldiers() {
        return redSoldiers;
    }
}
