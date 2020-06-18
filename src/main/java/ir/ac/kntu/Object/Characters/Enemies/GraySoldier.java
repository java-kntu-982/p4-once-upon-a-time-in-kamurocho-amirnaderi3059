package ir.ac.kntu.Object.Characters.Enemies;


import javafx.scene.paint.Color;
import java.util.LinkedList;

public class GraySoldier extends Enemy{
    static LinkedList<GraySoldier> graySoldiers = new LinkedList<>();
    static LinkedList<GraySoldier> graySoldiers1 = new LinkedList<>();

    public GraySoldier(int health, int attack, int attackRange) {
        super(health, attack, attackRange);
    }



    @Override
    public void ShapeSetter(){
        representative.setFill(Color.GRAY);
        representative.setRadius(6);
    }

    public static LinkedList<GraySoldier> getGraySoldiers() {
        return graySoldiers;
    }

    public static LinkedList<GraySoldier> getGraySoldiers1() {
        return graySoldiers1;
    }
}

