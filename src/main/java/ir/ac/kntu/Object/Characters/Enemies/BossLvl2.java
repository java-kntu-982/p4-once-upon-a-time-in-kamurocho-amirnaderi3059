package ir.ac.kntu.Object.Characters.Enemies;

import ir.ac.kntu.Object.Characters.Characters;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

public class BossLvl2 extends Enemy {
    private static BossLvl2 single_instance = null;
    private Circle representative = new Circle();

    private BossLvl2(int health,int attack,int attackRange){
        super(health ,attack,attackRange);
    }
    private BossLvl2() throws CloneNotSupportedException {
        super();
    }


    public void setEnemy() throws CloneNotSupportedException {
        BossLvl2.getInstance().setAttack(12000);
        BossLvl2.getInstance().setHealth(20000);
        BossLvl2.getInstance().ShapeSetter();
        BossLvl2.getInstance().setAttackRange(attackRangeCons);
    }

    public static BossLvl2 getInstance() throws CloneNotSupportedException {
        if(single_instance == null)
            single_instance = new BossLvl2();
        return single_instance;
    }

    @Override
    public void ShapeSetter() {
        representative.setFill(Color.DARKBLUE);
        representative.setRadius(10);
    }

    public Circle getRepresentative() {
        return representative;
    }

    public void setRepresentative(Circle representative) {
        this.representative = representative;
    }
}
