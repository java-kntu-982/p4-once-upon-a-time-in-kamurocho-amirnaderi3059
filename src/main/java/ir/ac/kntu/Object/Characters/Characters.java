package ir.ac.kntu.Object.Characters;

import ir.ac.kntu.GamePlay.GameFlow;
import ir.ac.kntu.Object.HQ;
import ir.ac.kntu.Object.Objects;
import javafx.scene.shape.Shape;

import java.awt.*;
import java.util.LinkedList;

public abstract class Characters implements Objects {
    protected int health;
    protected int attack;
    protected int attackRange;
    protected static final int attackRangeCons = 5;
    protected Shape representative;



    public Characters(int health, int attack, int attackRange) {
        this.health = health;
        this.attack = attack;
        this.attackRange = attackRange;
    }

    public Characters(){}




    public abstract void movement(double destinationX,double destinationY);


    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public int getAttack() {
        return attack;
    }

    public void setAttack(int attack) {
        this.attack = attack;
    }

    public int getAttackRange() {
        return attackRange;
    }

    public void setAttackRange(int attackRange) {
        this.attackRange = attackRange;
    }
}
