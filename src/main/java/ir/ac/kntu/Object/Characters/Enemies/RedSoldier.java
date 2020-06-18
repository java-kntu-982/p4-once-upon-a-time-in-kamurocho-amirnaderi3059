package ir.ac.kntu.Object.Characters.Enemies;


import javafx.scene.paint.Color;
import java.util.LinkedList;

public class RedSoldier extends Enemy{
    static LinkedList<RedSoldier> redSoldiers = new LinkedList<>();
    static LinkedList<RedSoldier> redSoldiers1 = new LinkedList<>();


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

    public static LinkedList<RedSoldier> getRedSoldiers1() {
        return redSoldiers1;
    }
}
