package ir.ac.kntu.Object.Characters.Enemies;

import ir.ac.kntu.Object.Characters.Characters;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

public class BossLvl1 extends Enemy {

    private static BossLvl1 single_instance = null;
    private Circle representative = new Circle();

    private BossLvl1(int health,int attack,int attackRange){
        super(health ,attack,attackRange);
    }
    private BossLvl1() throws CloneNotSupportedException {
        super();
    }

    public void setEnemy() throws CloneNotSupportedException {
        BossLvl1.getInstance().setAttack(5000);
        BossLvl1.getInstance().setHealth(8000);
        BossLvl1.getInstance().ShapeSetter();
        BossLvl1.getInstance().setAttackRange(attackRangeCons);
    }

    public static BossLvl1 getInstance() throws CloneNotSupportedException {
        if(single_instance == null)
            single_instance = new BossLvl1();
        return single_instance;
    }

    @Override
    public void ShapeSetter() {
        representative.setFill(Color.DARKGREEN);
        representative.setRadius(10);
    }

    public Circle getRepresentative() {
        return representative;
    }

    public void setRepresentative(Circle representative) {
        this.representative = representative;
    }
}
