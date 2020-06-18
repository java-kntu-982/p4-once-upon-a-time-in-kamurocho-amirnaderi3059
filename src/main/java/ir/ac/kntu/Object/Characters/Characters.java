package ir.ac.kntu.Object.Characters;


import ir.ac.kntu.Object.Objects;



public abstract class Characters implements Objects {
    protected int health;
    protected int attack;
    protected int attackRange;
    protected static final int attackRangeCons = 25;




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


    public void setAttackRange(int attackRange) {
        this.attackRange = attackRange;
    }

    public static int getAttackRangeCons() {
        return attackRangeCons;
    }
}
