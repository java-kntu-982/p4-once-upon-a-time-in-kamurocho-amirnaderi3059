package ir.ac.kntu.Object.Characters.Enemies;

import ir.ac.kntu.Object.Characters.Characters;
import ir.ac.kntu.Object.Objects;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

import javax.swing.*;
import java.util.LinkedList;

public class GraySoldier extends Enemy{
    static LinkedList<GraySoldier> graySoldiers = new LinkedList<>();

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
}
